import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

abstract class Item {
    private double width;
    private double length;
    private double height;
    private double weight;

    Item(double width, double length, double height, double weight) {
        this.width = width;
        this.length = length;
        this.height = height;
        this.weight = weight;
    }

    public double getWidth() {
        return width;
    }

    public double getLength() {
        return length;
    }

    public double getHeight() {
        return height;
    }

    public double getWeight() {
        return weight;
    }

    public abstract double calculateVolume();

    public void printInfo() {
        System.out.println("Item info: width=" + width + ", length=" + length + ", height=" + height + ", weight=" + weight);
    }
}

class Laptop extends Item {
    Laptop() {
        super(0.6, 0.5, 0.5, 6.5);
    }

    @Override
    public double calculateVolume() {
        return getWidth() * getLength() * getHeight();
    }
}

class Mouse extends Item {
    Mouse() {
        super(0.3, 0.3, 0.2, 0.2);
    }

    @Override
    public double calculateVolume() {
        return getWidth() * getLength() * getHeight();
    }
}

class Desktop extends Item {
    Desktop() {
        super(1.0, 1.5, 0.5, 20);
    }

    @Override
    public double calculateVolume() {
        return getWidth() * getLength() * getHeight();
    }
}

class LCDScreen extends Item {
    LCDScreen() {
        super(1.2, 1.4, 0.8, 2.6);
    }

    @Override
    public double calculateVolume() {
        return getWidth() * getLength() * getHeight();
    }
}

abstract class Container {
    private double width;
    private double length;
    private double height;
    private double maxWeight;
    private double price;

    Container(double width, double length, double height, double price) {
        this.width = width;
        this.length = length;
        this.height = height;
        this.price = price;
    }

    public double getWidth() {
        return width;
    }

    public double getLength() {
        return length;
    }

    public double getHeight() {
        return height;
    }

    public double getMaxWeight() {
        return maxWeight;
    }

    public void setMaxWeight(double maxWeight) {
        this.maxWeight = maxWeight;
    }

    public double getPrice() {
        return price;
    }

    public double calculateVolume() {
        return getWidth() * getLength() * getHeight();
    }

    public abstract double calculatePrice(double weight);
}

class SmallContainer extends Container {
    SmallContainer() {
        super(2.59, 2.43, 6.06, 1000);
        setMaxWeight(1000);
    }

    @Override
    public double calculatePrice(double weight) {
        if (weight <= 500) {
            return 1000;
        } else {
            return 1200;
        }
    }
}

class BigContainer extends Container {
    BigContainer() {
        super(2.59, 2.43, 12.01, 1800);
    }

    @Override
    public double calculatePrice(double weight) {
        return getPrice();
    }
}

class Calculation {
    private List<Item> items;
    private SmallContainer smallContainer;
    private BigContainer bigContainer;

    Calculation() {
        items = new ArrayList<>();
        smallContainer = new SmallContainer();
        bigContainer = new BigContainer();
    }

    void addItem(Item item) {
        items.add(item);
    }

    double calculateTotalWeight() {
        double totalWeight = 0;
        for (Item item : items) {
            totalWeight += item.getWeight();
        }
        return totalWeight;
    }

    double calculateTotalVolume() {
        double totalVolume = 0;
        for (Item item : items) {
            totalVolume += item.calculateVolume();
        }
        return totalVolume;
    }

    double bestShipping() {
        double totalWeight = calculateTotalWeight();
        double totalVolume = calculateTotalVolume();
        if (totalWeight <= smallContainer.getMaxWeight() && totalVolume <= smallContainer.calculateVolume()) {
            return smallContainer.calculatePrice(totalWeight);
        } else {
            return bigContainer.calculatePrice(totalWeight);
        }
    }

    public void calculateContainers() {
        double totalWeight = calculateTotalWeight();
        double totalVolume = calculateTotalVolume();

        int bigContainersCount = 0;
        int smallContainersCount = 0;
        double totalPrice = 0;

        while (totalWeight > 0 || totalVolume > 0) {
            // First check if remaining items can fit into a small container
            if (totalWeight <= smallContainer.getMaxWeight() && totalVolume <= smallContainer.calculateVolume()) {
                smallContainersCount++;
                totalPrice += smallContainer.calculatePrice(totalWeight);
                totalWeight -= smallContainer.getMaxWeight();
                totalVolume -= smallContainer.calculateVolume();
            }
            // If not, use a big container
            else if (totalWeight >= bigContainer.getMaxWeight() && totalVolume >= bigContainer.calculateVolume()) {
                bigContainersCount++;
                totalPrice += bigContainer.getPrice();
                totalWeight -= bigContainer.getMaxWeight();
                totalVolume -= bigContainer.calculateVolume();
            } else {
                System.out.println("The remaining items cannot fit into a container. Please revise the item quantities or container types.");
                break;
            }
        }

        System.out.println("The optimal shipping method is: " + bigContainersCount + " big containers and " + smallContainersCount + " small containers.");
        System.out.println("The best shipping cost is: " + totalPrice + " Euros.");
    }
}


