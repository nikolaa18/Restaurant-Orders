package bg.tu_varna.sit.f24621690.base;

import bg.tu_varna.sit.f24621690.enums.ItemCategory;

public class MenuItem {
    private final int id;
    private final String name;
    private final ItemCategory itemCategory;
    private double price;
    private int quantity;

    public MenuItem(int id, String name, ItemCategory itemCategory, double price, int quantity) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Item name cannot be empty.");
        }
        if (price < 0) {
            throw new IllegalArgumentException("Price cannot be negative.");
        }
        if (quantity < 0) {
            throw new IllegalArgumentException("Quantity cannot be negative.");
        }
        this.id = id;
        this.name = name;
        this.itemCategory = itemCategory;
        this.price = price;
        this.quantity = quantity;
    }

    public void reduceQuantity(int amount) {
        this.quantity -= amount;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public ItemCategory getItemCategory() {
        return itemCategory;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
