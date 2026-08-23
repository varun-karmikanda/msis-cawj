package com.varunbkarmikanda.lab3.bookshop;

import java.util.*;

public class BookShop {

    private List<Book> books = new ArrayList<>();

    public List<Book> getAllBooks() {
        return this.books;
    }

    public Book addBook(String title, String author, double price, String publisher, int stock){
        Book existingBook = searchBook(title, author);
        if(existingBook != null){
            existingBook.addStock(stock);
            return existingBook;
        }
        Book newBook = new Book(title, author, price, publisher, stock);
        books.add(newBook);
        return  newBook;
    }

    public Book searchBook(String title, String author) {
        for(Book book: books) {
            if(book.getTitle().equals(title) && book.getAuthor().equals(author)) {
                return book;
            }
        }
        return null;
    }

    public Book checkAvailability(String title, String author){
        Book book = searchBook(title, author);
        if(book == null){
            System.out.println("Book is not available!!");
            return null;
        }
        return book;
    }

    public Book checkForStock(Book book, int requestedCopies){
        if(book == null) return null;
        if(!book.hasStock(requestedCopies)){
            System.out.println("Not enough copies of the book!");
            return null;
        }
        return book;
    }

    public void processTransaction(String title, String author, int requestedCopies){
        Book book = checkForStock(checkAvailability(title, author), requestedCopies);
        if(book != null){
            double totalPrice = book.getPrice(requestedCopies);
            System.out.println("Total cost " + requestedCopies + " is: " + totalPrice);
            book.removeStock(requestedCopies);
            System.out.println(book);
        } else {
            System.out.println("Try again please!");
        }
    }

    public void seedBooks(){
        this.books.add(new Book("Effective Java", "Joshua Bloch", 45.99, "Addison-Wesley", 25));
        this.books.add(new Book("Clean Code", "Robert C. Martin", 39.95, "Prentice Hall", 15));
        this.books.add(new Book("Design Patterns", "Erich Gamma", 54.99, "Addison-Wesley", 10));
        this.books.add(new Book("The Great Gatsby", "F. Scott Fitzgerald", 12.50, "Scribner", 100));
        this.books.add(new Book("Dune", "Frank Herbert", 18.99, "Chilton Books", 0));
    }

}