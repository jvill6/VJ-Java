class Bus extends Vehicle {
    public Bus(String driver) {
        super(driver);
    }

    @Override
    public void calculateFare(int kilometers) {
        int fare = 15 + (kilometers > 5 ? (kilometers - 5) * 2 : 0);
        System.out.println("Bus fare for " + kilometers + " km: PHP " + fare);
    }
}