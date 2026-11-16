//This class contains info on the catering service itself (like the price, how many dishes were ordered, etc)
//Name, event date, total number per dish, total price each dish, service cost, overall cost
public abstract class Order implements Billable {
    private int orderId;
    private final String[] items;
    private final double[] menuPrices;
    private final int[] dishAmounts;

    private String customerName;

    public Order(String customerName, int orderId, String[] items, double[] menuPrices, int[] dishAmounts) {
        if (customerName == null || customerName.isBlank()) {
            throw new InvalidOrderArgumentException("Customer name must not be blank.");
        }
        if (orderId <= 0) {
            throw new InvalidOrderArgumentException("Order ID must be positive.");
        }
        if (items == null || menuPrices == null || dishAmounts == null
                || items.length == 0 || items.length != menuPrices.length || items.length != dishAmounts.length) {
            throw new InvalidOrderArgumentException("Order items, prices, and quantities must have matching non-zero lengths.");
        }

        for (int i = 0; i < items.length; i++) {
            if (items[i] == null || items[i].isBlank()) {
                throw new InvalidOrderArgumentException("Item names must not be blank.");
            }
            if (!Double.isFinite(menuPrices[i]) || menuPrices[i] < 0) {
                throw new InvalidOrderArgumentException("Menu prices must be finite and non-negative.");
            }
            if (dishAmounts[i] <= 0) {
                throw new InvalidOrderArgumentException("Item quantities must be greater than zero.");
            }
        }
        
        this.customerName = customerName;
        this.orderId = orderId;
        this.items = items.clone();
        this.menuPrices = menuPrices.clone();
        this.dishAmounts = dishAmounts.clone();
    }

    @Override
    public double totalPrice() {
        return subtotal() + getServiceCost();
    }

    //I have a fairly strong feeling that the setters will not be used, but I'll leave them here anyways.
    protected int getOrderId() { return orderId; }
    protected void setOrderId (int OrderId) { this.orderId = OrderId; }
    protected int getItemCount() { return items.length; }
    protected int getDishAmount(int index) { return dishAmounts[index]; }
    protected double getServiceCost() { return subtotal() / 10; }
    protected String getCustomerName() { return customerName; }
    protected void setCustomerName(String customerName) { this.customerName = customerName; }
    protected String getItem(int index) { return items[index]; }
    protected double getMenuPrice(int index) { return menuPrices[index]; }
    protected double getLineTotal(int index) { return dishAmounts[index] * menuPrices[index]; }

    protected boolean containsItem(String itemName) {
        for (String item : items) {
            if (item.equalsIgnoreCase(itemName)) {
                return true;
            }
        }
        return false;
    }

    private double subtotal() {
        double total = 0;
        for (int i = 0; i < items.length; i++) {
            total += dishAmounts[i] * menuPrices[i];
        }
        return total;
    }
    //oh. my. god.



    public abstract String formatDetails();
}
