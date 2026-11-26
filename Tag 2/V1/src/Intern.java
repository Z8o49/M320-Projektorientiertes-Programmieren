public final class Intern extends Employee {
    private double fixedMonthlyPay;
    private double maxHours;
    private double hoursWorked;

    public Intern(int id, String name, double fixedMonthlyPay, double maxHours, double hoursWorked) {
        super(id, name);
        setFixedMonthlyPay(fixedMonthlyPay);
        setMaxHours(maxHours);
        setHoursWorked(hoursWorked);
    }

    public double getFixedMonthlyPay() {
        return fixedMonthlyPay;
    }

    public void setFixedMonthlyPay(double fixedMonthlyPay) {
        if (!Double.isFinite(fixedMonthlyPay) || fixedMonthlyPay < 0) {
            throw new IllegalArgumentException("Der Monatslohn muss mindestens 0 betragen.");
        }
        this.fixedMonthlyPay = fixedMonthlyPay;
    }

    public double getMaxHours() {
        return maxHours;
    }

    public void setMaxHours(double maxHours) {
        if (!Double.isFinite(maxHours) || maxHours <= 0 || maxHours < hoursWorked) {
            throw new IllegalArgumentException("Das Stundenlimit muss positiv sein und die geleisteten Stunden abdecken.");
        }
        this.maxHours = maxHours;
    }

    public double getHoursWorked() {
        return hoursWorked;
    }

    public void setHoursWorked(double hoursWorked) {
        if (!Double.isFinite(hoursWorked) || hoursWorked < 0 || hoursWorked > maxHours) {
            throw new IllegalArgumentException("Die Stunden müssen zwischen 0 und dem Stundenlimit liegen.");
        }
        this.hoursWorked = hoursWorked;
    }

    @Override
    public double monthlyPay() {
        return fixedMonthlyPay;
    }
}
