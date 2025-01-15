public class ManagerClass extends EmployeeClass {
    // Field
    private String department;

    // Constructor
    // Note that we pass firstName, lastName, and employeeID to the superclass constructor.
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
        // First, call the superclass version
        super.employeeSummary();
        // Then add the Manager-specific info
        System.out.println("Department: " + department);
    }
}
