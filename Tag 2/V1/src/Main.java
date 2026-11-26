import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        EmployeeManager manager = new EmployeeManager();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Angestelltenverwaltung ---");
            System.out.println("1. Vollzeitperson hinzufügen");
            System.out.println("2. Teilzeitperson hinzufügen");
            System.out.println("3. Praktikant/in hinzufügen");
            System.out.println("4. Alle Angestellten anzeigen");
            System.out.println("5. Arbeitsstunden ändern");
            System.out.println("0. Beenden");

            try {
                int wahl = liesGanzzahl(scanner, "Auswahl");

                switch (wahl) {
                    case 1:
                        manager.add(new FullTimeEmployee(
                                liesGanzzahl(scanner, "ID"),
                                liesText(scanner, "Name"),
                                liesZahl(scanner, "Monatslohn in CHF"),
                                liesZahl(scanner, "Bonusbetrag in CHF"),
                                liesJaNein(scanner, "Bonusberechtigt")
                        ));
                        System.out.println("Vollzeitperson hinzugefügt.");
                        break;

                    case 2:
                        manager.add(new PartTimeEmployee(
                                liesGanzzahl(scanner, "ID"),
                                liesText(scanner, "Name"),
                                liesZahl(scanner, "Stundenlohn in CHF"),
                                liesZahl(scanner, "Geleistete Stunden")
                        ));
                        System.out.println("Teilzeitperson hinzugefügt.");
                        break;

                    case 3:
                        manager.add(new Intern(
                                liesGanzzahl(scanner, "ID"),
                                liesText(scanner, "Name"),
                                liesZahl(scanner, "Fester Monatslohn in CHF"),
                                liesZahl(scanner, "Maximale Stunden"),
                                liesZahl(scanner, "Geleistete Stunden")
                        ));
                        System.out.println("Praktikant/in hinzugefügt.");
                        break;

                    case 4:
                        zeigeAngestellte(manager);
                        break;

                    case 5:
                        aendereStunden(scanner, manager);
                        break;

                    case 0:
                        System.out.println("Programm beendet.");
                        return;

                    default:
                        System.out.println("Bitte eine Zahl von 0 bis 5 wählen.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Ungültige Zahl. Für Menü und ID bitte ganze Zahlen eingeben.");
            } catch (IllegalArgumentException e) {
                System.out.println("Eingabe abgelehnt: " + e.getMessage());
            }
        }
    }

    private static void zeigeAngestellte(EmployeeManager manager) {
        var angestellte = manager.getAll();

        if (angestellte.isEmpty()) {
            System.out.println("Es sind noch keine Angestellten erfasst.");
            return;
        }

        System.out.println("ID | Name | Anstellung | Monatslohn");
        for (Employee person : angestellte) {
            System.out.printf("%d | %s | %s | %.2f CHF%n",
                    person.getId(), person.getName(),
                    person.getClass().getSimpleName(), person.monthlyPay());
        }
    }

    private static void aendereStunden(Scanner scanner, EmployeeManager manager) {
        int id = liesGanzzahl(scanner, "ID der Person");

        for (Employee person : manager.getAll()) {
            if (person.getId() == id) {
                if (person instanceof PartTimeEmployee teilzeit) {
                    teilzeit.setHoursWorked(liesZahl(scanner, "Neue Gesamtstunden"));
                } else if (person instanceof Intern praktikant) {
                    praktikant.setHoursWorked(liesZahl(scanner, "Neue Gesamtstunden"));
                } else {
                    System.out.println("Für Vollzeitangestellte werden keine Stunden erfasst.");
                    return;
                }

                System.out.printf("Stunden aktualisiert. Monatslohn: %.2f CHF%n",
                        person.monthlyPay());
                return;
            }
        }

        System.out.println("Keine Person mit der ID " + id + " gefunden.");
    }

    private static String liesText(Scanner scanner, String frage) {
        System.out.print(frage + ": ");
        return scanner.nextLine().trim();
    }

    private static int liesGanzzahl(Scanner scanner, String frage) {
        return Integer.parseInt(liesText(scanner, frage));
    }

    private static double liesZahl(Scanner scanner, String frage) {
        return Double.parseDouble(liesText(scanner, frage).replace(',', '.'));
    }

    private static boolean liesJaNein(Scanner scanner, String frage) {
        while (true) {
            String antwort = liesText(scanner, frage + " (ja/nein)");
            if (antwort.equalsIgnoreCase("ja")) return true;
            if (antwort.equalsIgnoreCase("nein")) return false;
            System.out.println("Bitte ja oder nein eingeben.");
        }
    }
}