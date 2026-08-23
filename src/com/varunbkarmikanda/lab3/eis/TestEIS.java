package com.varunbkarmikanda.lab3.eis;

import java.util.Scanner;

public class TestEIS {
    private static Scanner sc;

    public static void main(String[] args) {
        System.out.println("\n----- EMPLOYEE INFORMATION SYSTEM -----");

        EIS eis = new EIS();
        eis.addEmployee("67", "Varun", "CEO", 5000000);
        eis.addEmployee("99", "Ajay", "QA", 500000);
        eis.addEmployee("51", "Anil", "SDE", 3000000);

        String empOperations = "\n\n----- EIS OPERATIONS -----" +
                "\n1. Add new employee" +
                "\n2. Search for employee" +
                "\n3. Increase the employee salary" +
                "\n4. Display employee details" +
                "\n5. Display all the employees" +
                "\n6. Remove the employee" +
                "\n7. Exit";

        int choice;
        int totalOperations = 7;
        sc = new Scanner(System.in);

        do {
            System.out.println(empOperations);
            System.out.print("\nEnter the choice: ");
            choice = sc.nextInt();
            System.out.println();
            sc.nextLine();

            switch (choice) {
                case 1: {
                    String id, name, designation;
                    double salary;

                    System.out.print("Enter the Employee ID: ");
                    id = sc.nextLine();

                    System.out.print("Enter the Employee Name: ");
                    name = sc.nextLine();

                    System.out.print("Enter the designation: ");
                    designation = sc.nextLine();

                    System.out.print("Enter the salary: ");
                    salary = sc.nextDouble();

                    boolean isAdded = eis.addEmployee(id, name, designation, salary);
                    if(isAdded){
                        System.out.println("Added successfully!!");
                    } else {
                        System.out.println("Employee with this id exists");
                    }

                    System.out.print(eis.searchByID(id));

                    break;
                }
                case 2: {
                    System.out.print("Enter the employee's id you want to search: ");
                    String id = sc.nextLine();

                    Employee emp = eis.searchByID(id);
                    System.out.println(emp);

                    break;
                }
                case 3: {
                    System.out.print("Enter the id of the employee to increase salary: ");
                    String id = sc.nextLine();
                    eis.salaryIncrement(id);

                    System.out.println(eis.searchByID(id));

                    break;
                }
                case 4: {
                    System.out.print("Enter the employee id to display: ");
                    String id = sc.nextLine();

                    System.out.println(eis.searchByID(id));
                    break;
                }
                case 5: {
                    System.out.println(eis.getEmployees());
                    break;
                }
                case 6: {
                    System.out.print("Enter the employee's id to delete: ");
                    String id = sc.nextLine();

                    System.out.println(eis.deleteEmployee(id));
                    break;
                }
                case 7: {
                    System.exit(0);
                }
            }
        } while (choice < totalOperations);


//        System.out.println("----- Employee Information System -----");
//        for (int i = 0; i < 3; i++) {
//            System.out.println("");
//        }
//
//
//        eis.addEmployee("67", "Varun", "CEO", 5000000);
//        eis.addEmployee("99", "Ajay", "QA", 500000);
//        eis.addEmployee("51", "Anil", "SDE", 3000000);
//
//        System.out.println(eis.searchByID("67"));
//        System.out.println(eis.searchByID("63"));
//
//        System.out.println(eis.salaryIncrement("67"));


    }
}
