package lab5.shape;

public class Test_Pizza {
    public static void main(String[] args) {
        testCirclePizza();
        testRectanglePizza();
    }

    static void testCirclePizza(){
        IShape circle = new Circle(5);
        Pizza pizza = new Pizza(67.67, circle);

        assert pizza.getPrice() == 67.67;
        assert pizza.getShape().getArea() == 78.54;
        assert pizza.getShape() instanceof Circle;
    }

    static void testRectanglePizza(){
        IShape rectangle = new Rectangle(6, 7);
        Pizza pizza = new Pizza(670, rectangle);

        assert pizza.getPrice() == 670;
        assert pizza.getShape().getArea() == 42;
        assert pizza.getShape() instanceof Rectangle;
    }
}
