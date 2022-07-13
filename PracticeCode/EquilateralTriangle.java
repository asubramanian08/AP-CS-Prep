package PracticeCode;

public class EquilateralTriangle extends Triangle {
    public EquilateralTriangle(double side) {
        super(side);
    }

    public double getPerimeter() {
        return 3 * side;
    }

    public double getArea() {
        return Math.sqrt(3) / 4 * side * side;
    }
}