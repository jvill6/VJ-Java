void main() {
    int choice;

    String Order = "";

    do {
        IO.println("""
                CALCUCATERING CATERING SYSTEM:
                1. Add New Order
                2. Remove Existing Order
                3. Edit Existing Order
                4. View Existing Orders
                5. Add Service Feedback Record
                0. Exit
                """);

        choice = Integer.parseInt(
                IO.readln("Choose an Option: ")
        );


        //Error check



        switch (choice) {
            case 1:
                IO.println("Add Selected\n");
                Order = IO.readln("Enter the Order Name: ");
                IO.println("Order: " + Order + " has been added.");
                break;
            case 2:
                IO.println("Remove Selected\n");
                String confirmation;
                do {
                    confirmation = IO.readln(
                            "Remove Order " + Order + "? (yes/no)"
                    );
                    if (confirmation.equalsIgnoreCase("yes")) {
                        Order = "";
                        IO.println("Order Removed.");
                        break;
                    } else {
                        choice = -1;
                    }
                } while (!confirmation.equalsIgnoreCase("no"));
                break;
            case 3:
            case 4:
            case 5: break;
            case 0:
                do {
                    confirmation = IO.readln(
                            "Exit the program? (yes/no)"
                    );
                    if (confirmation.equalsIgnoreCase("yes")) {
                        choice = 0;
                        IO.println("Exiting Program");
                        break;
                    } else {
                        choice = -1;
                    }
                } while (!confirmation.equalsIgnoreCase("no"));
                break;
            default:
                IO.println("Invalid option");

        }
    } while (choice != 0);
}