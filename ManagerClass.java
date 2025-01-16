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
        super.employeeSummary();
        System.out.println("Department: " + department);
        System.out.println("Position: Manager");
    }
}
