package bg.tu_varna.sit.f24621690.commands.command.menu;

import bg.tu_varna.sit.f24621690.models.Menu;
import bg.tu_varna.sit.f24621690.models.MenuItem;
import bg.tu_varna.sit.f24621690.commands.command.Command;

/** Команда за визуализиране на всички налични артикули в менюто. */
public class ShowMenuCommand implements Command {

    /**
     * Генерира и връща форматиран списък с всички артикули от менюто,
     * включително тяхната категория, цена и складова наличност.
     *
     * @return Форматиран низ с данните за менюто.
     */
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