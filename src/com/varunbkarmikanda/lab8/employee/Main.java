package com.varunbkarmikanda.lab8.employee;

public class Main {
    public static void main(String[] args) {
        EmployeeDAO employee = new EmployeeDAO();

        employee.insertEmployee(67, "Varun", 10000000);
        employee.insertEmployee(1, "Arun", 9000000.0);
        employee.insertEmployee(45, "Jack", 7000000.0);
        employee.displayEmployee();
        employee.updateEmployee(45, "Ajay", 8000000.0);
        employee.displayEmployee();
        employee.updateEmployee(1, "John", null);
        employee.displayEmployee();
        employee.updateEmployee(67, null, 20000000.0);
        employee.displayEmployee();

        employee.deleteEmployee(67);
        employee.deleteEmployee(1);
        employee.deleteEmployee(45);

    }
}
