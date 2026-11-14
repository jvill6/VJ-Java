public class Customer {
    private final int customerId;
    private final String name;
    private final String phone;

    Customer (int customerId, String name, String phone) {

        //Input Validation for customer
        //This is not included in the exception class because that class is specifically for Orders/Details ONLY

        if (customerId <= 0) {
            throw new IllegalArgumentException("Customer ID must be positive.");
        }
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Customer name must not be blank.");
        }
        if (phone == null || phone.isBlank()) {
            throw new IllegalArgumentException("Customer phone must not be blank.");
        }
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

