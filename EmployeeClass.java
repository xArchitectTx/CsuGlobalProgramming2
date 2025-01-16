public class EmployeeClass {

    private String firstName;
    private String lastName;
    private int employeeID;
    private double salary;

    public EmployeeClass(String firstName, String lastName, int employeeID) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.employeeID = employeeID;
        this.salary = 0.0;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    
    public String getFirstName() {
        return this.firstName;
    }
    
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    public String getLastName() {
        return this.lastName;
    }
    
    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }
    
    public int getEmployeeID() {
        return this.employeeID;
    }
    
    public void setSalary(double salary) {
        this.salary = salary;
    }
    
    public double getSalary() {
        return this.salary;
    }

    public void employeeSummary() {
        System.out.println();
        System.out.println("EMPLOYEE SUMMARY");
        System.out.println("----------------");
        System.out.println("Name: " + firstName + " " + lastName);
        System.out.println("Employee ID: " + employeeID);
        System.out.println("Salary: $" + salary);

    }
}
