public class Orders {
    //lalalalalala
    static String[] addOrder(String[] currentList) {

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

    static String[] removeOrder(String[] currentList) {
        IO.println("Current Order List: ");

        //Simplifying by reusing an already existing method to display list
        displayList(currentList);

        int targetIndex = Integer.parseInt(
                IO.readln("Enter an order to remove: ")
        );

        currentList[targetIndex - 1] = null;

        return currentList;
    }

    static String[] editOrder(String[] currentList) {
        IO.println("Current Order List: ");

        //Simplifying by reusing an already existing method to display list
        displayList(currentList);

        int targetIndex = Integer.parseInt(
                IO.readln("Enter an order to edit: ")
        );

        currentList[targetIndex-1] = IO.readln("Enter new details for this order: ");
        return currentList;
    }

    static String findOrder(String[] currentList) {
        //This function is practically useless for such a small array, but it has to be here for the assignment
        int orderIndex;
        orderIndex = Integer.parseInt(IO.readln("Enter the slot of the order: "));

        orderIndex -= 1;

        return ("Order #" + (orderIndex + 1) + " is " + currentList[orderIndex]);
    }

    static void displayList(String[] currentList){
        for (int i = 0; i < currentList.length; i++) {
            if (currentList[i] == null) {
                IO.println("Slot " + (i+1) + " is empty.");
            } else {
                IO.println("Slot " + (i+1) + ": " + currentList[i]);
            }
        }
    }

}
