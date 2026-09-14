
//This class contains info on the catering service itself (like the price, how many dishes were ordered, etc)
//Name, event date, total number per dish, total price each dish, service cost, overall cost
public class Order {

    protected int orderId;
    public int dishAmount;
    public int serviceCost;

    //Stuff that gets referenced from other classes
    public String customerName;
    public String item;
    public double menuPrice;

    public Order (String customerName, int orderId, String item, int dishAmount, double menuPrice, int serviceCost) {
        this.customerName = customerName;
        this.orderId = orderId;
        this.item = item;
        this.dishAmount = dishAmount;
        this.menuPrice = menuPrice;
        this.serviceCost = serviceCost;
    }

    void editOrder(int choice) {

    }

}
