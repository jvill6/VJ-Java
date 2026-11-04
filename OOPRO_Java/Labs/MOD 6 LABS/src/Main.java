import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner userIn = new Scanner(System.in);

        BankAccount userAccount = new BankAccount(1000);
        int choice = 3;
        do {
            System.out.println("""
                    BANKING TERMINAL SYSTEM - Select an Option:
                    1. Deposit
                    2. Withdraw
                    0. Exit
                    """);
            choice = userIn.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Deposit Selected - Enter Deposit Amount: ");
                    userAccount.deposit(userIn.nextDouble());
                    System.out.println("Deposit was successful. \nNew Balance is " + userAccount.getBalance() + " PHP.");
                    break;
                case 2:
                    System.out.println("Withdraw Selected - Enter Withdrawal Amount: ");
                    userAccount.withdraw(userIn.nextDouble());
                    System.out.println("W/D was successful. \nNew Balance is " + userAccount.getBalance() + " PHP.");
                    break;
                case 0:
                    System.out.println("Exiting program..");
                    break;
                default:
                    System.out.println("Invalid Option.");
            }
        } while (choice != 0);
    };

}