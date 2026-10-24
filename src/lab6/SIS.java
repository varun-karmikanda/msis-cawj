package lab6;

import java.util.Scanner;

public class SIS {
    private static Scanner sc = null;

    private static String[] userDetails(){
        System.out.print("Enter the user name: ");
        String name = sc.nextLine();
        System.out.print("Enter  the password: ");
        String password = sc.nextLine();
        return new String[] { name, password };
    }

    private static boolean isAuthenticated(){
        Auth auth = new Auth();
        boolean isUserAuthenticated = auth.authenticate(userDetails());

        if(isUserAuthenticated){
            System.out.println("Authentication successful!!!");
            return true;
        } else {
            System.out.println("Authentication failed!!!");
            return false;
        }
    }

    private static void studentOperations(){
        Student student =  new Student();

        student.insertStudentRecord(new String[]{ "67", "Varun", "Mangalore" });
        student.insertStudentRecord(new String[]{ "99", "Arun", "Manipal" });
        student.insertStudentRecord(new String[]{ "11", "Ram", "Udupi" });
        student.insertStudentRecord(new String[]{ "63", "NiTR0X", "Kaup" });

        int choice = 0;
        do{
            System.out.println();
            System.out.println("1. Insert student record");
            System.out.println("2. Delete student record");
            System.out.println("3. Display all student record");
            System.out.println("4. Exit ");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();
            switch (choice){
                case 1:{
                    System.out.println("INSERT: Enter student details");
                    System.out.print("Enter student regNo: ");
                    String regNo = sc.nextLine();
                    System.out.print("Enter student name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter student location: ");
                    String location = sc.nextLine();
                    String[] studentDetails = new String[] { regNo, name, location };

                    student.insertStudentRecord(studentDetails);
                    break;
                }
                case 2:{
                    student.displayAllStudentName();

                    System.out.print("Enter the name of the student to delete: ");
                    String name = sc.nextLine();

                    student.deleteStudentRecord(name);
                    break;
                }
                case 3:{
                    System.out.println("Student Records");
                    student.displayAllStudentRecord();
                    break;
                }
                case 4:{
                    System.out.println("Exiting...");
                    return;
                }
                default:{
                    System.out.println("Invalid choice. Please enter a valid choice!");
                }
            }
        } while (choice != 4);
    }

    public static void main(String[] args) {
        sc = new Scanner(System.in);

        System.out.println("---------- Student Information System ----------");

        if(!isAuthenticated()) return;

        studentOperations();


    }
}
