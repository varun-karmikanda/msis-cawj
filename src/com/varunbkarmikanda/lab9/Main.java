package com.varunbkarmikanda.lab9;

import com.varunbkarmikanda.lab9.college.ExaminationDAO;
import com.varunbkarmikanda.lab9.college.ResultDAO;
import com.varunbkarmikanda.lab9.college.StudentDAO;
import com.varunbkarmikanda.lab9.college.SubjectDAO;

import java.sql.Date;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        StudentDAO studentDAO = new StudentDAO();
        SubjectDAO subjectDAO = new SubjectDAO();
        ExaminationDAO examinationDAO = new ExaminationDAO();
        ResultDAO resultDAO = new ResultDAO();

        while(true){
            printMenu();
            int choice = readInteger("Enter your choice: ");

            switch (choice) {
                case 1 -> studentDAO.addStudent(
                        readInteger("Student ID: "), readString("Name: "), readString("Program: "),
                        readInteger("Semester: "), readString("Email: "));

                case 2 -> studentDAO.updateStudent(
                        readInteger("Student ID: "), readString("New name: "), readString("New program: "),
                        readInteger("New semester: "), readString("New email: "));

                case 3 -> subjectDAO.addSubject(
                        readInteger("Subject ID: "), readString("Subject name: "),
                        readInteger("Credits: "), readInteger("Semester: "));

                case 4 -> subjectDAO.updateSubject(
                        readInteger("Subject ID: "), readString("New subject name: "),
                        readInteger("New credits: "), readInteger("New semester: "));

                case 5 -> examinationDAO.addExamination(
                        readInteger("Exam ID: "), readInteger("Subject ID: "),
                        readDate("Exam date (yyyy-mm-dd): "), readDouble("Max marks: "));

                case 6 -> examinationDAO.updateExamination(
                        readInteger("Exam ID: "), readInteger("Subject ID: "),
                        readDate("New exam date (yyyy-mm-dd): "), readDouble("New max marks: "));

                case 7 -> resultDAO.addMarks(
                        readInteger("Student ID: "), readInteger("Exam ID: "),
                        readDouble("Marks obtained: "), readString("Grade (A-F): "));

                case 8 -> resultDAO.updateMarks(
                        readInteger("Student ID: "), readInteger("Exam ID: "),
                        readDouble("New marks: "), readString("New grade: "));

                case 9 -> resultDAO.subjectWiseAvg();

                case 10 -> resultDAO.highestScoringStudent();

                case 0 -> {
                    System.out.println("Exiting!");
                    sc.close();
                    return;
                }

                default -> System.out.println("Invalid choice, try again.");
            }
        }
    }

    static void printMenu() {
        System.out.println("\n===== Student Result Management =====");
        System.out.println(" 1. Add student");
        System.out.println(" 2. Update student");
        System.out.println(" 3. Add subject");
        System.out.println(" 4. Update subject");
        System.out.println(" 5. Add examination");
        System.out.println(" 6. Update examination");
        System.out.println(" 7. Add marks");
        System.out.println(" 8. Update marks");
        System.out.println(" 9. Subject-wise average");
        System.out.println("10. Highest scoring student");
        System.out.println(" 0. Exit");
        System.out.println("=====================================");
    }

    static String readString(String prompt){
        System.out.print(prompt);
        return sc.nextLine().trim();
    }

    static  int readInteger(String prompt){
        while (true){
            try {
                return Integer.parseInt(readString(prompt));
            } catch (NumberFormatException e){
                System.out.println("Please enter a whole number.");
            }
        }
    }

    static  double readDouble(String prompt){
        while (true){
            try {
                return Double.parseDouble(readString(prompt));
            } catch (NumberFormatException e){
                System.out.println("Please enter a number.");
            }
        }
    }

    static  Date readDate(String prompt){
        while (true){
            try {
                return Date.valueOf(readString(prompt));
            } catch (NumberFormatException e){
                System.out.println("Use the format yyyy-mm-dd.");
            }
        }
    }
}
