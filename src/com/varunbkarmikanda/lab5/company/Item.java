package com.varunbkarmikanda.lab5.company;

public class Item {
    private String title;
    private double price;

    Item(String title, double price){
        this.title = title;
        this.price = price;
    }

    public String getTitle(){
        return title;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public double getPrice(){
        return price;
    }

    public void setPrice(double price){
        this.price = price;
    }

    @Override
    public String toString(){
        return "{" +
                "\n\ttitle: \"" + title + "\"," +
                "\n\tprice: \"" + price + "\",";
    }
}
