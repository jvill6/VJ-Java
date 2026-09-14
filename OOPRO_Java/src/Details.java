
//This class contains the information relating to the EVENT where the service is being held
public class Details extends Order {

    private String eventDate;
    private String eventVenue;
    private int guestCount;

    public Details(String customerName, int orderId, String item, int dishAmount, double menuPrice, int serviceCost,
                   String eventDate, String eventVenue, int guestCount) {
        super(customerName, orderId, item, dishAmount, menuPrice, serviceCost);

        this.eventDate = eventDate;
        this.eventVenue = eventVenue;
        this.guestCount = guestCount;
    }

    public double totalPrice() {
        return (guestCount * dishAmount * menuPrice) + serviceCost;
    }

    @Override
    public String toString() {
        return "Order {Name: "  + customerName
                + ", Order ID: " + orderId
                + ", Item: " + item
                + ", # of Guests: " + guestCount
                + ", # of Servings per Guest: " + dishAmount
                + ", Total # of Servings: " + (guestCount * dishAmount)
                + ", Price per Item: " + menuPrice
                + ", Service Cost: " + serviceCost
                + ", Total Cost: " + totalPrice()
                +"}\n";
    }



    @Override
    void editOrder(int choice) {

    }


}
