
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

        dishAmount = (int) (Math.ceil(guestCount + (guestCount * 0.2)));
        serviceCost =  (menuPrice * dishAmount) / 10;
    }

    @Override
    public String toString() {
        return "\nOrder: { Name: "  + customerName
                + " }, \n{ Order ID: " + orderId
                + " }, \n{ Item: " + item
                + " }, \n{ Total # of Servings: " + (dishAmount)
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
