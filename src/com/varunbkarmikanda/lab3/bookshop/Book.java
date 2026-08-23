package com.varunbkarmikanda.lab3.bookshop;

public class Book {
    private String title;
    private String author;
    private double price;
    private String publisher;
    private int stock;

    Book(String title, String author, double price, String publisher, int stock) {
        this.title = title;
        this.author = author;
        this.price = price;
        this.publisher = publisher;
        this.stock = stock;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getStock(){
        return stock;
    }

    public boolean hasStock(int requestedCopies){
        return getStock() >= requestedCopies;
    }

    public void addStock(int newCopies){
        this.stock += newCopies;
    }

    public void removeStock(int soldCopies){
        this.stock -= soldCopies;
    }

    public double getPrice(int requestedCopies){
        return price * requestedCopies;
    }


    @Override
    public String toString() {
        return "\nBOOK {" + "\n\ttitle: " + this.title + "\n\tauthor: " + this.author + "\n\tprice: " + this.price + "\n\tpublisher: " + this.publisher + "\n\tstock: " + this.stock + "\n}";
    }


}
