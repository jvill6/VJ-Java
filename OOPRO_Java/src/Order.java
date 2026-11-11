//This class contains info on the catering service itself (like the price, how many dishes were ordered, etc)
//Name, event date, total number per dish, total price each dish, service cost, overall cost
public abstract class Order implements Billable {
    private int orderId;
    private int dishAmount;
    private double serviceCost;

    private String customerName;
    private String item;
    private double menuPrice;

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

    //I have a fairly strong feeling that the setters will not be used, but I'll leave them here anyways.
    protected int getOrderId() { return orderId; }
    protected void setOrderId (int OrderId) { this.orderId = OrderId; }
    protected int getDishAmount() { return dishAmount; }
    protected void setDishAmount(int dishAmount) { this.dishAmount = dishAmount; }
    protected double getServiceCost() { return serviceCost; }
    protected void setServiceCost(double serviceCost) { this.serviceCost = serviceCost; }
    protected String getCustomerName() { return customerName; }
    protected void setCustomerName(String customerName) { this.customerName = customerName; }
    protected String getItem() { return item; }
    protected void setItem(String item) { this.item = item; }
    protected double getMenuPrice() { return menuPrice; }
    protected void setMenuPrice(double menuPrice) { this.menuPrice = menuPrice; }
    //oh. my. god.



    public abstract String formatDetails();
}
