import javax.xml.namespace.QName;
import java.util.ArrayList;
import java.util.List;

public class Rozgrywka {

    public static void RozgrywkaStandardowa(List<Gracze> uczestnicy, int min, int max) {
        int proba = 0;
        int kolejGracza;
        int szukanaLiczba;
        boolean graTrwaDalej = true;
        Gracze graczA = null;
        Gracze graczB = null;

        while(graTrwaDalej) {
            for (int i = 0; i < uczestnicy.size(); i++) {
                if (i == uczestnicy.size() - 1) {
                    graczA = uczestnicy.get(i);
                    graczB = uczestnicy.get(0);
                } else {
                    graczA = uczestnicy.get(i);
                    graczB = uczestnicy.get(i + 1);
                }
                kolejGracza = i + 1;
                System.out.println("Kolej gracza: " + graczA.name);
                System.out.println("Spróbuj odnagnąć liczbę podaną przez kolejnego gracza: ");

                szukanaLiczba = graczB.myNumber;

                if (graczA.isAi == false) {
                    proba = Wskaz.LiczbeZPzedialu(min, max);
                }else{
                    proba = Wskaz.LosowanieLiczy(graczA.min, graczA.max);
                }
                System.out.println(graczA.name + " zgaduje, że jest to liczba " + proba);

                if (proba == szukanaLiczba) {
                    if (kolejGracza < uczestnicy.size()){
                        System.out.println("Brawo wygrałeś. To prawidłowa liczba Ale aby było uczciwie dajmy dokończyć tą kolejkę jeszcze innym graczą. Do końca kolejki mają szansę na odgadnięcie prawidłowej liczby i wygranie gry razem z tobą");
                        graczA.isWinner = true;
                        graTrwaDalej = false;
                    } else {
                        System.out.println("Brawo, wygrales. To prawidłowa liczba");
                        graTrwaDalej = false;
                        graczA.isWinner = true;
                    }

                } else if (proba < szukanaLiczba) {
                    System.out.println("Za mało. Następnym razem spróbuj podać większą wartość");
                    if (graczA.isAi){
                        graczA.min = proba;
                    }
                } else {
                    System.out.println("Za dużo. Następnym razem spróbuj mniejszą wartość");
                    if (graczA.isAi){
                        graczA.max = proba;
                    }
                }
            }
        }
    }

    public static void RozgrywkaTurniejowa(List<Gracze> uczestnicy, int min, int max) {
        Gracze gracz1 = null;
        Gracze gracz2 = null;
        Gracze winner = null;
        int bo = 1;

        while (uczestnicy.size() > 1){
            List<Gracze> kolejnaRunda = new ArrayList<>();
            for (int i = 0; i < uczestnicy.size(); i +=2){
                System.out.println("Para gracza nr " + (i+1) + " oraz " + (i+2));
                gracz1 = uczestnicy.get(i);
                gracz2 = uczestnicy.get(i+1);
                winner = Rozgrywka.RozgrywkaDlaPary(gracz1, gracz2, bo, min, max);
                kolejnaRunda.add(winner);
            }
            uczestnicy = kolejnaRunda;
            }
        }





    public static Gracze RozgrywkaDlaPary(Gracze graczA, Gracze graczB, int bo, int min, int max){
        Gracze winner = null;
        int proba;
        int szukanaLiczba;
        boolean graTrwaDalej = true;

        List<Gracze> uczestnicy = new ArrayList<>();
        uczestnicy.add(graczA);
        uczestnicy.add(graczB);

        while(graTrwaDalej) {
            for (int i = 0; i < uczestnicy.size(); i++) {
                if (i == uczestnicy.size() - 1) {
                    graczA = uczestnicy.get(i);
                    graczB = uczestnicy.get(0);
                } else {
                    graczA = uczestnicy.get(i);
                    graczB = uczestnicy.get(i + 1);
                }

                System.out.println("Kolej gracza: " + graczA.name);
                System.out.println("Spróbuj odnagnąć liczbę podaną przez Twojego przeciwnika: ");
                szukanaLiczba = graczB.myNumber;

                if (graczA.isAi == false) {
                    proba = Wskaz.LiczbeZPzedialu(min, max);
                }else{
                    proba = Wskaz.LosowanieLiczy(graczA.min, graczA.max);
                }
                System.out.println(graczA.name + " zgaduje, że jest to liczba " + proba);

                if (proba == szukanaLiczba) {
                    if (i == 0){
                        System.out.println("To prawidłowa liczba. Twój przeciwnik ma jeszcze szansę na remis");
                        graczA.isWinner = true;
                        graTrwaDalej = false;
                    } else {
                        System.out.println("Brawo, wygrales. To prawidłowa liczba");
                        graTrwaDalej = false;
                        graczA.isWinner = true;
                    }



                } else if (proba < szukanaLiczba) {
                    System.out.println("Za mało. Następnym razem spróbuj podać większą wartość");
                    if (graczA.isAi){
                        graczA.min = proba;
                    }
                } else {
                    System.out.println("Za dużo. Następnym razem spróbuj mniejszą wartość");
                    if (graczA.isAi){
                        graczA.max = proba;
                    }
                }
            }
            if ((graczA.isWinner == true) && (graczB.isWinner == true)){
                graTrwaDalej = true;
            }
        }

        return graczA;
    }




}
