class Jeepney extends Vehicle {
    public Jeepney(String driver) {
        super(driver);
    }

    @Override
    public void calculateFare(int kilometers) {
        int fare = 13 + (kilometers > 4 ? (kilometers - 4) * 2 : 0);
        System.out.println("Jeepney fare for " + kilometers + " km: PHP " + fare);
    }
}