public final class PartTimeEmployee extends Employee {
    private double hourlyRate;
    private double hoursWorked;

    public PartTimeEmployee(int id, String name, double hourlyRate, double hoursWorked) {
        super(id, name);
        setHourlyRate(hourlyRate);
        setHoursWorked(hoursWorked);
    }

    public double getHourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(double hourlyRate) {
        if (!Double.isFinite(hourlyRate) || hourlyRate <= 0) {
            throw new IllegalArgumentException("Der Stundenlohn muss positiv sein.");
        }
        this.hourlyRate = hourlyRate;
    }

    public double getHoursWorked() {
        return hoursWorked;
    }

    public void setHoursWorked(double hoursWorked) {
        if (!Double.isFinite(hoursWorked) || hoursWorked < 0 || hoursWorked > 180) {
            throw new IllegalArgumentException("Erlaubt sind 0 bis 180 Stunden pro Monat.");
        }
        this.hoursWorked = hoursWorked;
    }

    @Override
    public double monthlyPay() {
        return hourlyRate * hoursWorked;
    }
}
