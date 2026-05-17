package bg.tu_varna.sit.f24621690.commands.factory;

import bg.tu_varna.sit.f24621690.commands.command.AddItemCommand;
import bg.tu_varna.sit.f24621690.enums.ItemCategory;

// factory for: additem <id> <name> <category> <price> <quantity>
public class AddItemFactory implements CommandFactory {
    @Override
    public String execute(String[] args) throws Exception {
        try {
            String id = args[1];
            String name = args[2];
            ItemCategory category = ItemCategory.valueOf(args[3].toUpperCase());
            double price = Double.parseDouble(args[4]);
            int quantity = Integer.parseInt(args[5]);

            return new AddItemCommand(id, name, category, price, quantity).execute();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}