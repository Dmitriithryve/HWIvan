public class NewSmallContainer extends NewContainer{
    
    public NewSmallContainer() {
        super(2.59, 2.43, 6.06);
    }

    @Override
    public double getShippingCost(double weight) {
        if (weight <= 500) {
            return 1000;
        } else {
            return 1200;
        }
    }

    @Override
    public double getWeightCapacity() {
        return 500; // This is an example.
    }

    @Override
    public double getVolumeCapacity() {
        return 2.59 * 2.43 * 6.06; // This is an example.
    }
}
