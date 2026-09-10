package com.varunbkarmikanda.lab5.company;


import java.util.Arrays;

public class Sales extends Item {

    public double[] sales = new double[3];

    Sales(String title, double price, double sales1, double sales2, double sales3){
        super(title, price);
        this.sales[0] = sales1;
        this.sales[1] = sales2;
        this.sales[2] = sales3;
    }

    public double getMonth1Sales(){
        return sales[0];
    }

    public double getMonth2Sales(){
        return sales[1];
    }

    public double getMonth3Sales(){
        return sales[2];
    }

    public void setMonth1Sales(double month1Sales){
        this.sales[0] = month1Sales;
    }

    public void setMonth2Sales(double month2Sales){
        this.sales[1] = month2Sales;
    }

    public void setMonth3Sales(double month3Sales){
        this.sales[2] = month3Sales;
    }

    public double[] getSales(){
        return sales;
    }

    @Override
    public String toString() {
//        return "\n\tmonth_1_sales: " + sales[0] + "," +
//                "\n\tmonth_2_sales: " + sales[1] + "," +
//                "\n\tmonth_3_sales: " + sales[2] + ",";
        return super.toString() + "\n\tsales: " + Arrays.toString(sales) + ",";
    }
}
