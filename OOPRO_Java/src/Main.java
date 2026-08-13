class main {
    void main() {
        int choice;
    /* I forgot there really isn't a way to
    have a dynamic array in Java (at least not without some complications)
    so for now, this is locked to 4 slots
     */
        String[] OrderList = new String[4];


        do {
            IO.println("""
                    \nCALCUCATERING CATERING SYSTEM:
                    1. Add New Order
                    2. Remove Existing Order
                    3. Edit Existing Order
                    4. View Existing Orders
                    5. Search for an Order
                    0. Exit
                    """);

            //This is prone to breaking from a blank input, will be fixed in a future change
            choice = Integer.parseInt(
                    IO.readln("Choose an Option: ")
            );

            switch (choice) {
                case 1:
                    IO.println("Add Selected\n");
                    OrderList = Orders.addOrder(OrderList);
                    break;
                case 2:
                    IO.println("Remove Selected\n");
                    OrderList = Orders.removeOrder(OrderList);
                    break;
                case 3:
                    IO.println("Edit Selected\n");
                    OrderList = Orders.editOrder(OrderList);
                    break;
                case 4:
                    IO.println("Display Selected\n");
                    Orders.displayList(OrderList);
                    break;
                case 5:
                    IO.println("Search Selected\n");
                    IO.println(Orders.findOrder(OrderList));

                    break;
                case 0:
                    String confirmation;
                    do {
                        confirmation = IO.readln(
                                "Exit the program? (yes/no )"
                        );
                        if (confirmation.equalsIgnoreCase("yes")) {
                            choice = 0;
                            IO.println("Exiting Program");
                            break;
                        } else {
                            //Basically just makes sure the choice is anything but 0 (otherwise the program would end)
                            choice = -1;
                        }
                    } while (!confirmation.equalsIgnoreCase("no"));
                    break;
                default:
                    IO.println("Invalid option");

            }
        } while (choice != 0);
    }
}