public class Container {
    private String name;
    private double length;
    private double width;
    private double height;
    private double cost;

    public Container(String name, double length, double width, double height, double cost) {
        this.name = name;
        this.length = length;
        this.width = width;
        this.height = height;
        this.cost = cost;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public double calculateVolume() {
        return this.length * this.width * this.height;
    }

    public void printContainerInfo() {
        System.out.println("Name: " + this.name);
        System.out.println("Length: " + this.length);
        System.out.println("Width: " + this.width);
        System.out.println("height: " + this.height);
        System.out.println("Cost: " + this.cost + "");
        System.out.println();
    }

    public double getCost() {
        return this.cost;
    }
}