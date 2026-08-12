
String[] addOrder(String[] currentList) {

    int slotCount = 0;
    int targetIndex;
    String details;

    IO.println("Available Slots: ");
    for (int i = 0; i < currentList.length; i++) {
        if (currentList[i] == null) {
            IO.println("Order Slot " + (i+1) + " is available");
            slotCount++;
        }
    } if (slotCount == 0) {
        IO.println("There are no available slots.");
        //Returns early to break out of function without modifying the existing array
        return currentList;
    }

    do {
        targetIndex = Integer.parseInt(IO.readln(
                "Enter a slot to add order: ")
        );

        if (currentList[targetIndex - 1] != null) {
            IO.println("This slot isn't available!");
        }
    } while (currentList[targetIndex - 1] != null);

    details = IO.readln("\nEnter the order details: ");
    currentList[targetIndex - 1] = details;
    IO.println("Order Added!");

    return currentList;
}

String[] removeOrder(String[] currentList) {
    IO.println("Current Order List: ");

    //Simplifying by reusing an already existing method to display list
    displayList(currentList);

    int targetIndex = Integer.parseInt(
            IO.readln("Enter an order to remove: ")
    );

    currentList[targetIndex - 1] = null;

    return currentList;
}

String[] editOrder(String[] currentList) {
    IO.println("Current Order List: ");

    //Simplifying by reusing an already existing method to display list
    displayList(currentList);

    int targetIndex = Integer.parseInt(
            IO.readln("Enter an order to edit: ")
    );

    currentList[targetIndex-1] = IO.readln("Enter new details for this order: ");
    return currentList;
}

String findOrder(String[] currentList) {
    //This function is practically useless for such a small array, but it has to be here for the assignment
    int orderIndex;
    orderIndex = Integer.parseInt(IO.readln("Enter the slot of the order: "));

    orderIndex -= 1;

    return ("Order #" + (orderIndex + 1) + " is " + currentList[orderIndex]);
}

void displayList(String[] currentList){
    for (int i = 0; i < currentList.length; i++) {
        if (currentList[i] == null) {
            IO.println("Slot " + (i+1) + " is empty.");
        } else {
            IO.println("Slot " + (i+1) + ": " + currentList[i]);
        }
    }
}



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
                OrderList = addOrder(OrderList);
                break;
            case 2:
                IO.println("Remove Selected\n");
                OrderList = removeOrder(OrderList);
                break;
            case 3:
                IO.println("Edit Selected\n");
                OrderList = editOrder(OrderList);
                break;
            case 4:
                IO.println("Display Selected\n");
                displayList(OrderList);
                break;
            case 5:
                IO.println("Search Selected\n");
                IO.println(findOrder(OrderList));

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
