public class Square extends Shape {

    private double sideLength;


    public Square(double sideLength) {
        if (sideLength > 0) {this.sideLength = sideLength;}
    }

    @Override
    public double getArea() {
        return sideLength*sideLength;
    }

    @Override
    public String getName() {
        return "Square";
    }

    public double getSideLength() {
        return sideLength;
    }
}
