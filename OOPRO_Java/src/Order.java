
//This class contains info on the catering service itself (like the price, how many dishes were ordered, etc)
//Name, event date, total number per dish, total price each dish, service cost, overall cost
public class Order {

    protected int orderId;
    protected int dishAmount;
    protected double serviceCost;

    //Stuff that gets referenced from other classes
    protected String customerName;
    protected String item;
    protected double menuPrice;

    public Order (String customerName, int orderId, String item, double menuPrice) {
        this.customerName = customerName;
        this.orderId = orderId;
        this.item = item;
        this.menuPrice = menuPrice;
    }

    public double totalPrice() {
        return (dishAmount * menuPrice) + serviceCost;
    }
}
