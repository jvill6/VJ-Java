import java.util.Scanner;


void main() {
    /* I forgot there really isn't a way to
    have a dynamic array in Java (at least not without some complications)
    so for now, this is locked to 4 slots

    NOT ANYMORE I FIXED IT YASSSSSSSSS
     */
    Order[] OrderList = new Order[0];

    //Instantly initialize a preset menu (Can be edited from the program)
    //String itemName, double price, String category
    Menu[] Menu = new Menu[5];
    Menu[0] = new Menu("Salad", 15, "Side");
    Menu[1] = new Menu("Cupcakes", 20, "Dessert");
    Menu[2] = new Menu("Fried Chicken", 15, "Main");
    Menu[3] = new Menu("Lumpia", 7, "Main");
    Menu[4] = new Menu("Brownies", 12, "Dessert");

    int choice;

    NeoFetch.NeoFetch();

    do {
        //This is prone to breaking from a blank input, will be fixed in a future change (nvm lmao)
        choice = readChoice(Colors.WHITE + """
                \nCALCUCATERING CATERING SYSTEM:
                1. Add New Order
                2. Remove Existing Order
                3. Edit Menu
                4. View Menu
                5. View an Order's Details
                6. Search for an Order
                0. Exit
                
                Chose an Option: 
                """);

        int available = 0;
        switch (choice) {
            case 1:
                System.out.println("\nCreating new order: ");
                System.out.println("\nList of Available Items: ");
                for (int i = 0; i < Menu.length; i++) {
                    System.out.println((i + 1) + ": " + Menu[i].getItemName() + ": " + Menu[i].getPrice() + "PHP");
                }
                int selectFood = readChoice("\nEnter the item being ordered: "
                ) - 1;
                Customer customer = new Customer(
                        readChoice("\nEnter an ID number for this customer: "),
                        IO.readln("Enter the customers name: "),
                        IO.readln("Enter the customers phone #: ")
                );
                OrderList = addOrder(OrderList, customer, selectFood, Menu);
                System.out.println(OrderList[OrderList.length - 1].formatDetails());
                break;

            case 2:
                OrderList = removeOrder(OrderList);
                break;
            case 3:
                switch (readChoice("""
                        Edit Menu Selected: Select Option -
                        1. Add a new Item
                        2. Remove an Item
                        #. Cancel
                        """)) {
                    case 1:
                        Menu = appendMenu(Menu);
                        break;
                    case 2:
                        Menu = popMenu(Menu);
                        break;
                    default:
                        System.out.println("Operation Cancelled");
                }
                break;
            case 4:
                System.out.println("\nCurrent Menu: ");
                for (int i = 0; i < Menu.length; i++) {
                    System.out.println((i + 1) + ": " + Menu[i].getItemName() + ": " + Menu[i].getPrice() + "PHP");
                }
                break;
            case 5:
                System.out.println("\nExisting orders:");
                for (int i = 0; i < OrderList.length; i++) {
                    if (OrderList[i] != null) {
                        System.out.println("Order # " + (i + 1));
                    } else {
                        available++;
                    }
                }

                if (available >= OrderList.length) {
                    System.out.println(Colors.YELLOW + "There are no filled slots");
                    break;
                }

                choice = readChoice("""
                        Select an order to view:     
                        """);

                //Compiler says that it may try to point to a null object, but that shouldn't be possible because it'll break this case if there are no orders(?)
                System.out.println(OrderList[choice - 1].formatDetails());

                choice++;
                break;
            case 6:
                System.out.println("""
                        Search Orders:
                        1. Search by Order ID
                        2. Search by Item Ordered
                        """);
                int searchOption = readChoice("Enter search option: ");

                if (searchOption == 1) {
                    filterOrders(readChoice("Enter the Order ID: "), OrderList);
                } else if (searchOption == 2) {
                    filterOrders(IO.readln("Enter the item name: "), OrderList);
                } else {
                    System.out.println(Colors.RED + "Invalid Option.\n" + Colors.RESET);
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


            default:
                System.out.println("Invalid Option");


        }

    } while (choice != 0);
}

//Okay i did the declarations kinda backwards but its fiiineee(???)

final Scanner inputScanner = new Scanner(System.in);

public void filterOrders(int orderId, Order[] orderList) {

    boolean found = false;
    System.out.println();
    for (int i = 0; i < orderList.length; i++) {
        if (orderList[i] == null) {
            //ignore orderlist because it's null, program will crash if it tries to read a null slot
        } else if (orderList[i].getOrderId() == orderId) {
            System.out.println("Slot " + (i + 1) + " matches OrderID: " + orderId);
            found = true;
        }
    }
    if (!found) {
        System.out.println("\nThere were no matching orders");
    }


}

public void filterOrders(String itemName, Order[] orderList) {

    boolean found = false;
    System.out.println();
    for (int i = 0; i < orderList.length; i++) {
        if (orderList[i] == null) {
            //same as other method
        } else if (orderList[i].getItem().equalsIgnoreCase(itemName)) {
            System.out.println("Order # " + (i + 1) + " matches item name: " + itemName);
            found = true;
        }

    }
    if (!found) {
        System.out.println("\nThere were no matching orders");
    }
}

int readChoice(String prompt) {
    while (true) {
        System.out.print(prompt);
        String line = inputScanner.nextLine().trim();

        try {
            return Integer.parseInt(line);
        } catch (NumberFormatException e) {
            System.out.println("The selection must be a whole number!");
        }

    }
}

Menu[] appendMenu(Menu[] currentMenu) {
    int newLength = currentMenu.length + 1;
    Menu[] newMenu = new Menu[newLength];

    System.out.println("\nCurrent Menu: ");
    for (int i = 0; i < currentMenu.length; i++) {
        System.out.println((i + 1) + ": " + currentMenu[i].getItemName() + ": " + currentMenu[i].getPrice() + "PHP");
    }

    //I did not know this was a thing WHAAAT??
    System.arraycopy(currentMenu, 0, newMenu, 0, currentMenu.length);
    System.out.println("\nNew Item Creation: ");
    newMenu[newLength - 1] = new Menu(IO.readln("Enter the item name: "), readChoice("Enter the price: PHP "), IO.readln("Enter the category of this item: "));
    return newMenu;
}

Menu[] popMenu(Menu[] currentMenu) {
    System.out.println("\nCurrent Menu: ");
    for (int i = 0; i < currentMenu.length; i++) {
        System.out.println((i + 1) + ": " + currentMenu[i].getItemName() + ": " + currentMenu[i].getPrice() + "PHP");
    }

    int itemRemove = readChoice("Enter which item number to remove: ") - 1;
    Menu[] newMenu = new Menu[currentMenu.length - 1];

    int j = 0;
    for (int i = 0; i < currentMenu.length; i++) {
        if (i == itemRemove) {
            System.out.println("Item Removed!");
        } else {
            newMenu[j] = currentMenu[i];
            System.out.println(newMenu[j].getItemName() + ", " + currentMenu[i].getItemName());
            j++;
        }

    }

    for (int i = 0; i < currentMenu.length - 1; i++) {
        System.out.println((i + 1) + ": " + newMenu[i].getItemName() + ": " + newMenu[i].getPrice() + "PHP");
    }


    return newMenu;
}

Order[] addOrder(Order[] currentOrders, Customer customer, int selectFood, Menu[] Menu) {
    int orderCount = 0;

    Order[] newOrders = new Order[currentOrders.length + 1];
    System.out.println(currentOrders.length);

    System.out.println("\nExisting orders:");
    for (int i = 0; i < currentOrders.length; i++) {
        if (currentOrders[i] != null) {
            System.out.println("Order #" + (i + 1));
            orderCount++;
        }
    }
    if (orderCount == 0) {
        System.out.println("No orders exist right now.");
    }

    System.arraycopy(currentOrders, 0, newOrders, 0, currentOrders.length);
    System.out.println("\nNew Item Creation: ");
    newOrders[currentOrders.length] = new Details(customer.getName(),
            readChoice("Enter an ID for this order: "),
            Menu[selectFood].getItemName(),
            Menu[selectFood].getPrice(),
            IO.readln("Enter the Event Date (DD/MM/YYYY): "),
            IO.readln("Enter the Venue Address: "),
            readChoice("Enter the # of guests: "),
            customer.getCustomerId(),
            customer.getPhone()
    );
    return newOrders;
}


Order[] removeOrder(Order[] currentOrders) {

    int orderCount = 0;

    for (int i = 0; i < currentOrders.length; i++) {
        if (currentOrders[i] != null) {
            System.out.println("Order #" + (i + 1));
            orderCount++;
        }
    }
    if (orderCount == 0) {
        System.out.println("No orders exist right now.");
        return currentOrders;
    }

    int itemRemove = readChoice("Enter which order # to remove: ") - 1;
    Order[] newOrders = new Order[currentOrders.length - 1];

    int j = 0;
    for (int i = 0; i < currentOrders.length; i++) {
        if (i == itemRemove) {
            System.out.println("Item Removed!");
        } else {
            newOrders[j] = currentOrders[i];
            j++;
        }
    }

    if (j == 0) {
        System.out.println("That order doesn't exist!");
    }
    return newOrders;
}






