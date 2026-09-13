class Order {
    String orderId;
    String dishes;
    int guestnum;
    boolean available;

    Order() {
        orderId = "None";
        dishes = "None";
        guestnum = 0;
        available = false;
    }

    Order (String orderId, String dishes, int quantity) {
        this.orderId = orderId;
        this.dishes = dishes;
        this.guestnum = quantity;
        available = true;
    }

    void unavailable() {
        available = false;
    }

    void displayOrder() {
        String status = available
                ? "Available"
                : "Unavailable";

        IO.println(
                orderId + ": " + guestnum + " est.guest | " + dishes + " - " + status
        );
    }
}