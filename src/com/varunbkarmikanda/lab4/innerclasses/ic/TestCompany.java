package com.varunbkarmikanda.lab4.innerclasses.ic;

public class TestCompany {

    public static void main(String[] args){
        Company.Service service = new Company.Service("General service", 6767);
        System.out.println(service.getServiceName());
        System.out.println(service.getServicePrice());
        System.out.println(service.getClass().getName());

        Company company = new Company("Karmikanda", "Mangaluru");
        Company.Car car = company.new Car("Legender", "4WD", "Black");

        System.out.println(service);
        System.out.println(company);
        System.out.println(car);

        service.servicePayment("2020-05-20", "NiTR0X", 6767.67);
    }
}
