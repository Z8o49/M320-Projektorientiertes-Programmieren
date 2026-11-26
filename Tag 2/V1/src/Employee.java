public abstract class Employee {
    private final int id;
    private String name;

    protected Employee(int id, String name) {
        if (id <= 0) {
            throw new IllegalArgumentException("Die ID muss positiv sein.");
        }
        this.id = id;
        setName(name);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public final void setName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Der Name darf nicht leer sein.");
        }
        this.name = name.strip();
    }

    public abstract double monthlyPay();
}
