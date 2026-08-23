package com.varunbkarmikanda.lab3.eis;

import java.util.*;

public class EIS {
    private List<Employee> employees = new ArrayList<Employee>();

    public List<Employee> getEmployees() {
        return this.employees;
    }

    public boolean addEmployee(String id, String name, String designation, double salary) {
        if(!searchByID(id).getId().equals("-1")) return false;
        Employee employee = new Employee(id, name, designation, salary);
        this.employees.add(employee);
        return true;
    }

    public Employee searchByID(String id) {
        for(Employee emp: employees) {
            if(emp.getId().equals(id)) return emp;
        }
        return new Employee("-1", "Not found", "NA", 0);
    }

    public Employee salaryIncrement(String id) {
        Employee emp = searchByID(id);
        if(!emp.getId().equals("-1")) {
            emp.incrementSalary();
        }
        return emp;
    }

    public Employee deleteEmployee(String id) {
        Employee emp = searchByID(id);
        if(!emp.getId().equals("-1")) {
            this.employees.remove(emp);
        }
        return emp;
    }
}