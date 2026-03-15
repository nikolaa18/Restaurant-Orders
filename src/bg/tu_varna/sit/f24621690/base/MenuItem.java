package bg.tu_varna.sit.f24621690.base;

import bg.tu_varna.sit.f24621690.enums.ItemCategory;

public class MenuItem {
    private final int id;
    private final String name;
    private final ItemCategory itemCategory;
    private double price;
    private int quantity;

    //add data control - exceptions
    public MenuItem(int id, String name, ItemCategory itemCategory, double price, int quantity) {
        this.id = id;
        this.name = name;
        this.itemCategory = itemCategory;
        this.price = price;
        this.quantity = quantity;
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
}
