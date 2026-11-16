//This class contains the information relating to the EVENT where the service is being held
public class Details extends Order {

    private final String eventDate;
    private final String eventVenue;
    private final int guestCount;

    //Referenced
    private final int customerId;
    private final String customerPhone;

    public Details(String customerName, int orderId, String[] items, double[] menuPrices, int[] dishAmounts,
                   String eventDate, String eventVenue, int guestCount, int customerId, String customerPhone) {

        super(customerName, orderId, items, menuPrices, dishAmounts);

        if (guestCount <= 0) {
            throw new InvalidOrderArgumentException("Guest count must be greater than zero.");
        }

        this.eventDate = eventDate;
        this.eventVenue = eventVenue;
        this.guestCount = guestCount;

        this.customerPhone = customerPhone;
        this.customerId = customerId;

    }

    //bruh
    @Override
    public String formatDetails() {
        StringBuilder details = new StringBuilder("\nOrder: { Order ID: ").append(getOrderId()).append(" }");
        for (int i = 0; i < getItemCount(); i++) {
            details.append("\n{ Item: ").append(getItem(i))
                    .append(", Quantity: ").append(getDishAmount(i))
                    .append(", Price per Item: ").append(getMenuPrice(i))
                    .append(", Line Total: ").append(getLineTotal(i)).append(" }");
        }
        return details.append("\n{ Service Cost: ").append(getServiceCost())
                .append(" }, \n{ Total Cost: ").append(totalPrice())
                .append(" }\n\nDetails: { Customer Name: ").append(getCustomerName())
                .append(" }\n{ Customer Phone #: ").append(customerPhone)
                .append(" }\n{ Customer ID # : ").append(customerId)
                .append(" }\n{ Event Date: ").append(eventDate)
                .append(" }\n{ Event Venue: ").append(eventVenue)
                .append(" }\n{ # of Guests: ").append(guestCount).toString();
    }
}
