package com.varunbkarmikanda.lab5.shape;

public class Rectangle extends Shape{
    private double width;
    private double length;

    Rectangle(){
        super();
        this.width = this.length = 1.0;
    }

    Rectangle(double width, double length){
        super();
        this.width = width;
        this.length = length;
    }

    Rectangle(double width, double length, String color, boolean filled){
        super(color, filled);
        this.width = width;
        this.length = length;
    }

    public double getWidth(){
        return width;
    }

    public void setWidth(double width){
        this.width = width;
    }

    public double getLength(){
        return length;
    }

    public void setLength(double length){
        this.length = length;
    }

    public double getArea(){
        return width * length;
    }

    public double getPerimeter(){
        return 2 * (width + length);
    }

    @Override
    public String toString(){
        return "A rectangle with width = " + width + " and length = " + length + ", which is subclass of " + super.toString();
    }
}
