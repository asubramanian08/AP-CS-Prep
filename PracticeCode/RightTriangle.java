package PracticeCode;

public class RightTriangle extends EquilateralTriangle {
    public RightTriangle(double side) {
        super(side);
    }

    public double getPerimeter() {
        return (2 + Math.sqrt(2.0)) * side;
    }

    public double getArea() {
        return side * side / 2;
    }
}