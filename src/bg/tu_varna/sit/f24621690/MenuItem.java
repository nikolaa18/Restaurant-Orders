package bg.tu_varna.sit.f24621690;

import jdk.jfr.Category;

public class MenuItem {
    private final int id;
    private final String name;
    private final ItemCategory itemCategory;
    private double price;
    private int quantity;

    public MenuItem(int id, String name, ItemCategory itemCategory, double price, int quantity) {
        this.id = id;
        this.name = name;
        this.itemCategory = itemCategory;
        this.price = price;
        this.quantity = quantity;
    }
}
