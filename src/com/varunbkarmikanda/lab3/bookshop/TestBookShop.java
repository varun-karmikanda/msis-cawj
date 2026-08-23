package com.varunbkarmikanda.lab3.bookshop;

import com.varunbkarmikanda.lab3.eis.Employee;

import java.util.Scanner;

public class TestBookShop {
    private static Scanner sc;

    public static void main(String[] args) {
        BookShop bookshop = new BookShop();
        bookshop.seedBooks();

        String bookShopOperations = "\n\n----- BOOK SHOP -----" +
                "\n1. Add new books" +
                "\n2. Search for book" +
                "\n3. Process order" +
                "\n4. Get all books" +
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
                    String title, author, publisher;
                    int stock;
                    double price;

                    System.out.print("Enter the book title: ");
                    title = sc.nextLine();

                    System.out.print("Enter the book author: ");
                    author = sc.nextLine();

                    System.out.print("Enter the book price: ");
                    price = sc.nextDouble();

                    System.out.print("Enter the book publisher: ");
                    sc.nextLine();
                    publisher = sc.nextLine();

                    System.out.print("Enter the stock : ");
                    stock = sc.nextInt();

                    Book book = bookshop.addBook(title, author, price, publisher, stock);
                    System.out.println("Book success added!");
                    System.out.println(book);
                    break;
                }
                case 2: {
                    String title, author;

                    System.out.print("Enter the book title: ");
                    title = sc.nextLine();

                    System.out.print("Enter the book author: ");
                    author = sc.nextLine();

                    Book book = bookshop.searchBook(title, author);
                    System.out.println(book);
                    break;
                }
                case 3: {
                    System.out.println("--- Processing order ---");

                    String title, author;
                    int requestedCopies;

                    System.out.print("Enter the book title: ");
                    title = sc.nextLine();

                    System.out.print("Enter the book author: ");
                    author = sc.nextLine();

                    System.out.print("Enter the requested copies : ");
                    requestedCopies = sc.nextInt();

                    bookshop.processTransaction(title, author, requestedCopies);

                    break;
                }
                case 4: {
                    System.out.println(bookshop.getAllBooks());
                    break;
                }
                case 5: {
                    System.exit(0);
                }
            }
        } while (choice < totalOperations);
    }
}
