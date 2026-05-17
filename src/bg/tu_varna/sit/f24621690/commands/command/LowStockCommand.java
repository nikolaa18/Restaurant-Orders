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
    public String execute() {
        Menu menu = Menu.getInstance();
        StringBuilder sb = new StringBuilder();
        sb.append("--- Low Stock Items (Below ").append(threshold).append(") ---\n");

        boolean found = false;
        for (MenuItem item : menu.getItems().values()) {
            if (item.getQuantity() < threshold) {
                sb.append(String.format("ID: %s | Name: %s | Stock: %d\n",
                        item.getId(), item.getName(), item.getQuantity()));
                found = true;
            }
        }

        if (!found) {
            sb.append("All items are well stocked.");
        }
        return sb.toString().trim();
    }
}