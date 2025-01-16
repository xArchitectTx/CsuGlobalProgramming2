public class ManagerClass extends EmployeeClass {

    private String department;

    public ManagerClass(String firstName, String lastName, int employeeID, String department) {
        super(firstName, lastName, employeeID);
        this.department = department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getDepartment() {
        return this.department;
    }

    @Override
    public void employeeSummary() {
        System.out.println();
        System.out.println("MANAGER SUMMARY");
        System.out.println("----------------");
        System.out.println("Name: " + getFirstName() + " " + getLastName());
        System.out.println("Employee ID: " + getEmployeeID());
        System.out.println("Manager's Salary: $" + getSalary());
        System.out.println("Department: " + department);
        System.out.println();
    }
}
