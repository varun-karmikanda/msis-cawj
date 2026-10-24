package lab5.shape;

public class Pizza {
    private double _price;
    private IShape _shape;

    Pizza(double price, IShape shape){
        this._price = price;
        this._shape = shape;
    }

    public double getPrice() {
        return _price;
    }

    public IShape getShape(){
        return _shape;
    }
}
