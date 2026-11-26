import java.util.Random;
import java.util.Scanner;

public class Zahlenratespiel {
    private static final int OBERGRENZE = 20;
    private static final int MAX_VERSUCHE = 5;

    public static void main(String[] args) {
        Random zufall = new Random();
        try (Scanner eingabe = new Scanner(System.in)) {
            boolean nochEineRunde;
            do {
                int geheimzahl = 1 + zufall.nextInt(OBERGRENZE);
                spieleRunde(eingabe, geheimzahl);
                System.out.print("Noch eine Runde? (j/n): ");
                nochEineRunde = eingabe.nextLine().trim().equalsIgnoreCase("j");
            } while (nochEineRunde);
        }
        System.out.println("Spiel beendet.");
    }

    private static void spieleRunde(Scanner eingabe, int geheimzahl) {
        System.out.println("Gesucht ist eine Zahl von 1 bis " + OBERGRENZE + ".");
        for (int versuch = 1; versuch <= MAX_VERSUCHE; versuch++) {
            System.out.print("Tipp " + versuch + "/" + MAX_VERSUCHE + ": ");
            int tipp = Integer.parseInt(eingabe.nextLine().trim());
            if (tipp == geheimzahl) {
                System.out.println("Richtig! Anzahl Versuche: " + versuch);
                return;
            }
            if (tipp < geheimzahl) {
                System.out.println("Zu klein.");
            } else {
                System.out.println("Zu gross.");
            }
        }
        System.out.println("Alle Versuche verbraucht. Gesucht war " + geheimzahl + ".");
    }
}
