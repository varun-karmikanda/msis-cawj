package com.varunbkarmikanda.lab5.shape;

public class TestShape {
    public static void main(String[] args){

        Shape shape = new Shape();

        assert shape.isFilled() : "Color is filled";
        shape.setFilled(false);
        shape.setColor("blue");
        assert shape.getColor().equals("blue") : "Color is blue";
        assert !shape.isFilled() : "Color not filled";
        assert shape.toString().equals("A shape with color blue is not filled");

        shape = new Shape("yellow", false);
        assert !shape.isFilled() : "Color is not filled";
        assert !shape.getColor().equals("black") : "Color is not black";

        shape = new Circle();
        assert shape.getColor().equals("green") : "Circle color is green";
        assert shape.isFilled() : "Circle color is filled";

        Circle circle1 = new Circle();
        assert circle1.getColor().equals("green") : "Circle color is green";
        assert circle1.isFilled() : "Circle color is filled";
        assert circle1.getRadius() == 1.0 : "Circle radius is 1.0";
        assert circle1.getArea() > 3 : "Area of circle is greater than 3";
        assert circle1.getPerimeter() > 6 : "Perimeter of circle is greater than 6";

        Circle circle2 =  new Circle(5);
        assert circle2.getColor().equals("green") : "Circle color is green";
        assert circle2.isFilled() : "Circle color is filled";
        assert circle2.getRadius() == 5.0 : "Circle radius is 5.0";
        assert circle2.getArea() > 78 : "Area of circle is greater than 78";
        assert circle2.getPerimeter() > 30 : "Perimeter of circle is greater than 30";

        Circle circle3 =  new Circle(7, "pink", false);
        assert circle3.getColor().equals("pink") : "Circle color is pink";
        assert !circle3.isFilled() : "Circle color is not filled";
        assert circle3.getRadius() == 7 : "Circle radius is 5.0";
        assert circle3.getArea() > 78 : "Area of circle is greater than 78";
        assert circle3.getPerimeter() > 30 : "Perimeter of circle is greater than 30";

        Rectangle rectangle1 = new Rectangle();
        assert rectangle1.isFilled() : "Rectangle is filled";
        assert rectangle1.getColor().equals("green") : "Rectangle color is green";
        assert rectangle1.getWidth() == 1 : "Rectangle width is 1";
        assert rectangle1.getArea() == 1 : "Area of rectangle is 1";
        assert rectangle1.getPerimeter() == 4 : "Perimeter of rectangle is 4";

        Rectangle rectangle2 = new Rectangle(1, 2);
        assert rectangle2.isFilled() : "Rectangle is filled";
        assert rectangle2.getColor().equals("green") : "Rectangle color is green";
        assert rectangle2.getWidth() == 1 : "Rectangle width is 1";
        assert rectangle2.getArea() == 2 : "Area of rectangle is 2";
        assert rectangle2.getPerimeter() == 6 : "Perimeter of rectangle is 6";

        Rectangle rectangle3 = new Rectangle(1, 2, "yellow", false);
        assert !rectangle3.isFilled() : "Rectangle is not filled";
        assert rectangle3.getColor().equals("yellow") : "Rectangle color is yellow";
        assert rectangle3.getWidth() == 1 : "Rectangle width is 1";
        assert rectangle3.getArea() == 2 : "Area of rectangle is 2";
        assert rectangle3.getPerimeter() == 6 : "Perimeter of rectangle is 6";

        Square square1 = new Square(67, "pink", true);
        assert square1.isFilled() : "Square is filled";
        assert square1.getColor().equals("pink");
        assert square1.getSide() == 67 : "Square side is 67";
        assert square1.getArea() == 4489 : "Area of square of side 67 is 4489";
        assert square1.getPerimeter() == 268 : "Perimeter of square of side 67 is 268";
    }
}
