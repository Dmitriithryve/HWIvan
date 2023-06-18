import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Calculation calculation = new Calculation();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the count of laptops: ");
        int laptops = scanner.nextInt();
        for (int i = 0; i < laptops; i++) {
            calculation.addItem(new Laptop());
        }

        System.out.print("Enter the count of mice: ");
        int mice = scanner.nextInt();
        for (int i = 0; i < mice; i++) {
            calculation.addItem(new Mouse());
        }

        System.out.print("Enter the count of desktops: ");
        int desktops = scanner.nextInt();
        for (int i = 0; i < desktops; i++) {
            calculation.addItem(new Desktop());
        }

        System.out.print("Enter the count of LCD screens: ");
        int lcdScreens = scanner.nextInt();
        for (int i = 0; i < lcdScreens; i++) {
            calculation.addItem(new LCDScreen());
        }

        calculation.calculateContainers();

//        NewItem laptop = new NewItem("Laptop", 6.5, 0.6, 0.5, 0.5);
//        NewItem mouse = new NewItem("Mouse", 0.2, 0.3, 0.3, 0.2);
//        NewItem desktop = new NewItem("Desktop", 20, 1.0, 1.5, 0.5);
//        NewItem lcd = new NewItem("LCD", 2.6, 1.2, 1.4, 0.8);
//
//        // Create a Scanner object for user input
//        Scanner scanner = new Scanner(System.in);
//
//        // Create order and add items
//        Order order = new Order();
//
//        System.out.print("Enter quantity of laptops: ");
//        int laptopQuantity = scanner.nextInt();
//        order.addOrder(laptop, laptopQuantity);
//
//        System.out.print("Enter quantity of mice: ");
//        int mouseQuantity = scanner.nextInt();
//        order.addOrder(mouse, mouseQuantity);
//
//        System.out.print("Enter quantity of desktops: ");
//        int desktopQuantity = scanner.nextInt();
//        order.addOrder(desktop, desktopQuantity);
//
//        System.out.print("Enter quantity of LCDs: ");
//        int lcdQuantity = scanner.nextInt();
//        order.addOrder(lcd, lcdQuantity);
//
//        // Create Calculation object
//        NewCalculation calculation = new NewCalculation(order);
//
//        // Compute total volume and weight
//        double totalVolume = calculation.totalVolume();
//        double totalWeight = calculation.totalWeight();
//        System.out.println("Total volume: " + totalVolume);
//        System.out.println("Total weight: " + totalWeight);
//
//        // Determine best shipping container plans
//        List<ContainerPlan> containerPlans = calculation.bestShipping();
//        System.out.println("Shipping Info:");
//        for (ContainerPlan plan : containerPlans) {
//            System.out.println(plan.getNumberOfContainers() + " " + plan.getContainerType().getClass().getSimpleName());
//        }
//
//        // Calculate shipping price
//        double shippingPrice = calculation.shippingPrice();
//        System.out.println("Shipping Price: " + shippingPrice);
//
//        // Print order info
//        System.out.println("\nOrder Info:");
//        calculation.printOrderInfo();
//
//        scanner.close();
//    }
    }
}