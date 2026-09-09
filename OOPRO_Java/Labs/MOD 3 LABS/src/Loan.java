public class Loan {
    public String loanId;
    public Equipment equipment;
    public Borrower borrower;
    public boolean returned;

    public void printStatus() {
        System.out.println(returned);
    }

    public void printStatus(String label) {
        System.out.println(label + ": " + returned);
    }
}