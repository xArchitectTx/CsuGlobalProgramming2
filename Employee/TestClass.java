public class TestClass{
    public static void main(String[] args) {
        // Employee
        EmployeeClass emp = new EmployeeClass("James", "Bond", 007);
        emp.setSalary(60000.00);
        emp.employeeSummary();

        // Manager
        ManagerClass man = new ManagerClass("Edward", "Donne", 001, "Double-O Section");
        man.setSalary(100000.00);
        man.employeeSummary();
    }
}
