package com.varunbkarmikanda.lab3.book;

public class TestBook {
    public static void main(String[] args) {
        Author author1 = new Author("Paul Deitel", "paul@deitel.com", 'm');
        System.out.println(author1);

        Book book1 = new Book("How to program with JAVA", author1, 19.99, 99);
        System.out.println(book1);

        Book book2 = new Book("JAVA 2 – The Complete Reference", author1, 29.95);
        System.out.println(book2);


        book1.setPrice(24.95);
        book1.setQty(105);

        System.out.println("\nUpdated book1 details:");
        System.out.println("Name: " + book1.getName());
        System.out.println("Price: $" + book1.getPrice());
        System.out.println("Qty: " + book1.getQty());
        System.out.println("Author: " + book1.getAuthor());

        System.out.println("\nAuthor's name via b1: " + book1.getAuthor().getName());
        System.out.println("Author's email via b1: " + book1.getAuthor().getEmail());
    }
}
