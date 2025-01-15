public class ManagerClass extends EmployeeClass {
    // Field
    private String department;

    // Constructor
    public ManagerClass(String firstName, String lastName, int employeeID, String department) {
        super(firstName, lastName, employeeID);
        this.department = department;
    }

    // Setter and getter for department
    public void setDepartment(String department) {
        this.department = department;
    }

    public String getDepartment() {
        return this.department;
    }

    // Override employeeSummary to include department info
    @Override
    public void employeeSummary() {
        System.out.println();
        System.out.println("MANAGER SUMMARY");
        System.out.println("----------------");
        System.out.println("Name: " + getFirstName() + " " + getLastName());
        System.out.println("Employee ID: " + getEmployeeID());
        System.out.println("Salary: $" + getSalary());
        System.out.println("Department: " + department);
        System.out.println();
    }
}
