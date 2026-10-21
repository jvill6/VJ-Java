class Taxi extends Vehicle {
    public Taxi(String driver) {
        super(driver);
    }

    @Override
    public void calculateFare(int kilometers) {
        int fare = 45 + kilometers * 15;

        System.out.println("Taxi fare for " + kilometers
                + " km: PHP " + fare);
    }
}