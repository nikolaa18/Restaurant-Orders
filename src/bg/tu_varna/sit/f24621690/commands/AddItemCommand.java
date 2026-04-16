package bg.tu_varna.sit.f24621690.commands;

import bg.tu_varna.sit.f24621690.base.Menu;
import bg.tu_varna.sit.f24621690.base.MenuItem;
import bg.tu_varna.sit.f24621690.enums.ItemCategory;

public class AddItemCommand implements Command{
    private final int id;     //can I add parameters to the commands?
    private final String name;
    private final ItemCategory itemCategory;
    private double price;
    private int quantity;

    public AddItemCommand(int id, String name, ItemCategory itemCategory, double price, int quantity) {
        this.id = id;
        this.name = name;
        this.itemCategory = itemCategory;
        this.price = price;
        this.quantity = quantity;
    }

    @Override
    public void execute() throws Exception {
        Menu menu = Menu.getInstance();

        if (menu.getItems().containsKey(id)) {
            throw new Exception("Item with ID " + id + " already exists in the menu.");
        }

        for (MenuItem existingItem : menu.getItems().values()) {
            if (existingItem.getName().equalsIgnoreCase(name)) {
                throw new Exception("Item with name '" + name + "' already exists.");
            }
        }

        MenuItem item = new MenuItem(id, name, itemCategory, price, quantity);
        menu.getItems().put(id, item);
    }
}
