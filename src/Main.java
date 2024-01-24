import java.io.*;
import java.util.*;
import java.io.Console;

public class Main {

    public static void main(String[] args) {



        Ustawienia.MenuGry();

        int trybGry = Ustawienia.TrybGry(); // TrybGry deklaruje wybór opcji z menu. Najczęściej rodzaj rozgrywki, czasem wyświetlanie wyników lub wyjkście.
        int liczbaGraczy;
        int liczbaGraczyAI;
        int liczbaGraczyLudzi;
        int min;
        int max;
        String poziomTrudnosci;
        int[] minMax = new int[3];
        List<Gracze> uczestnicy = new ArrayList<>();


        switch (trybGry){
            case 1:
                liczbaGraczy = 2;
                liczbaGraczyAI = 1;
                liczbaGraczyLudzi = 1;
                minMax = Ustawienia.PoziomTrudnosci();
                min = minMax[0];
                max = minMax[1];
                poziomTrudnosci = Ustawienia.KonwersjaPoziomuTrudnosciNaString(minMax[2]);

                uczestnicy = Ustawienia.StworzGraczy(liczbaGraczy, liczbaGraczyLudzi, liczbaGraczyAI, min, max);

                for (Gracze gracz : uczestnicy) {
                    System.out.println(gracz.name);
                    System.out.println(gracz.isAi);
                }

                Rozgrywka.RozgrywkaStandardowa(uczestnicy, min, max);


                break;
            case 2:
                liczbaGraczy = Ustawienia.LiczbaGraczy(trybGry);
                liczbaGraczyLudzi = liczbaGraczy;
                liczbaGraczyAI = 0;
                minMax = Ustawienia.PoziomTrudnosci();
                min = minMax[0];
                max = minMax[1];
                poziomTrudnosci = Ustawienia.KonwersjaPoziomuTrudnosciNaString(minMax[2]);


                uczestnicy = Ustawienia.StworzGraczy(liczbaGraczy, liczbaGraczyLudzi, liczbaGraczyAI, min, max);
                Rozgrywka.RozgrywkaStandardowa(uczestnicy, min, max);
                break;

            case 3:
                System.out.println();
                break;

            case 4:
                System.out.println("Wybrano tryb tudniejowy. Minimalna liczba uczestników to: 6. W przypadku mniejszej liczby graczy rozgrywka zostanie uzupełniona o graczy sterowanych przez komputer");
                System.out.println("Gracze zostaną podzieleni na dwie grupy. Na początku rozgdywka będzie toczyć się pomiędzy uczestnikami pierwszej grupy. Pierwsza i druga osoba w danej grupie, która odganie prawidłową cyfrę zapewni sobie miejsce w półfinale");
                System.out.println("Po ustaleniu półfinalistów z grupy pierwsze rozgrywka toczyć się będzie między uczestnikami z grupy drugiej");
                System.out.println("Wskaż liczbę zwycięstw, jakie będą wymagane do awansu przy udziale w drabince. Zalecamy grę do 3 zwycięstw.");
                System.out.println("Lider, który prowadzić będzie w danej parze uzuska przywilej w kolejnej turze możliwości dokonania dwóch wskazań cyfry zamiast jednego");

                minMax = Ustawienia.PoziomTrudnosci();
                min = minMax[0];
                max = minMax[1];
                poziomTrudnosci = Ustawienia.KonwersjaPoziomuTrudnosciNaString(minMax[2]);
                int[] tablicaZLiczbaGraczy = new int[3];
                tablicaZLiczbaGraczy = Ustawienia.LiczbaGraczyTurniej();
                liczbaGraczyAI = tablicaZLiczbaGraczy[2];
                liczbaGraczyLudzi = tablicaZLiczbaGraczy[1];
                liczbaGraczy = tablicaZLiczbaGraczy[0];
                System.out.println("liczba graczy ai " + liczbaGraczyAI);
                System.out.println("liczba graczy ludzkich " + liczbaGraczyLudzi);
                System.out.println("liczba graczy " + liczbaGraczy);
                uczestnicy = Ustawienia.StworzGraczy(liczbaGraczy, liczbaGraczyLudzi, liczbaGraczyAI, min, max);
                Rozgrywka.RozgrywkaTurniejowa(uczestnicy, min, max);
                break;

            case 5:
                System.out.println();
                break;

            case 6:
                System.out.println();
                break;

            case 7:
                System.out.println();
                break;
        }


/*        for (Gracze gracz : uczestnicy) {
            System.out.println(gracz.name);
        }*/


    }
}
