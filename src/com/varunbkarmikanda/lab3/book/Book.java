package com.varunbkarmikanda.lab3.book;

public class Book {
    private String name;
    private Author author;
    private double price;
    private int qty;

    Book(String name, Author author, double price){
        this.name = name;
        this.author = author;
        this.price = price;
    }

    Book(String name, Author author, double price, int qty){
        this.name = name;
        this.author = author;
        this.price = price;
        this.qty = qty;
    }

    public String getName(){
        return name;
    }

    public Author getAuthor(){
        return author;
    }

    public double getPrice(){
        return price;
    }

    public void setPrice(double price){
        this.price = price;
    }

    public int getQty(){
        return qty;
    }

    public void setQty(int qty){
        this.qty = qty;
    }

    @Override
    public String toString() {
        return "Book{" +
                "\n\tname='" + name + '\'' +
                ",\n\tauthor=" + author +
                ",\n\tprice=" + price +
                ",\n\tqty=" + qty +
                "\n}";
    }


}
