public class Main {
    public static void main(String[] args) {
        EmployeeManager manager = new EmployeeManager();
        FullTimeEmployee lea = new FullTimeEmployee(1, "Lea", 5500, 300, true);
        PartTimeEmployee noah = new PartTimeEmployee(2, "Noah", 32, 60);
        Intern mina = new Intern(3, "Mina", 1200, 120, 100);
        manager.add(lea);
        manager.add(noah);
        manager.add(mina);

        System.out.println("ID | Name | Anstellung | Monatslohn");
        for (Employee employee : manager.getAll()) {
            System.out.printf("%d | %s | %s | %.2f CHF%n", employee.getId(),
                    employee.getName(), employee.getClass().getSimpleName(), employee.monthlyPay());
        }
        noah.setHoursWorked(70);
        System.out.printf("Nach der Korrektur auf 70 Stunden erhält Noah %.2f CHF.%n", noah.monthlyPay());
        try {
            mina.setHoursWorked(121);
        } catch (IllegalArgumentException e) {
            System.out.println("Eingabe abgelehnt: " + e.getMessage());
        }
    }
}
