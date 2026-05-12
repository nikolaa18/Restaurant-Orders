package bg.tu_varna.sit.f24621690.commands.command;

import bg.tu_varna.sit.f24621690.base.Menu;
import bg.tu_varna.sit.f24621690.base.MenuItem;

// Command for: menu (no parameters)
public class ShowMenuCommand implements Command {
    @Override
    public void execute() {
        Menu menu = Menu.getInstance();
        System.out.println("----- MENU -----");
        for (MenuItem item : menu.getItems().values()) {
            System.out.println(
                    "ID: " + item.getId() +
                    " | Name: " + item.getName() +
                    " | Category: " + item.getItemCategory() +
                    " | Price: " + item.getPrice() + " lv." +
                    " | Stock: " + item.getQuantity());
        }
    }
}