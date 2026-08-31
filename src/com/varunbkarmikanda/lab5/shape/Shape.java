package com.varunbkarmikanda.lab5.shape;

public class Shape {
    private String color;
    private boolean filled;

    Shape(){
        this.color = "green";
        this.filled = true;
    }

    Shape(String color, boolean filled){
        this.color = color;
        this.filled = filled;
    }

    public String getColor(){
        return color;
    }

    public void setColor(String color){
        this.color = color;
    }

    public boolean isFilled(){
        return filled;
    }

    public void setFilled(boolean filled){
        this.filled = filled;
    }

    @Override
    public String toString(){
        return "A shape with color " + color + " is " + (filled ? "filled!" : "not filled");
    }
}
