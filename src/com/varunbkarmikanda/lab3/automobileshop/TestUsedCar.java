package com.varunbkarmikanda.lab3.automobileshop;

import java.time.LocalDate;

public class TestUsedCar {

    public static void testUsedCar(){
        System.out.println("----- TEST CAR -----");
        String name = "Legender";
        String model = "4WD";
        LocalDate yearOfPurchase = LocalDate.parse("2020-05-20");
        String color = "Black";
        double price = 6767676;
        UsedCar car = new UsedCar(name, model, yearOfPurchase, color, price);

        System.out.println("Car name : " + car.getName());
        System.out.println("Car model: " + car.getModel());
        System.out.println("Car year : " + car.getYearOfPurchase());
        System.out.println("Car color: " + car.getColor());
        System.out.println("Car price: " + car.getPrice());

        assert car.getName().equals(name) : "Car name does not match!";
        assert car.getModel().equals(model) : "Car model does not match!";
        assert car.getYearOfPurchase().equals(LocalDate.parse("2020-05-20"));
        assert car.getColor().equals(color) : "Car color does not match!";
        assert car.getPrice() == 6767676 : "Car price does not match";

    }

    public static void main(String[] args) {
        testUsedCar();
    }
}
