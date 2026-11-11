//This class contains info on the catering service itself (like the price, how many dishes were ordered, etc)
//Name, event date, total number per dish, total price each dish, service cost, overall cost
public abstract class Order implements Billable {
    protected int orderId;
    protected int dishAmount;
    protected double serviceCost;

    protected String customerName;
    protected String item;
    protected double menuPrice;

    public Order(String customerName, int orderId, String item, double menuPrice) {
        this.customerName = customerName;
        this.orderId = orderId;
        this.item = item;
        this.menuPrice = menuPrice;
    }

    @Override
    public double totalPrice() {
        return (dishAmount * menuPrice) + serviceCost;
    }

    public abstract String formatDetails();
}
