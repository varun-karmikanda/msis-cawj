package com.varunbkarmikanda.lab3.automobileshop;

import java.time.LocalDate;

public class UsedCar {
    private String name;
    private String model;
    private LocalDate yearOfPurchase;
    private String color;
    private double price;

    public UsedCar(String name, String model,  LocalDate yearOfPurchase, String color, double price) {
        this.model = model;
        this.name = name;
        this.yearOfPurchase = yearOfPurchase;
        this.color = color;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public LocalDate getYearOfPurchase() {
        return yearOfPurchase;
    }

    public void setYearOfPurchase(LocalDate yearOfPurchase) {
        this.yearOfPurchase = yearOfPurchase;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "UsedCar{" +
                "\n\tname=" + name +
                ",\n\tmodel=" + model +
                ",\n\tyearOfPurchase=" + yearOfPurchase +
                "\n\tcolor=" + color +
                "\n\tprice=" + price +
                "\n}";
    }
}
