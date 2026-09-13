public class Details extends Order {

    private String eventDate;
    private String eventVenue;
    private int guestCount;
    private double totalPrice;




    Details(int orderId, String eventDate, String eventVenue, int guestCount, double totalPrice) {
        this.eventDate = eventDate;
        this.eventVenue = eventVenue;
        this.guestCount = guestCount;
        this.totalPrice = totalPrice;
    }


}
