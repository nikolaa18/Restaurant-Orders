package bg.tu_varna.sit.f24621690.commands.command;

import bg.tu_varna.sit.f24621690.base.Menu;
import bg.tu_varna.sit.f24621690.base.MenuItem;

// Command for: menu (no parameters)
public class ShowMenuCommand implements Command {
    @Override
    public String execute() {
        Menu menu = Menu.getInstance();
        StringBuilder sb = new StringBuilder();
        sb.append("----- MENU -----\n");
        for (MenuItem item : menu.getItems().values()) {
            sb.append(String.format("ID: %s | Name: %s | Category: %s | Price: %.2f eur. | Stock: %d\n",
                    item.getId(), item.getName(), item.getItemCategory(), item.getPrice(), item.getQuantity()));
        }
        return sb.toString().trim();
    }
}