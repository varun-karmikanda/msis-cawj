package com.varunbkarmikanda.lab5.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Test {

    private static Scanner sc;

    public static void main(String[] args){

        Inventory inventory = new Inventory();
        sc = new Scanner(System.in);

        int ch = 0;
        String menuDisplay = "---------- INVENTORY ----------" +
                "\n1. Generate component report" +
                "\n2. Display sales details" +
                "\n3. Search item by title" +
                "\n4. Display item detail with item type" +
                "\n5. Exit";

        do{
            System.out.println(menuDisplay);
            System.out.print("Enter your choice: ");
            ch = sc.nextInt();
            sc.nextLine();

            switch (ch){
                case 1 -> {
                    System.out.println("---------- DISPLAY MENU ITEMS ----------");
                    System.out.println("1. Hardware item");
                    System.out.println("2. Software item");
                    System.out.print("Enter your choice: ");
                    int subCh = sc.nextInt();

                    System.out.println("---------- REPORT ----------");
                    System.out.println(inventory.inventoryReport(subCh));
                }
                case 2 -> {
                    System.out.println("---------- SALES DETAILS ----------");
                    System.out.print("Enter the title: ");
                    String title = sc.nextLine();
                    Sales foundItem = (Sales) inventory.searchByTitle(title);
                    if(foundItem != null){
                        System.out.println(Arrays.toString(foundItem.getSales()));
                    }
                }
                case 3 -> {
                    System.out.println("---------- SEARCH ITEM ----------");
                    System.out.print("Enter the title: ");
                    String title = sc.nextLine();
                    Sales foundItem = (Sales) inventory.searchByTitle(title);
                    if(foundItem != null){
                        System.out.println(foundItem);
                    }
                }
                case 4 -> {
                    System.out.println("---------- INVENTORY ----------");
                    System.out.println(inventory.getInventory());
                }
                case 5 -> {
                    System.out.println("EXITING...");
                    System.exit(0);
                }
                default -> {
                    System.out.println("INVALID CHOICE!!");
                }
            }
        } while (ch != 5);

    }

}
