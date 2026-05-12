package bg.tu_varna.sit.f24621690.commands.command;

import bg.tu_varna.sit.f24621690.base.Menu;
import bg.tu_varna.sit.f24621690.base.MenuItem;

// Command for: lowstock <threshold>
public class LowStockCommand implements Command {
    private int threshold;

    public LowStockCommand(int threshold) {
        this.threshold = threshold;
    }

    @Override
    public void execute() {
        Menu menu = Menu.getInstance();
        System.out.println("--- Low Stock Items (Below " + threshold + ") ---");

        boolean found = false;
        for (MenuItem item : menu.getItems().values()) {
            if (item.getQuantity() < threshold) {
                System.out.println("ID: " + item.getId() + " | Name: " + item.getName() + " | Stock: " + item.getQuantity());
                found = true;
            }
        }

        if (!found) {
            System.out.println("All items are well stocked.");
        }
    }
}