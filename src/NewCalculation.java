import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class NewCalculation {
    private final List<NewContainer> containers;
    private final Order order;

    public NewCalculation(Order order) {
        this.order = order;
        this.containers = new ArrayList<>();
        containers.add(new NewSmallContainer());
        containers.add(new NewBigContainer());
    }
    
    public double totalVolume() {
        double totalVolume = 0;
        for(Map.Entry<NewItem, Integer> entry : order.getItems().entrySet()) {
            totalVolume += entry.getKey().calculateVolume() * entry.getValue();
        }
        return totalVolume;
    }

    public double totalWeight() {
        double totalWeight = 0;
        for(Map.Entry<NewItem, Integer> entry : order.getItems().entrySet()) {
            totalWeight += entry.getKey().getWeight() * entry.getValue();
        }
        return totalWeight;
    }

    public List<ContainerPlan> bestShipping() {
        List<ContainerPlan> containerPlans = new ArrayList<>();
        double totalWeight = totalWeight();
        double totalVolume = totalVolume();

        for (NewContainer container : containers) {
            int numberOfContainers = (int) Math.ceil(Math.max(totalWeight / container.getWeightCapacity(),
                    totalVolume / container.getVolumeCapacity()));
            containerPlans.add(new ContainerPlan(container, numberOfContainers, totalWeight));
        }

        double minCost = Double.MAX_VALUE;
        List<ContainerPlan> bestPlans = new ArrayList<>();

        for (ContainerPlan plan : containerPlans) {
            double cost = plan.getTotalCost();
            if (cost < minCost) {
                minCost = cost;
                bestPlans.clear();
                bestPlans.add(plan);
            } else if (cost == minCost) {
                bestPlans.add(plan);
            }
        }

        return bestPlans;
    }
    
    public double shippingPrice() {
        List<ContainerPlan> containerPlans = bestShipping();
        double totalCost = 0.0;
        for (ContainerPlan plan : containerPlans) {
            totalCost += plan.getTotalCost();
        }
        return totalCost;
    }

    public void printItemInfo() {
        for(Map.Entry<NewItem, Integer> entry : order.getItems().entrySet()) {
            System.out.println("Item: " + entry.getKey().getName() + ", Quantity: " + entry.getValue());
        }
    }
    
    public void printOrderInfo() {
        printItemInfo();
        System.out.println("Total Volume: " + totalVolume());
        System.out.println("Total Weight: " + totalWeight());
        System.out.println("Shipping Price: " + shippingPrice());
    }
}
