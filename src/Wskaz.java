import java.util.Random;
import java.util.Scanner;
import java.io.Console;

public class Wskaz {
    public static int LiczbeZPzedialu(int min, int max){
        Scanner scan = new Scanner(System.in);
        int wskazanaLiczba;
        do {
            try {
                wskazanaLiczba = Integer.parseInt(scan.nextLine());
            } catch (NumberFormatException var7) {
                wskazanaLiczba = -1;
            }

            if (wskazanaLiczba < min || wskazanaLiczba > max) {
                System.out.print("Błędne dane. Wprowadź wartość od " + min  + " do " + max);
            }
        } while (wskazanaLiczba < min || wskazanaLiczba > max);
        return wskazanaLiczba;
    }
/*public static int LiczbeZPzedialu(int min, int max) {
    Console console = System.console();Wska
    if (console == null) {
        System.out.println("Nie można uzyskać dostępu do konsoli. Proszę użyć innego środowiska.");
        System.exit(1);
    }

    int wskazanaLiczba;
    do {
        char[] passwordChars = console.readPassword("Wprowadź liczbę od %d do %d: ", min, max);
        try {
            wskazanaLiczba = Integer.parseInt(new String(passwordChars));
        } catch (NumberFormatException var7) {
            wskazanaLiczba = -1;
        }

        if (wskazanaLiczba < min || wskazanaLiczba > max) {
            System.out.println("Błędne dane. Wprowadź liczbę od " + min + " do " + max);
        }
    } while (wskazanaLiczba < min || wskazanaLiczba > max);

    return wskazanaLiczba;
}*/

    public static int LiczbaWiekszaOd(int min){
        Scanner scan = new Scanner(System.in);
        int liczba;
        do {
            try {
                liczba = Integer.parseInt(scan.nextLine());
            } catch (NumberFormatException var7) {
                liczba = min -1;
            }

            if (liczba < min) {
                System.out.println("Błędne dane. Wprowadź wartość wieksza niz: " + min);
            }
        } while (liczba < min);
        return liczba;
    }

    public static int LosowanieLiczy(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min + 1) + min;
    }

}
