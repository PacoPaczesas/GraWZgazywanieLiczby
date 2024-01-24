import java.util.*;
import java.io.*;
public class Ustawienia {
    public static void MenuGry() {
        System.out.println("Witaj w grze w zgadywanie liczby!");
        System.out.println("Rozgrywka polega na odgadnięciu liczby wskazanej przez innego gracza lub komputer. Wygrywa ten, kto pierwszy odgadnie wskazaną liczbę.");
        System.out.println("Gra jest możliwa dla jednego gracza (przeciwko komputerowi) ale również dla większej (wskazanej przez użytkownika) licznie graczy.");
        System.out.println("WAŻNE: Sposobem komunikowania się z grą jest wprowadzanie liczb całkowitych (np. 1; 2; 10) i zatwierdzanie ich poprzez kliknięcie przycisku ENTER. W jednym miejscu gra poprosi o wprowadzenie nickname - tutaj można użyć liter");
        System.out.println("A więc zaczynajmy, POWODZENIA.");
    }

    public static int TrybGry() {
        System.out.println("Wybierz tryb gry");
        System.out.println("1. JEDEN GRACZ - rozgrywka jeden na jeden z symulowanym przez komputer przeciwnikiem");
        System.out.println("2: ROZGRYWKA WIELOOSOBOWA – dla dwóch i więcej graczy");
        System.out.println("3: LISTA WYNIKÓW - wyświetl listę wyników dla rozgrywek wieloosobowych");
        System.out.println("4: TRYB TURNIEJOWY - rozgrywka w grupach a następnie drabinką wyłaniająca MISTRZA");
        System.out.println("5: Wyświetl aktualnego i poprzednich mistrzów");
        System.out.println("6: WYJDŹ - zakończ gre");
        Scanner scan = new Scanner(System.in);

        int trybGry = Wskaz.LiczbeZPzedialu(1, 6);
        // TODO dopisać co wybrano
        System.out.println("TODO dopisac co wybrano");

        return trybGry;
    }


    public static int LiczbaGraczy(int trybGry) {
        Scanner scan = new Scanner(System.in);

        int iloscGraczy;
        do {
            System.out.print("Wprowadź ilość graczy: ");
            try {
                iloscGraczy = Integer.parseInt(scan.nextLine());
            } catch (NumberFormatException var9) {
                iloscGraczy = -1;
            }
            if (iloscGraczy < 2) {
                if (trybGry == 4) {
                    System.out.println("Błędna wartość. Wybrano tryb turniejowy. Minimalna liczba graczy ludzkich jaką podajesz to 2. Pozostali gracze (minimum 6 wymaganych do rozegrania turnieju) zostanie uzupełniona przez graczy sterowanych przez komputer.");
                } else {
                    System.out.println("Błędna wartość. Minimalna ilość graczy to 2");
                }
            }
            if (iloscGraczy > 4) {
                System.out.println("Ilość graczy jest większa niż 4. Gra zadziała przy większej ilości ale ze względu na dynamikę rozgrywki ilość graczy większa niż 4 nie jest rekomendowana");
                System.out.println("Czy na pewno ilość graczy ma wynosić: " + iloscGraczy);
                System.out.println("1: Tak, ilość graczy ma wynosić: " + iloscGraczy + ". Dynamika rozgrywki nie jest istotna.");
                System.out.println("2. Nie, wprowadzę inną ilość graczy");
                int potwierdzenie;
                do {
                    try {
                        potwierdzenie = Integer.parseInt(scan.nextLine());
                    } catch (NumberFormatException var8) {
                        potwierdzenie = -1;
                    }

                    if (potwierdzenie != 1 && potwierdzenie != 2) {
                        System.out.println("Błędne dane. Wprowadź:");
                        System.out.println("1: Tak, ilość graczy ma wynosić :" + iloscGraczy + ". Dynamika rozgrywki nie jest istotna.");
                        System.out.println("2. Nie, wprowadzę inną ilość graczy");
                    }

                    if (potwierdzenie == 2) {
                        iloscGraczy = -1;
                    }
                } while (potwierdzenie != 1 && potwierdzenie != 2);
            }
        } while (iloscGraczy < 2);
        System.out.println("Ilość graczy: " + iloscGraczy);
        return iloscGraczy;
    }

    public static int[] PoziomTrudnosci() {
        int[] minMax = new int[3];

        System.out.println("Wybierzpoziom trudności");
        System.out.println("1. ŁATWY - zakres losowanych liczb 1 - 100");
        System.out.println("2: ŚREDNI - zakres losowanych liczb 1 - 10 000");
        System.out.println("3: TRUDNY - zakres losowanych liczb 1 - 1 000 000");
        System.out.println("4: WŁASNY - wskaz zakres losowanych liczb");
        System.out.print("Wybierzpoziom trudności wprowadzając 1, 2, 3 lub 4:");

        int poziomTrudnosci = Wskaz.LiczbeZPzedialu(1, 4);

        switch (poziomTrudnosci) {
            case 1:
                minMax[0] = 1;
                minMax[1] = 100;
                minMax[2] = 1;
                System.out.println("Wybrano poziom ŁĄTWY. Zakres liczb od 1 do 100");
                break;
            case 2:
                minMax[0] = 1;
                minMax[1] = 10000;
                minMax[2] = 2;
                System.out.println("Wybrano poziom ŚREDNI. Zakres liczb od 1 do 10 000");
                break;
            case 3:
                minMax[0] = 1;
                minMax[1] = 1000000;
                minMax[2] = 3;
                System.out.println("Wybrano poziom TRUDNY. Zakres liczb od 1 do 1 000 000");
                break;
            case 4:
                System.out.print("wskaz liczbe wieksza od 0 od jakiej zaczynac ma się przedział zgadywanych liczb (zalecane 1): ");
                minMax[0] = Wskaz.LiczbaWiekszaOd(0);
                System.out.print("Wskkaz liczbe na jakiej konczyc ma sie przedział zgadywanych liczb: ");
                minMax[1] = Wskaz.LiczbaWiekszaOd(minMax[0] + 1);
                minMax[2] = 4;
                System.out.println("Wybrano poziom WŁASNY. Zakres liczb od " + minMax[0] + " do " + minMax[1]);

                break;
        }
        return minMax;
    }

    public static String KonwersjaPoziomuTrudnosciNaString(int poziomInt) {
        String poziomString = "";
        switch (poziomInt) {
            case 1:
                poziomString = "Łatwy";
                break;
            case 2:
                poziomString = "Średni";
                break;
            case 3:
                poziomString = "Trudny";
                break;
            case 4:
                poziomString = "Własny";
                break;
        }
        return poziomString;
    }

    public static List<Gracze> StworzGraczy(int liczbaGraczy, int LiczbaGraczyLudzi, int liczbaGraczyAI, int min, int max) {
        Scanner scanner = new Scanner(System.in);
        int nrGracza;
        List<Gracze> Uczestnicy = new ArrayList<>();
        for (int i = 0; i < liczbaGraczy; i++) {
            nrGracza = i + 1;

            if (i < LiczbaGraczyLudzi) {
                System.out.println("Tworzenie gracza nr: " + nrGracza);
                System.out.print("Wprowadż imie gracza nr " + nrGracza + " ");
                Gracze nowyGracz = new Gracze();
                nowyGracz.name = scanner.next();
                nowyGracz.isAi = false;
                nowyGracz.min = min;
                nowyGracz.max = max;
                System.out.print("Podaj swoją liczbę z przediału " + min + " do " + max + " którą odgadnąć będzie miał inny gracz");
                nowyGracz.myNumber = Wskaz.LiczbeZPzedialu(min, max);
                Uczestnicy.add(nowyGracz);
                System.out.println("Gracz nr " + nrGracza + " został utworzony.");
            } else {
                System.out.println("graczAI");
                Gracze nowyGracz = new Gracze();
                nowyGracz.name = "Gracz AI";
                nowyGracz.isAi = true;
                nowyGracz.min = min;
                nowyGracz.max = max;
                nowyGracz.myNumber = Wskaz.LosowanieLiczy(min, max);
                Uczestnicy.add(nowyGracz);
            }
        }
        return Uczestnicy;
    }

    public static int[] LiczbaGraczyTurniej() {
        System.out.println("WYBRANO TRYB TURNIEJOWY");
        System.out.println("Rozgrywka polega na rywalizowaniu par graczy w rozgdywkach potocznie nazywanych drabinką. Rozgrywka w parze toczyć się będzie do wskazanej liczby zwicięstw (np. BO1, BO3, BO5).");
        System.out.println("Zwycięzca pary przechodzi do następnej fazy turnieju. Przegrany odpada. Gra toczy się aż do momentu gry jeden z graczy pokona drugioego ostatniego gracza w finale");
        System.out.println("Wygrany gracz otrzymuje tytuł MISTRZA, który zapewnia pewne bonusy. Podczas rozgdywki pewien niewielki bonnus przysługuje również liderowi danej pary");
        System.out.println("Przewaga MISTRZA: standardowo gra dopuszcza możliwość remisu kiedy w tej samej turze oboje gracze wskazują prawidłową liczbę. W takiej sytuacji w trybie turniejowym nikt nie wygrywa. Chyba, że mowa o mistrzu. W razie remisu to mistrz zgobywa punkt");
        System.out.println("przewagą lidera jest to, że system pilnuje przediału maksymalnej i minimalnej wartości. Jeżeli np. podczas pierwszej kolejko wskażesz wartość 20 i okaże się ona za mała w kolejnej wartości nawet jeżeli będziech chciał, nie będziesz w stanie wskazać wartości mniejszej lub równej jak 20");

        int[] tablicaZLiczbaGraczy = new int[3];
        int liczbaGraczy = 0;
        int liczbaGraczyLudzi = 0;
        int liczbaGraczyAI = 0;

        System.out.println("Na początek ustalimy ilość uczestników turnieju");
        System.out.println("Liczba wszystkich uczestników musi być kolejną potęgą liczby dwa. Ilość luczkich uczestników to minimum 3 osoby. W przypadku mniejszej liczby ludzkich graczy niż wymagana liczba uczestników (kolejna potęga liczby 2) gracze zostaną uzupełnieni przez graczy kierowanych przez komputer");


        Scanner scan = new Scanner(System.in);
        do {
            try {
                System.out.println("Podaj liczbę liczkich graczy");
                liczbaGraczyLudzi = Integer.parseInt(scan.nextLine());
            } catch (NumberFormatException var9) {
                liczbaGraczyLudzi = -1;
            }
            if (liczbaGraczyLudzi < 3) {
                System.out.println("Błędna wartość. Wybrano tryb turniejowy. Minimalna liczba graczy ludzkich to to 3. Pozostali gracze (minimum 4 wymaganych do rozegrania turnieju) zostanie uzupełniona przez graczy sterowanych przez komputer.");
            }
            if (liczbaGraczyLudzi > 8) {
                System.out.println("Ilość graczy jest większa niż 8. Gra zadziała przy większej ilości ale ze względu na dynamikę rozgrywki ilość graczy większa niż 8 nie jest rekomendowana");
                System.out.println("Czy na pewno ilość graczy ma wynosić: " + liczbaGraczyLudzi);
                System.out.println("1: Tak, ilość luczkich graczy ma wynosić: " + liczbaGraczyLudzi + ". Dynamika rozgrywki nie jest istotna.");
                System.out.println("2. Nie, wprowadzę inną ilość graczy");
                int potwierdzenie;

                do {
                    try {
                        potwierdzenie = Integer.parseInt(scan.nextLine());
                    } catch (NumberFormatException var8) {
                        potwierdzenie = -1;
                    }

                    if (potwierdzenie != 1 && potwierdzenie != 2) {
                        System.out.println("Błędne dane. Wprowadź:");
                        System.out.println("1: Tak, ilość graczy ma wynosić :" + liczbaGraczyLudzi + ". Dynamika rozgrywki nie jest istotna.");
                        System.out.println("2. Nie, wprowadzę inną ilość graczy");
                    }

                    if (potwierdzenie == 2) {
                        liczbaGraczyLudzi = -1;
                    }
                } while (potwierdzenie != 1 && potwierdzenie != 2);
            }
        } while (liczbaGraczyLudzi < 3);

        double suma = 0;
        for (int i = 2; liczbaGraczyLudzi > suma; i++) {
            suma = Math.pow(2, i);
        }
        int sumaInt = (int) suma;
        liczbaGraczy = sumaInt;
        liczbaGraczyAI = liczbaGraczy - liczbaGraczyLudzi;

        tablicaZLiczbaGraczy[0] = liczbaGraczy;
        tablicaZLiczbaGraczy[1] = liczbaGraczyLudzi;
        tablicaZLiczbaGraczy[2] = liczbaGraczyAI;
        return tablicaZLiczbaGraczy;
    }




}