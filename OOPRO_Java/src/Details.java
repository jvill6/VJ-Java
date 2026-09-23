
//This class contains the information relating to the EVENT where the service is being held
public class Details extends Order {

    private String eventDate;
    private String eventVenue;
    private int guestCount;

    //Referenced
    private int customerId;
    private String customerPhone;

    public Details(String customerName, int orderId, String item, double menuPrice,
                   String eventDate, String eventVenue, int guestCount, int customerId, String customerPhone) {

        super(customerName, orderId, item, menuPrice);

        this.eventDate = eventDate;
        this.eventVenue = eventVenue;
        this.guestCount = guestCount;

        this.customerPhone = customerPhone;
        this.customerId = customerId;

        dishAmount = (int) (Math.ceil(guestCount + (guestCount * 0.2)));
        serviceCost =  (menuPrice * dishAmount) / 10;
    }

    @Override
    public String toString() {
        return "\nOrder: { Order ID: " + orderId
                + " }, \n{ Item: " + item
                + " }, \n{ Total # of Servings: " + (dishAmount)
                + " }, \n{ Price per Item: " + menuPrice
                + " }, \n{ Service Cost: " + serviceCost
                + " }, \n{ Total Cost: " + totalPrice()
                +" }\n\nDetails: { Customer Name: " + customerName
                +" }\n{ Customer Phone #: " + customerPhone
                +" }\n{ Customer ID # : " + customerId
                +" }\n{ Event Date: " + eventDate
                +" }\n{ Event Venue: " + eventVenue
                +" }\n{ # of Guests: " + guestCount + " }";
    }
}
