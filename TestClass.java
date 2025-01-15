public class TestClass{
    public static void main(String[] args) {
        // Create an Employee
        EmployeeClass e1 = new EmployeeClass("James", "Bond", 007);
        e1.setSalary(60000.00);
        e1.employeeSummary();

        // Create a Manager
        ManagerClass m1 = new ManagerClass("Edward", "Donne", 001, "Double-O Section");
        m1.setSalary(70000.00);
        m1.employeeSummary();
    }
}
