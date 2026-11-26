import java.util.ArrayList;
import java.util.List;

public class EmployeeManager {
    private final ArrayList<FullTimeEmployee> fullTimeEmployees = new ArrayList<>();
    private final ArrayList<PartTimeEmployee> partTimeEmployees = new ArrayList<>();
    private final ArrayList<Intern> interns = new ArrayList<>();

    public void add(FullTimeEmployee employee) {
        checkNewEmployee(employee);
        fullTimeEmployees.add(employee);
    }

    public void add(PartTimeEmployee employee) {
        checkNewEmployee(employee);
        partTimeEmployees.add(employee);
    }

    public void add(Intern employee) {
        checkNewEmployee(employee);
        interns.add(employee);
    }

    private void checkNewEmployee(Employee employee) {
        if (employee == null) {
            throw new IllegalArgumentException("Angestellte Person fehlt.");
        }
        for (Employee existing : getAll()) {
            if (existing.getId() == employee.getId()) {
                throw new IllegalArgumentException("ID bereits vergeben: " + employee.getId());
            }
        }
    }

    public List<Employee> getAll() {
        ArrayList<Employee> result = new ArrayList<>();
        result.addAll(fullTimeEmployees);
        result.addAll(partTimeEmployees);
        result.addAll(interns);
        return result;
    }
}
