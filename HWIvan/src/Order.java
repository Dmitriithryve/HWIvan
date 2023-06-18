import java.util.HashMap;

public class Order {
    private HashMap<NewItem, Integer> items; // item and quantity

    public Order() {
        items = new HashMap<>();
    }

    // other getters, setters and methods
    public void addOrder(NewItem item, int quantity) {
        items.put(item, quantity);
    }

    public HashMap<NewItem, Integer> getItems() {
        return this.items;
    }
}