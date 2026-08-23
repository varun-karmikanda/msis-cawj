package com.varunbkarmikanda.lab3.automobileshop;

import java.time.LocalDate;
import java.util.Scanner;

public class AutomobileShopInteractive {
    private static Scanner sc;

    public static void main(String[] args) {
        AutomobileShop automobileShop = new AutomobileShop();
        automobileShop.seedCars();

        String bookShopOperations = "\n\n----- DEALERSHIP -----" +
                "\n1. Add new car" +
                "\n2. Search for car" +
                "\n3. Book car" +
                "\n4. Get all cars" +
                "\n5. Exit";

        int choice;
        int totalOperations = 5;
        sc = new Scanner(System.in);

        do {
            System.out.println(bookShopOperations);
            System.out.print("\nEnter the choice: ");
            choice = sc.nextInt();
            System.out.println();
            sc.nextLine();

            switch (choice) {
                case 1: {
                    String name, model, color, dateInput;
                    LocalDate yearOfPurchase;
                    double price;

                    System.out.print("Enter the car name: ");
                    name = sc.nextLine();

                    System.out.print("Enter the car model: ");
                    model = sc.nextLine();

                    System.out.print("Enter purchase data (yyyy-MM-dd): ");
                    dateInput = sc.nextLine().trim();
                    yearOfPurchase = LocalDate.parse(dateInput);

                    System.out.print("Enter the car color: ");
                    color = sc.nextLine();

                    System.out.print("Enter the car price : ");
                    price = sc.nextInt();

                    UsedCar car = automobileShop.addCar(name, model, yearOfPurchase, color, price);
                    System.out.println("Car successfully added!");
                    System.out.println(car);
                    break;
                }
                case 2: {
                    String name, model;

                    System.out.print("Enter the car name: ");
                    name = sc.nextLine();

                    System.out.print("Enter the car model: ");
                    model = sc.nextLine();

                    UsedCar car = automobileShop.searchCar(name, model);

                    if(car != null){
                        System.out.println(car);
                    }
                    break;
                }
                case 3: {
                    System.out.println("--- BOOKING CAR ---");

                    String name, model;

                    System.out.print("Enter the car name: ");
                    name = sc.nextLine();

                    System.out.print("Enter the car model: ");
                    model = sc.nextLine();

                    automobileShop.bookCar(name, model);

                    break;
                }
                case 4: {
                    System.out.println(automobileShop.getCars());
                    break;
                }
                case 5: {
                    System.exit(0);
                }
            }
        } while (choice < totalOperations);
    }
}
