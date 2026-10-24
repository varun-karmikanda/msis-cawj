package lab5.shape;

public class Rectangle implements IShape{
    private double _height;
    private double _width;

    Rectangle(double height, double width){
        this._height = height;
        this._width = width;
    }

    @Override
    public double getArea() {
        return Math.round(_height * _width * 100.0) / 100.0;
    }
}
