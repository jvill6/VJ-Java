public class BankAccount {
    private double balance;

    public BankAccount(double openingBalance) {
        if (openingBalance < 0) {
            throw new ArithmeticException()
        }
    };
    public double getBalance();
    public void deposit(double amount);
    public void withdraw(double amount);
}

public class Main {
    public static void main(String[] args);
    // Add private input/menu helper methods as needed.
}