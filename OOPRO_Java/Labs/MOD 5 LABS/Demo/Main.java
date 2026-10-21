public class Main {
    public static void main(String[] args) {
        // Vehicle example = new Vehicle("Alex"); // Compile error: Vehicle is abstract.
        Vehicle[] rides = {
                new Jeepney("Ana"),
                new Taxi("Ben"),
                new Tricycle("Carlo")
        };

        for (Vehicle ride : rides) {
            ride.showDriver();
            ride.calculateFare(5);
            System.out.println("---");
        }
    }
}