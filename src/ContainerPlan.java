public class ContainerPlan {
    private NewContainer containerType;
    private int numberOfContainers;

    private double totalWeight;


    public ContainerPlan(NewContainer containerType, int numberOfContainers, double totalWeight) {
        this.containerType = containerType;
        this.numberOfContainers = numberOfContainers;
        this.totalWeight = totalWeight;
    }


    public NewContainer getContainerType() {
        return containerType;
    }

    public int getNumberOfContainers() {
        return numberOfContainers;
    }

    public double getTotalWeight() {
        return totalWeight;
    }

    public double getTotalCost() {
        return containerType.getShippingCost(totalWeight) * numberOfContainers;
    }
}
