package com.varunbkarmikanda.lab2;

import java.util.Arrays;
import java.util.Scanner;

public class Lab2 {
    static Scanner sc;

    public static int[] constructArray() {
        System.out.print("Enter the number of elements in an array: ");
        int size = sc.nextInt();

        System.out.print("Enter " + size + " elements into the array: ");
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }

        return arr;
    }

    public static void duplicateValue(int[] arr) {

        int[] duplicateArray = new int[arr.length];
        int duplicateValueIndex = 0;

        for (int i = 0; i < arr.length; i++) {
            for(int j = i + 1; j < arr.length; j++) {
                if(arr[i] == arr[j]) {
                    duplicateArray[duplicateValueIndex] = arr[i];
                    duplicateValueIndex++;
                }
            }
        }

        if(duplicateValueIndex != 0) {
            System.out.println("Duplicate values are: ");
            for (int i = 0; i < duplicateValueIndex; i++) {
                System.out.print(duplicateArray[i]);
            }
        } else {
            System.out.println("No duplicate elements in an array");
        }

    }

    public static void sortArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if(arr[j] < arr[i]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

    public static int[] kthSmallestLargest(int[] arr, int k) {
        int[] result = new int[2];

        sortArray(arr);
        System.out.println(Arrays.toString(arr));

        result[0] = arr[k - 1];
        result[1] = arr[arr.length - k];
        System.out.println("THE ARRAY LENGTH: " + arr.length);

        return result;
    }

    static int[] negLeftPosRight(int[] arr) {
        sortArray(arr);

        return arr;
    }

    static void javaQuiz() {

        int attempts = 0;

        System.out.println("----- QUIZ TIME!! ---");

        while(attempts < 3) {
            System.out.println("What is the magic number?");
            int answer = sc.nextInt();

            if(answer == 67) {
                System.out.println("CORRECT!!!!!");
                break;
            }

            attempts++;
        }

        if(attempts == 3) {
            System.out.println("Magic number = 67");
        }

    }

    static void floydTriangle(int rows) {
        int count = 1;
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(count + " ");
                count++;
            }
            System.out.println();
        }
    }

    static void floydTriangle01(int rows) {
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= i; j++) {
                String res = ((i + j) % 2) == 0 ? "1" : "0";
                System.out.print(res + " ");
            }
            System.out.println();
        }
    }


    static void mainApp() {
        System.out.println("\n---Successful authentication!---\n--- Main application started ---");

        String question = "\n--- OPERATIONS ---" +
                "\n1. Find the duplicate values of an array of integer" +
                "\n2. Find kth smallest and largest element in each array" +
                "\n3. Move positive number to the right and the negative number to the left" +
                "\n4. Java quiz" +
                "\n5. Floyd's triangle" +
                "\n6. 0 and 1 variant of the floyd's triangle\n7. Exit";

        int choice;
        int totalChoices = 7;
        sc = new Scanner(System.in);

        do {
            System.out.println(question);
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1: {
                    int[] constructedArray = constructArray();
                    duplicateValue(constructedArray);
                    break;
                }
                case 2: {
                    int[] constructedArray = constructArray();
                    System.out.print("Enter the k value: ");
                    int k = sc.nextInt();
                    int[] res = kthSmallestLargest(constructedArray, k);
                    System.out.println("k th smallest = " + res[0] + "\nk th largest = " + res[1]);
                    break;
                }
                case 3: {
                    int[] constructedArray = constructArray();
                    int[] res = negLeftPosRight(constructedArray);
                    System.out.println(Arrays.toString(res));
                    break;
                }
                case 4: {
                    javaQuiz();
                    break;
                }
                case 5: {
                    System.out.print("Enter the number of rows for floyd triangle: ");
                    int rows = sc.nextInt();
                    floydTriangle(rows);
                    break;
                }
                case 6: {
                    System.out.print("Enter the number of rows for floyd triangle(0, 1 variant): ");
                    int rows = sc.nextInt();
                    floydTriangle01(rows);
                    break;
                }
                case 7: {
                    System.exit(0);
                }
            }

        } while(choice < totalChoices);

    }

    public static void main(String[] args) {
        String[] user = { "varun", "nitr0x" };
        String[] password = { "var67", "1234" };

        sc = new Scanner(System.in);

        System.out.println("--- CAWJ (LAB 2) ---");
        System.out.println("---  USER LOGIN  ---");

        System.out.print("\nEnter the user name: ");
        String userName = sc.nextLine();

        System.out.print("Enter the password: ");
        String userPassword = sc.nextLine();

        boolean isChecked = false;

        for (int i = 0; i < user.length; i++) {
            if((user[i].equals(userName)) && (password[i].equals(userPassword))) {
                isChecked = true;
                break;
            }
        }

        if(isChecked) {
            mainApp();
        } else {
            System.out.println("Invalid username and password!");
        }

    }

}
