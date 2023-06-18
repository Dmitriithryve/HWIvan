import java.util.*;

public class Calculation {
    private ArrayList<Item> items;
    private ArrayList<Container> containers;

    public Calculation() {
        this.items = new ArrayList<>();
        this.containers = new ArrayList<>();
    }

    public void addItems(Item item, int quantity) {
        for(int i = 0; i < quantity; i++) {
            this.items.add(item);
        }
    }

    public void addOrder(Container container) {
        this.containers.add(container);
    }

    public double totalVolume() {
        double totalVolume = 0;
        for (Item item : this.items) {
            totalVolume += item.calculateVolume();
        }
        return totalVolume;
    }

    public double totalWeight() {
        double totalWeight = 0;
        for (Item item : this.items) {
            totalWeight += item.getWeight();
        }
        return totalWeight;
    }

    public void bestShipping() {
        double totalVolume = totalVolume();
        Container container = containers.get(0);
        double containerVolume = container.calculateVolume();
        if (totalVolume > containerVolume) {
            System.out.println("Two large containers are needed.");
        } else {
            System.out.println("One large container is enough.");
        }
    }

    public double shippingPrice() {
        double totalCost = 0;
        for (Container container : this.containers) {
            totalCost += container.getCost();
        }
        return totalCost;
    }

    public void printItem() {
        for (Item item : this.items) {
            item.printItemInfo();
        }
    }

    public void printOrder() {
        for (Container container : this.containers) {
            container.printContainerInfo();
        }
        System.out.println("Total weight: " + totalWeight());
        System.out.println("Total volume: " + totalVolume());
        System.out.println("Shipping price: " + shippingPrice());
    }
}
