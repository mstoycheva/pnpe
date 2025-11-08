package task_3;

public class Product {
    private String name;
    private int quantity;
    private int hazardLevel;

    public Product(String name, int quantity, int hazardLevel) {
        this.name = name;
        this.quantity = quantity;
        this.hazardLevel = hazardLevel;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getHazardLevel() {
        return hazardLevel;
    }

    @Override
    public String toString() {
        return String.format("%-15s | Qty: %-5d | Hazard: %-2d", name, quantity, hazardLevel);
    }
}
