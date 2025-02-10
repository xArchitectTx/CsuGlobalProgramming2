public class Rectangle extends Shape {
    private double width;
    private double length;

    public Rectangle(double width, double length) {
        this.width = width;
        this.length = length;
    }

    @Override
    public double area() {
        return width * length;
    }

    @Override
    public double perimeter() {
        return 2 * (width + length);
    }

    @Override
    public String toString() {
        return String.format("Rectangle - Area: %.2f, Perimeter: %.2f", area(), perimeter());
    }
}