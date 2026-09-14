void main() {


    /* I forgot there really isn't a way to
    have a dynamic array in Java (at least not without some complications)
    so for now, this is locked to 4 slots
     */
    Order[] OrderList = new Order[4];

    //Instantly initialize a preset menu (this could be changed so that a custom menu can be made later on
    //String itemName, double price, String category
    Menu[] Menu = new Menu[5];
    Menu[0] = new Menu("Salad", 25, "Side");
    Menu[1] = new Menu("Cupcake", 15, "Dessert");
    Menu[2] = new Menu("Fried Chicken", 20, "Main");
    Menu[3] = new Menu("Lumpia", 10, "Main");
    Menu[4] = new Menu("Brownie", 15, "Dessert");



    int choice;

    do {
        //This is prone to breaking from a blank input, will be fixed in a future change (nvm lmao)
        choice = Integer.parseInt(IO.readln("""
                \nCALCUCATERING CATERING SYSTEM:
                1. Add New Order
                2. Remove Existing Order
                3. Edit Existing Order
                4. View Existing Orders
                5. Search for an Order
                0. Exit
                
                Chose an Option: 
                """));

        //Switch REMOVED while I build the new classes
    switch(choice) {
        case 1:
            System.out.println("\nCurrently Available Slots: ");
            int available = 0;
            for (int i = 0; i < OrderList.length; i++) {
                if (OrderList[i] == null) {
                    System.out.println("Slot " + (i + 1) + " is available.");
                    available++;
                }
            }
            if (available == 0) {
                System.out.println("There are no available slots");
                break;
            }
            choice = Integer.parseInt(IO.readln("""
                    Select a slot to add to: 
                    """));

            if (OrderList[choice] != null) {
                System.out.println("That slot is not available!");
            } else {


                System.out.println("\nList of Available Items: ");
                for (int i = 0; i < Menu.length; i++) {
                    System.out.println((i+1)+ ": " +Menu[i].getItemName() + ": " + Menu[i].getPrice() + "PHP");
                }

                int selectFood = Integer.parseInt(
                        IO.readln("Enter the item being ordered: ")
                );

                Customer customer = new Customer(Integer.parseInt(
                        IO.readln("Enter an ID number for this customer: ")),
                        IO.readln("Enter the customers name: "),
                        IO.readln("Enter the customers phone #: ")
                );

                System.out.println("New Customer Created!");





                System.out.println("Order Creation:");
                OrderList[choice] = new Details(customer.getName(),
                        Integer.parseInt(IO.readln("Enter an ID for this order")),
                        Menu[selectFood].getItemName(),
                        IO.readln("Enter the quantity of this item: "),
                        Menu[selectFood].getPrice(),





                        );

            }


            break;

        case 2:
            available = 0;
            System.out.println("\nExisting orders:");
            for (int i = 0; i < OrderList.length; i++) {
                if (OrderList[i] != null) {
                    System.out.println("Slot " + (i + 1) + ": \n");
                } else {
                    available++;
                }
            }
            if (available >= OrderList.length) {
                System.out.println("There are no filled slots");
            }
            break;

        case 3:
            available = 0;
            System.out.println("\nExisting orders:");
            for (int i = 0; i < OrderList.length; i++) {
                if (OrderList[i] != null) {
                    System.out.println("Slot " + (i + 1) + ": \n");
                } else {
                    available++;
                }
            }
            if (available >= OrderList.length) {
                System.out.println("There are no filled slots");
            }
            break;

        case 4:
            available = 0;
            System.out.println("\nExisting orders:");
            for (int i = 0; i < OrderList.length; i++) {
                if (OrderList[i] != null) {
                    System.out.println("Slot " + (i + 1));
                } else {
                    available++;
                }
            }

            choice = Integer.parseInt(IO.readln("""
                    Select a slot to view:     
                    """));
                System.out.println(OrderList[choice].toString());



            if (available >= OrderList.length) {
                System.out.println("There are no filled slots");
            }
            break;

        case 5:
            available = 0;
            System.out.println("\nExisting orders:");
            for (int i = 0; i < OrderList.length; i++) {
                if (OrderList[i] != null) {
                    System.out.println("Slot " + (i + 1) + ": \n");
                } else {
                    available++;
                }
            }
            if (available >= OrderList.length) {
                System.out.println("There are no filled slots");
            }
            break;


    }
    } while (choice != 0);
}
