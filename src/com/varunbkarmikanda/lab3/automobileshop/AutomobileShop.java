package com.varunbkarmikanda.lab3.automobileshop;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class AutomobileShop {
    private List<UsedCar> cars = new ArrayList<>();

    public List<UsedCar> getCars() {
        return cars;
    }

    public UsedCar searchCar(String name, String model){
        for (UsedCar car: cars){
            if(car.getName().equals(name) && car.getModel().equals(model)) return car;
        }
        System.out.println("Car not found!!");
        return null;
    }

    public UsedCar addCar(String name, String model, LocalDate yearOfPurchase, String color, double price){

        UsedCar car = new UsedCar(name, model, yearOfPurchase, color, price);
        cars.add(car);

        return car;
    }

    public UsedCar bookCar(String name, String model){
        UsedCar car = searchCar(name, model);
        if(car != null){
            cars.remove(car);
            return car;
        }
        return null;
    }

    public void seedCars(){
        addCar("Brezza", "VX", LocalDate.of(2017, 10, 2), "White", 650500.00);
        addCar("Venue", "SX", LocalDate.of(2018, 9, 20), "White", 750000.00);
        addCar("Ciaz", "VX", LocalDate.of(2015, 12, 15), "White", 600000.00);
        addCar("Ecosport", "LX", LocalDate.of(2018, 6, 21), "Blue", 500500.00);
        addCar("Nexon", "SX", LocalDate.of(2019, 10, 15), "Green", 850500.00);
    }
}
