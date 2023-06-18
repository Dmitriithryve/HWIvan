public class Main {
    public static void main(String[] args) {
        // Creating Items
        Item laptop = new Item("Laptop", 0.6, 0.5, 0.5, 6.5);
        Item mouse = new Item("Mouse", 0.3, 0.3, 0.2, 0.2);
        Item desktop = new Item("Desktop", 1.0, 1.5, 0.5, 20.0);
        Item lcdScreen = new Item("LCD Screen", 1.2, 1.4, 0.8, 2.6);

        // Creating Containers
        Container smallContainer = new Container("Small Container", 2.43, 2.59, 6.06, 1000.0);
        Container largeContainer = new Container("Large Container", 2.43, 2.59, 12.01, 1800.0);

        Calculation calculation = new Calculation();

        // Adding Items to the order
        calculation.addItems(laptop, 100);
        calculation.addItems(mouse, 200);
        calculation.addItems(desktop, 150);
        calculation.addItems(lcdScreen, 200);

        // Adding Containers to the order
        calculation.addOrder(smallContainer);
        calculation.addOrder(largeContainer);

        // Calculating the best shipping method
        calculation.bestShipping();

        // Printing the order information
        calculation.printOrder();

        // Showing Info
        smallContainer.printContainerInfo();
        largeContainer.printContainerInfo();

        laptop.printItemInfo();
        mouse.printItemInfo();
        desktop.printItemInfo();
        lcdScreen.printItemInfo();

    }
}
