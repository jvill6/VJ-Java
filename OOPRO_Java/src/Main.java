void main() {


    /* I forgot there really isn't a way to
    have a dynamic array in Java (at least not without some complications)
    so for now, this is locked to 4 slots
     */
    Order[] OrderList = new Order[4];



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

    } while (choice != 0);
}
