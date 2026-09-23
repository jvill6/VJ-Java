public class Customer {
    private final int customerId;
    private final String name;
    private String phone;

    Customer (int customerId, String name, String phone) {
        this.customerId = customerId;
        this.name = name;
        this.phone = phone;
    }

    public String getName() {
        return this.name;
    }

    public int getCustomerId() {
        return customerId;
    }

    public String getPhone() {
        return phone;
    }
}

