
//This class contains the information relating to the EVENT where the service is being held
public class Details extends Order {

    private String eventDate;
    private String eventVenue;
    private int guestCount;

    public Details(String customerName, int orderId, String item, double menuPrice,
                   String eventDate, String eventVenue, int guestCount) {
        super(customerName, orderId, item, menuPrice);

        this.eventDate = eventDate;
        this.eventVenue = eventVenue;
        this.guestCount = guestCount;
    }

    @Override
    public String toString() {
        return "\nOrder: { Name: "  + customerName
                + " }, \n{ Order ID: " + orderId
                + " }, \n{ Item: " + item
                + " }, \n{ # of Servings: " + dishAmount
                + " }, \n{ Total # of Servings: " + (8 * dishAmount)
                + " }, \n{ Price per Item: " + menuPrice
                + " }, \n{ Service Cost: " + serviceCost
                + " }, \n{ Total Cost: " + totalPrice()
                +" }\n\nDetails: { Event Date: " + eventDate
                +" }\n{ Event Venue Address: " + eventVenue
                +" }\n{ # of Guests: " + guestCount + " }";
    }




    void editOrder() {

    }



}
