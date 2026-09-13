

//This class contains the information relating to the EVENT where the service is being held
public class Details extends Order {

    private String eventDate;
    private String eventVenue;
    private int guestCount;

    //Stuff Borrowed from other classes
    private Order orderId;

    Details(Order orderId, String eventDate, String eventVenue, int guestCount) {
        this.eventDate = eventDate;
        this.eventVenue = eventVenue;
        this.guestCount = guestCount;
    }


}
