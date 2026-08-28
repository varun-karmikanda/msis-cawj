package com.varunbkarmikanda.lab4.innerclasses.ic;

import java.time.LocalDate;

class Company {
    private String companyName;
    private String companyLocation;

    class Car{
        private String carName;
        private String carModel;
        private String carColor;

        Car(String carName, String carModel, String carColor){
            this.carName = carName;
            this.carModel = carModel;
            this.carColor = carColor;
        }

        @Override
        public String toString(){
            return "Car{" +
                    "\n\tcarName: " + carName +
                    "\n\tcarModel: " + carModel +
                    "\n\tcarColor: " + carColor +
                    "\n}";
        }
    }

    static class Service{
        private String serviceName;
        private double servicePrice;

        Service(String serviceName, double servicePrice){
            this.serviceName = serviceName;
            this.servicePrice = servicePrice;
        }

        public String getServiceName(){
            return serviceName;
        }

        public double getServicePrice(){
            return servicePrice;
        }

        public void servicePayment(String date, String customerName, double price){
            class Bill{
                private LocalDate date;
                private String customerName;
                private double price;

                Bill(LocalDate date, String customerName, double price){
                    this.date = date;
                    this.customerName = customerName;
                    this.price = price;
                }

                @Override
                public String toString() {
                    return "Bill{" +
                            "\n\tdate=" + date +
                            ",\n\tcustomerName='" + customerName + '\'' +
                            ",\n\tprice=" + price +
                            "\n}";
                }
            }

            Bill bill = new Bill(LocalDate.parse(date), customerName, price);
            System.out.println(bill);
        }

        @Override
        public String toString(){
            return "Service{" +
                    "\n\tserviceName: " + serviceName +
                    "\n\tservicePrice: " + servicePrice +
                    "\n}";
        }
    }

    Company(String companyName, String companyLocation){
        this.companyName = companyName;
        this.companyLocation = companyLocation;
    }

    @Override
    public String toString(){
        return "Company{" +
                "\n\tcompanyName: " + companyName +
                "\n\tcompanyLocation: " + companyLocation +
                "\n}";
    }

}
