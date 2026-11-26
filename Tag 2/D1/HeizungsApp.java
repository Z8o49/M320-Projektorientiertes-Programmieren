import java.util.Scanner;

public class HeizungsApp {
    public static void main(String[] args) {
        Scanner eingabe = new Scanner(System.in);
        Heizungszentrale zentrale = new Heizungszentrale();
        while (true) {
            zentrale.anzeigen();
            System.out.println("Zimmer und Solltemperatur eingeben, z.B. 1 22 (0 beendet):");
            if (!eingabe.hasNextLine()) return;
            String zeile = eingabe.nextLine().trim();
            if (zeile.equals("0")) return;
            String[] teile = zeile.split("\\s+");
            try {
                if (teile.length != 2) throw new IllegalArgumentException("Bitte zwei Zahlen eingeben.");
                zentrale.regeln(Integer.parseInt(teile[0]), Integer.parseInt(teile[1]));
            } catch (NumberFormatException e) {
                System.out.println("Bitte ganze Zahlen eingeben.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}

class Heizungszentrale {
    private final Heizung[] heizungen = {new Heizung("Wohnzimmer"), new Heizung("Schlafzimmer")};

    public void regeln(int nummer, int grad) {
        if (nummer < 1 || nummer > heizungen.length) throw new IllegalArgumentException("Unbekanntes Zimmer.");
        heizungen[nummer - 1].stelleEin(grad);
    }

    public void anzeigen() {
        for (int i = 0; i < heizungen.length; i++) {
            System.out.println((i + 1) + ". " + heizungen[i].beschreibung());
        }
    }
}

class Heizung {
    private final String raum;
    private int solltemperatur = 20;

    public Heizung(String raum) {
        this.raum = raum;
    }

    public void stelleEin(int grad) {
        if (grad < 16 || grad > 28) throw new IllegalArgumentException("Erlaubt sind 16 bis 28 Grad.");
        solltemperatur = grad;
    }

    public String beschreibung() {
        return raum + " | Solltemperatur " + solltemperatur + " °C";
    }
}
