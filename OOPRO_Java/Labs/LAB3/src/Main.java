void main() {
    testValidEquipment();
    testBlankEquipmentId();
    testBlankEquipmentName();
    testNegativeLateFee();
    testValidLoan();
    testInvalidLoanDateRange();
    demonstrateLab2Behavior();
}


void testValidEquipment() {
    try {
        var equipment = new Equipment(
                "EQ-1001",
                "Dell Latitude Laptop",
                50.00
        );


        IO.println(
                "PASS: valid equipment created: "
                        + equipment.getEquipmentId()
        );
    } catch (IllegalArgumentException exception) {
        IO.println(
                "FAIL: valid equipment was rejected: "
                        + exception.getMessage()
        );
    }
}


void testBlankEquipmentId() {
    try {
        new Equipment("   ", "Dell Latitude Laptop", 50.00);
        IO.println("FAIL: blank equipment ID was accepted.");
    } catch (IllegalArgumentException exception) {
        IO.println("PASS: blank ID rejected: " + exception.getMessage());
    }
}


void testBlankEquipmentName() {
    try {
        new Equipment("EQ-1002", "   ", 50.00);
        IO.println("FAIL: blank equipment name was accepted.");
    } catch (IllegalArgumentException exception) {
        IO.println("PASS: blank name rejected: " + exception.getMessage());
    }
}


void testNegativeLateFee() {
    try {
        new Equipment("EQ-1003", "Epson Projector", -75.00);
        IO.println("FAIL: negative late fee was accepted.");
    } catch (IllegalArgumentException exception) {
        IO.println("PASS: negative late fee rejected: " + exception.getMessage());
    }
}


void testValidLoan() {
    try {
        var equipment = new Equipment("EQ-1004", "Canon Camera", 40.00);


        var loan = new Loan(
                "LN-1001",
                equipment,
                LocalDate.of(2026, 8, 10),
                LocalDate.of(2026, 8, 17)
        );
        IO.println(
                "PASS: valid loan created: "
                        + loan.getLoanId()
        );
    } catch (IllegalArgumentException exception) {
        IO.println(
                "FAIL: valid loan was rejected: "
                        + exception.getMessage()
        );
    }
}


void testInvalidLoanDateRange() {
    try {
        var equipment = new Equipment("EQ-1005", "Portable Projector", 75.00);
        new Loan(
                "LN-1002",
                equipment,
                LocalDate.of(2026, 8, 10),
                LocalDate.of(2026, 8, 5)
        );
        IO.println("FAIL: invalid loan date range was accepted.");
    } catch (IllegalArgumentException exception) {
        IO.println("PASS: invalid date range rejected: " + exception.getMessage());
    }
}


void demonstrateLab2Behavior() {
    var laptop = new Equipment(
            "EQ-2001",
            "Dell Latitude Laptop",
            50.00
    );


    IO.println();
    IO.println("Continuity Check");
    IO.println(laptop.getEquipmentId() + " - " + laptop.getName());
    IO.println("Can be borrowed: " + laptop.canBeBorrowed());


    laptop.borrow();
    IO.println("After borrowing: " + laptop.isAvailable());


    laptop.returnEquipment();
    IO.println("After return: " + laptop.isAvailable());


    IO.println(
            "Late fee for 3 overdue days: PHP "
                    + String.format("%.2f", laptop.calculateLateFee(3))
    );


    IO.println("Times borrowed: " + laptop.getTimesBorrowed());
}


/*
PASS: valid equipment created: EQ-1001
PASS: blank ID rejected: Equipment ID must not be blank.
PASS: blank name rejected: Equipment name must not be blank.
PASS: negative late fee rejected: Daily late fee must not be negative.
PASS: valid loan created: LN-1001
PASS: invalid date range rejected: Due date must not be before borrowing date.


Continuity Check
EQ-2001 - Dell Latitude Laptop
Can be borrowed: true
After borrowing: false
After return: true
Late fee for 3 overdue days: PHP 150.00
Times borrowed: 1
*/
