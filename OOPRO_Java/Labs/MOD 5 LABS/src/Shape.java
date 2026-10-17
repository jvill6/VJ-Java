public abstract class Shape {
    public abstract double getArea();
    public abstract String getName();
    public void displayInfo() {
        System.out.println(getName());
        System.out.println(getArea());
    }
}
