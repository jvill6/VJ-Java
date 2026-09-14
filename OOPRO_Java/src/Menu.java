public class Menu {
    private final String itemName;
    private final double price;
    private final String category;

    Menu (String itemName, double price, String category) {
        this.itemName = itemName;
        this.price = price;
        this.category = category;
    }

    public double getPrice() {
        return price;
    }
    public String getItemName() { return itemName; }
    public String getCategory() { return category; }
}
