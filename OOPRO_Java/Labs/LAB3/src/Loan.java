//i forgor

import java.time.LocalDate;

public class Loan {
    private final String loanId;
    private final Equipment equipment;
    private final LocalDate borrowingDate;
    private final LocalDate dueDate;


    public Loan(
            String loanId,
            Equipment equipment,
            LocalDate borrowingDate,
            LocalDate dueDate
    ) {

        // Enforce these minimum invariants:
        // loanId must not be null or blank.
        // equipment must not be null.
        // borrowingDate must not be null.
        // dueDate must not be null.
        // dueDate must not be before borrowingDate.

        if (loanId == null || loanId.isBlank()) {
            throw new IllegalArgumentException(
                    "Loan ID must not be blank.");
        }


        if (borrowingDate.isAfter(dueDate) || borrowingDate.isEqual(dueDate) ) {
            throw new IllegalArgumentException(
                    "Due date must not be before borrowing date.");
        }







        this.loanId = loanId;
        this.equipment = equipment;
        this.borrowingDate = borrowingDate;
        this.dueDate = dueDate;


    }




    public String getLoanId() { return loanId; }
    public Equipment getEquipment() { return equipment; }
    public LocalDate getBorrowingDate() { return borrowingDate; }
    public LocalDate getDueDate() { return dueDate; }
}
