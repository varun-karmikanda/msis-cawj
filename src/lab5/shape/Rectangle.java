package lab5.shape;

public class Rectangle implements IShape{
    private double _height;
    private double _width;

    Rectangle(double height, double width){
        this._height = height;
        this._width = width;
    }

    public double get_width() {
        return _width;
    }

    public double get_height() {
        return _height;
    }

    @Override
    public double getArea() {
        return Math.round(_height * _width * 100.0) / 100.0;
    }
}
