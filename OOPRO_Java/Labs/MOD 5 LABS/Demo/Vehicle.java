abstract class Vehicle {
    private String driver;

    public Vehicle(String driver) {
        this.driver = driver;
    }

    public void showDriver() {
        System.out.println("Driver: " + driver);
    }

    public abstract void calculateFare(int kilometers);
}