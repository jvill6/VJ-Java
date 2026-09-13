public class Order_Details {
    private int orderId;
    private String customerName;
    private String eventDate;
    private String eventVenue;
    private int guestCount;
    private double totalPrice;


    Order_Details (int orderId, String customerName, String eventDate, String eventVenue, int guestCount, double totalPrice) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.eventDate = eventDate;
        this.eventVenue = eventVenue;
        this.guestCount = guestCount;
        this.totalPrice = totalPrice;
    }
}
