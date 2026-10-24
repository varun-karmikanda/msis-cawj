package lab5.shape;

public class Circle implements IShape{
    private double _radius;

    Circle(double _radius){
        this._radius = _radius;
    }

    @Override
    public double getArea() {
        return Math.round(Math.PI * _radius * _radius * 100.0) / 100.0;
    }
}
