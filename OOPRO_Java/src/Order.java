
//This class contains info on the catering service itself (like the price, how many dishes were ordered, etc)
//Name, event date, total number per dish, total price each dish, service cost, overall cost
public class Order {

    protected int orderId;
    public int dishAmount;
    public int serviceCost;

    //Stuff that gets referenced from other classes
    public Customer customerName;
    public Menu itemName;
    public double menuPrice;

    public Order (Customer customerName, int orderId, Menu itemName, int dishAmount, double menuPrice, int serviceCost) {
        this.customerName = customerName;
        this.orderId = orderId;
        this.itemName = itemName;
        this.dishAmount = dishAmount;
        this.menuPrice = menuPrice;
        this.serviceCost = serviceCost;
    }

    void editOrder(int choice) {

    }

}
