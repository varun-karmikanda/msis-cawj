package com.varunbkarmikanda.lab3.eis;

public class Employee {

    private String id;
    private String name;
    private String designation;
    private double salary;

    Employee(String id, String name, String designation, double salary) {
        this.id = id;
        this.name = name;
        this.designation = designation;
        this.salary = salary;
    }


    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "\nEMPLOYEE {\n\tID: " + this.id + ",\n\tNAME: " + this.name + ",\n\tDESIGNATION: " + this.designation + ",\n\tSALARY: " + this.salary + "\n}";
    }

    public void incrementSalary() {
        this.salary += this.salary / 10;
    }
}
