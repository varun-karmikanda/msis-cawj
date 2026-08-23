package com.varunbkarmikanda.lab3.automobileshop;

import java.time.LocalDate;

public class TestUsedCar {

    public static void testUsedCar(){
        System.out.println("----- TEST CAR -----");
        String nane = "Legender";
        String model = "4WD";
        LocalDate yearOfPurchase = LocalDate.parse("2020-05-20");
        String color = "Black";
        double price = 6767676;
        UsedCar car = new UsedCar(nane, model, yearOfPurchase, color, price);

        System.out.println("Car name : " + car.getName());
        System.out.println("Car model: " + car.getModel());
        System.out.println("Car year : " + car.getYearOfPurchase());
        System.out.println("Car color: " + car.getColor());
        System.out.println("Car price: " + car.getPrice());

        

    }

    public static void main(String[] args) {
        testUsedCar();
    }
}
