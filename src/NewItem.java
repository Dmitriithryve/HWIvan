public class NewItem {
    private String name;
        private double weight;
        private double width;
        private double length;
        private double height;

        public NewItem(String name, double weight, double width, double length, double height) {
            this.name = name;
            this.weight = weight;
            this.width = width;
            this.length = length;
            this.height = height;
        }

    public String getName() {
        return name;
    }

    public double getWeight() {
        return weight;
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

    public double calculateVolume() {
            return this.width * this.length * this.height;
        }

        public void printItemInfo() {
            System.out.println("Name: " + this.name + ", Weight: " + this.weight + ", Volume: " + this.calculateVolume());
        }
}


