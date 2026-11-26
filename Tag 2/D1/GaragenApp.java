import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class GaragenApp {
    public static void main(String[] args) {
        Scanner eingabe = new Scanner(System.in);
        Garage garage = new Garage();
        while (true) {
            System.out.println("1 Registrieren | 2 Reparatur abschliessen | 3 Übersicht | 0 Ende");
            if (!eingabe.hasNextLine()) return;
            String wahl = eingabe.nextLine().trim();
            if (wahl.equals("0")) return;
            if (wahl.equals("3")) {
                garage.anzeigen();
                continue;
            }
            if (!wahl.equals("1") && !wahl.equals("2")) {
                System.out.println("Bitte eine Menüoption wählen.");
                continue;
            }
            System.out.println("Kontrollschild (z.B. ZH123):");
            if (!eingabe.hasNextLine()) return;
            String schild = eingabe.nextLine().trim().toUpperCase(java.util.Locale.ROOT);
            try {
                if (wahl.equals("1")) {
                    garage.registrieren(schild);
                } else {
                    System.out.println("Reparaturkosten in ganzen Franken:");
                    if (!eingabe.hasNextLine()) return;
                    int kosten = Integer.parseInt(eingabe.nextLine().trim());
                    garage.reparieren(schild, kosten);
                }
                garage.anzeigen();
            } catch (NumberFormatException e) {
                System.out.println("Bitte ganze Franken eingeben.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}

class Garage {
    private final Map<String, Fahrzeug> fahrzeuge = new LinkedHashMap<>();

    public void registrieren(String schild) {
        if (schild.isBlank()) throw new IllegalArgumentException("Kontrollschild fehlt.");
        if (fahrzeuge.containsKey(schild)) throw new IllegalArgumentException("Fahrzeug bereits registriert.");
        fahrzeuge.put(schild, new Fahrzeug());
    }

    public void reparieren(String schild, int kosten) {
        Fahrzeug fahrzeug = fahrzeuge.get(schild);
        if (fahrzeug == null) throw new IllegalArgumentException("Unbekanntes Fahrzeug.");
        fahrzeug.reparaturAbschliessen(kosten);
    }

    public void anzeigen() {
        if (fahrzeuge.isEmpty()) System.out.println("Keine Fahrzeuge registriert.");
        fahrzeuge.forEach((schild, fahrzeug) -> System.out.println(schild + " | " + fahrzeug.status()));
    }
}

class Fahrzeug {
    private boolean repariert;
    private int reparaturkosten;

    public void reparaturAbschliessen(int kosten) {
        if (repariert) throw new IllegalArgumentException("Reparatur bereits abgeschlossen.");
        if (kosten < 0) throw new IllegalArgumentException("Kosten müssen mindestens 0 CHF betragen.");
        reparaturkosten = kosten;
        repariert = true;
    }

    public String status() {
        if (repariert) return "repariert | " + reparaturkosten + " CHF";
        return "Reparatur offen";
    }
}
