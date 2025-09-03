public class EmployeeCSVAdapter implements Employee {
    EmployeeCSV e;

    @Override
    public String getId() {
        return e.tokens()[0];
    }

    @Override
    public String getFirstName() {
        return e.tokens()[1];
    }

    @Override
    public String getLastName() {
        return e.tokens()[2];
    }

    @Override
    public String getEmail() {
        return e.tokens()[4];
    }
}
