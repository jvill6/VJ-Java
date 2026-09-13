
//This class contains the information relating to the EVENT where the service is being held
public class Details extends Order {

    private String eventDate;
    private String eventVenue;
    private int guestCount;

    public Details(Customer customerName, int orderId, int dishAmount, Menu menuPrice, int serviceCost, String eventDate, String eventVenue, int guestCount) {
        super(customerName, orderId, dishAmount, menuPrice, serviceCost);

        this.eventDate = eventDate;
        this.eventVenue = eventVenue;
        this.guestCount = guestCount;
    }


}
