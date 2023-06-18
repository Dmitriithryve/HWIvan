public abstract class NewContainer {
    private double height;
    private double width;
    private double length;

    public NewContainer(double height, double width, double length) {
        this.height = height;
        this.width = width;
        this.length = length;
    }

    public abstract double getShippingCost(double totalWeight);

    public abstract double getWeightCapacity();
    public abstract double getVolumeCapacity();

    public double getHeight() {
        return height;
    }

    public double getWidth() {
        return width;
    }

    public double getLength() {
        return length;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName();
    }
}