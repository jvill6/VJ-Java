public class Menu {
    private final String itemName;
    private final double price;
    private final String category;

    Menu (String itemName, double price, String category) {
        if (itemName == null || itemName.isBlank()) {
            throw new IllegalArgumentException("Menu item name must not be blank.");
        }
        if (!Double.isFinite(price) || price < 0) {
            throw new IllegalArgumentException("Menu price must be a finite, non-negative amount.");
        }
        if (category == null || category.isBlank()) {
            throw new IllegalArgumentException("Menu category must not be blank.");
        }

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
