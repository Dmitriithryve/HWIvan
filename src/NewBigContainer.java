public class NewBigContainer extends NewContainer {

    public NewBigContainer() {
        super(2.59, 2.43, 12.01);
    }

    @Override
    public double getShippingCost(double weight) {
        return 1800;
    }

    @Override
    public double getWeightCapacity() {
        return Double.MAX_VALUE; // Replace with your correct value.
    }

    @Override
    public double getVolumeCapacity() {
        return 2.59 * 2.43 * 12.01; // Replace with your correct value.
    }
}