public class BankAccount {
    private double balance;

    public BankAccount(double openingBalance) {
        if (openingBalance <= 0) {
            throw new ArithmeticException("Opening Balance cannot be negative or zeroed.");
        } else {
            this.balance = openingBalance;
        }
    };
    public double getBalance() {
        return balance;
    };
    public void deposit(double amount) {
        if (amount <= 0) {
            throw new ArithmeticException("You cannot deposit a negative/zero amount.");
        } else {
            balance += amount;
        }
    };
    public void withdraw(double amount) {
        if (amount <= 0) {
            throw new ArithmeticException("You cannot withdraw a negative/zero amount.");
        } else {
            balance -= amount;
        }
    };
}
