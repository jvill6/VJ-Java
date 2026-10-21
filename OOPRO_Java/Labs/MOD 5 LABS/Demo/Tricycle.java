class Tricycle extends Vehicle {
    public Tricycle(String driver) {
        super(driver);
    }

    @Override
    public void calculateFare(int kilometers) {
        int fare = kilometers <= 2 ? 30 : 30 + (kilometers - 2) * 10;

        System.out.println("Tricycle fare for " + kilometers + " km: PHP " + fare);
    }
}