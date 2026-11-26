public final class FullTimeEmployee extends Employee {
    private double monthlySalary;
    private double bonusAmount;
    private boolean bonusEligible;

    public FullTimeEmployee(int id, String name, double monthlySalary, double bonusAmount, boolean bonusEligible) {
        super(id, name);
        setMonthlySalary(monthlySalary);
        setBonusAmount(bonusAmount);
        setBonusEligible(bonusEligible);
    }

    public double getMonthlySalary() {
        return monthlySalary;
    }

    public void setMonthlySalary(double monthlySalary) {
        if (!Double.isFinite(monthlySalary) || monthlySalary <= 0) {
            throw new IllegalArgumentException("Der Monatslohn muss positiv sein.");
        }
        this.monthlySalary = monthlySalary;
    }

    public double getBonusAmount() {
        return bonusAmount;
    }

    public void setBonusAmount(double bonusAmount) {
        if (!Double.isFinite(bonusAmount) || bonusAmount < 0) {
            throw new IllegalArgumentException("Der Bonus muss mindestens 0 betragen.");
        }
        this.bonusAmount = bonusAmount;
    }

    public boolean isBonusEligible() {
        return bonusEligible;
    }

    public void setBonusEligible(boolean bonusEligible) {
        this.bonusEligible = bonusEligible;
    }

    @Override
    public double monthlyPay() {
        return monthlySalary + (bonusEligible ? bonusAmount : 0);
    }
}
