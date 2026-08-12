
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
    }
    if (slotCount == 0) {
        IO.println("There are no available slots.");
        //Returns early to break out of function without modifying the existing array
        return currentList;
    }

    targetIndex = Integer.parseInt(IO.readln(
            "Enter a slot to add order: ")
    );




    details = IO.readln("\nEnter the order details: ");

    currentList[targetIndex - 1] = details;

    IO.println("Order Added!");

    return currentList;
}

String[] removeOrder(String[] currentList) {

    return currentList;
}

String[] editOrder(String[] currentList) {

    return currentList;
}

String findOrder(String[] currentList) {
    int orderIndex = 0;
    return currentList[orderIndex];
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

        choice = Integer.parseInt(
                IO.readln("Choose an Option: ")
        );


        //Error check



        switch (choice) {
            case 1:
                IO.println("Add Selected\n");
                OrderList = addOrder(OrderList);
                break;
            case 2:
                IO.println("Remove Selected\n");
                break;
            case 3:
                IO.println("Edit Selected\n");
                break;
            case 4:
                IO.println("Display Selected\n");
                displayList(OrderList);
                break;
            case 5:
                IO.println("Search Selected\n");
                break;
            case 0:
                String confirmation;
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
