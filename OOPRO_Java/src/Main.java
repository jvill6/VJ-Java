void main() {


    /* I forgot there really isn't a way to
    have a dynamic array in Java (at least not without some complications)
    so for now, this is locked to 4 slots
     */
    Order[] OrderList = new Order[4];

    //Instantly initialize a preset menu (this could be changed so that a custom menu can be made later on
    //String itemName, double price, String category
    Menu[] Menu = new Menu[5];
    Menu[0] = new Menu("Salad", 15, "Side");
    Menu[1] = new Menu("Cupcakes", 20, "Dessert");
    Menu[2] = new Menu("Fried Chicken", 15, "Main");
    Menu[3] = new Menu("Lumpia", 7, "Main");
    Menu[4] = new Menu("Brownies", 12, "Dessert");



    int choice;

    do {
        //This is prone to breaking from a blank input, will be fixed in a future change (nvm lmao)
        choice = Integer.parseInt(IO.readln("""
                \nCALCUCATERING CATERING SYSTEM:
                1. Add New Order
                2. Remove Existing Order
                3. Find an Order
                4. View Order Details
                5. Display All Orders
                0. Exit
                
                Chose an Option: 
                """));

    int available = 0;
    switch(choice) {
        case 1:
            System.out.println("\nCurrently Available Slots: ");

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

            choice--;


            if (OrderList[choice] != null) {
                System.out.println("That slot is not available!");
            } else {


                System.out.println("\nList of Available Items: ");
                for (int i = 0; i < Menu.length; i++) {
                    System.out.println((i+1)+ ": " +Menu[i].getItemName() + ": " + Menu[i].getPrice() + "PHP");
                }

                int selectFood = Integer.parseInt(
                        IO.readln("\nEnter the item being ordered: ")
                ) - 1 ;

                Customer customer = new Customer(Integer.parseInt(
                        IO.readln("\nEnter an ID number for this customer: ")),
                        IO.readln("Enter the customers name: "),
                        IO.readln("Enter the customers phone #: ")
                );

                System.out.println("New Customer Created!\n");





                System.out.println("Order Creation:");
                OrderList[choice] = new Details(customer.getName(),
                        Integer.parseInt(IO.readln("Enter an ID for this order: ")),
                        Menu[selectFood].getItemName(),
                        Menu[selectFood].getPrice(),
                        IO.readln("Enter the Event Date (DD/MM/YYYY): "),
                        IO.readln("Enter the Venue Address: "),
                        Integer.parseInt(IO.readln("Enter the # of guests: ")),
                        customer.getCustomerId(),
                        customer.getPhone()
                        );

            }

            System.out.println(OrderList[choice].toString());

            //preventing choice from being 0 if slot 1 was chosen
            choice++;

            break;

        case 2:

            System.out.println("\nExisting orders:");
            for (int i = 0; i < OrderList.length; i++) {
                if (OrderList[i] != null) {
                    System.out.println("Slot " + (i + 1) + ": ");
                } else {
                    available++;
                }
            }
            if (available >= OrderList.length) {
                System.out.println("There are no filled slots");
                break;
            }

            choice = Integer.parseInt(IO.readln(
                    "Select a slot to remove: "
                    ));

            choice--;


            if (OrderList[choice] == null) {
                System.out.println("That slot is empty!");
                choice++;
                break;
            }

            OrderList[choice] = null;
            System.out.println("Order Removed");

            choice++;
            break;

        case 3:
            System.out.println("""
                    Search Orders:
                    1. Search by Order ID
                    2. Search by Item Ordered
                    """);
            int searchOption = Integer.parseInt(IO.readln("Enter search option: "));

            if (searchOption == 1) {
                filterOrders(Integer.parseInt(IO.readln("Enter the Order ID: ")), OrderList);
            } else if (searchOption == 2) {
                filterOrders(IO.readln("Enter the item name: "), OrderList);
            } else {
                System.out.println("Invalid Option.\n");
                break;
            }



            break;

        case 4:

            System.out.println("\nExisting orders:");
            for (int i = 0; i < OrderList.length; i++) {
                if (OrderList[i] != null) {
                    System.out.println("Slot " + (i + 1));
                } else {
                    available++;
                }
            }

            if (available >= OrderList.length) {
                System.out.println("There are no filled slots");
                break;
            }

            choice = Integer.parseInt(IO.readln("""
                    Select a slot to view:     
                    """));

            System.out.println(OrderList[choice-1].toString());

            choice++;
            break;

        case 5:

            System.out.println("\nAll orders:");
            for (int i = 0; i < OrderList.length; i++) {
                if (OrderList[i] != null) {
                    System.out.println("Slot " + (i + 1) + ": Order ID - " + OrderList[i].orderId);
                    System.out.println("Item: " + OrderList[i].item);
                } else {
                    available++;
                }
            }
            if (available >= OrderList.length) {
                System.out.println("There are no filled slots");
                break;
            }
            break;
        case 0:
            if (IO.readln("Exit program? (y/n): ").equalsIgnoreCase("y")) {
                break;
            } else {
                choice++;
                break;
            }
        //test purposes only
        case 727:
            System.out.println("WYSI, generating 2 orders in random slots");

            int selectFood = 0;
            choice = 0;

            for (int i = 0; i <= 4; i++) {
                selectFood += (int) Math.round(Math.random());
            }

            Customer customer = new Customer(420, "Pogetora", "5033696061");
            for (int i = 0; i <= 3; i++) {
                choice += (int) Math.round(Math.random());
            }
            System.out.println(selectFood+ ", " + choice);
            if (OrderList[choice] == null) {
                OrderList[choice] = new Details(customer.getName(),
                        42069,
                        Menu[selectFood].getItemName(),
                        Menu[selectFood].getPrice(),
                        "27/7/27",
                        "the osu house",
                        20,
                        customer.getCustomerId(),
                        customer.getPhone());
            } else {
                System.out.println("Random Creation Failed: Slot not null");
            }

            selectFood = 0;
            choice = 0;

            for (int i = 0; i <= 4; i++) {
                selectFood += (int) Math.round(Math.random());
            }

            Customer customer2 = new Customer(727, "Poggiezi", "5184103265");
            for (int i = 0; i <= 3; i++) {
                choice += (int) Math.round(Math.random());
            }
            System.out.println(selectFood+ ", " + choice);
            if (OrderList[choice] == null) {
                OrderList[choice] = new Details(customer2.getName(),
                        6967,
                        Menu[selectFood].getItemName(),
                        Menu[selectFood].getPrice(),
                        "29/8/29",
                        "Necrofantasia",
                        15,
                        customer2.getCustomerId(),
                        customer2.getPhone());
            } else {
                System.out.println("Random Creation Failed: Slot not null");
            }

            choice = 1;
            break;



        default:
            System.out.println("Invalid Option");


    }

    } while (choice != 0);
}

public void filterOrders(int orderId, Order[] orderList) {

    boolean found = false;
    System.out.println();
    for (int i = 0; i < orderList.length; i++) {
        if (orderList[i] == null){
            //ignore orderlist because it's null, program will crash if it tries to read a null slot
        } else if (orderList[i].orderId == orderId ){
            System.out.println("Slot " + (i + 1) + " matches OrderID: " + orderId);
            found = true;
        }
    }
    if (!found) {
        System.out.println("\nThere were no matching orders");
    }




} public void filterOrders(String itemName, Order[] orderList) {

    boolean found = false;
    System.out.println();
    for (int i = 0; i < orderList.length; i++) {
        if (orderList[i] == null){
            //same as other method
        } else if (orderList[i].item.equalsIgnoreCase(itemName) ){
            System.out.println("Slot " + (i + 1) + " matches item name: " + itemName);
            found = true;
        }

    }
    if (!found) {
        System.out.println("\nThere were no matching orders");
    }
}