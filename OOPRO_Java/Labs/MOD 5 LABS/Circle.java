public class Circle extends Shape {
    private double radius;

    public Circle (double radius) {
        if (radius > 0) {
            this.radius = radius;
        }
    }

    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public String getName() {
        return "Circle";
    }

    public double getRadius() {
        return radius;
    }
}
