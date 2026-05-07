package bg.tu_varna.sit.f24621690.commands.factory;

import bg.tu_varna.sit.f24621690.commands.*;
import bg.tu_varna.sit.f24621690.enums.ItemCategory;

public class AddItemFactory implements CommandFactory {
    public void execute(String[] args) throws Exception {
        int id = Integer.parseInt(args[1]);
        String name = args[2];
        ItemCategory category = ItemCategory.valueOf(args[3].toUpperCase());
        double price = Double.parseDouble(args[4]);
        int quantity = Integer.parseInt(args[5]);
        new AddItemCommand(id, name, category, price, quantity).execute();
        System.out.println("Item added to menu.");
    }
}