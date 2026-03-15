package bg.tu_varna.sit.f24621690.commands;

import bg.tu_varna.sit.f24621690.base.Menu;
import bg.tu_varna.sit.f24621690.base.MenuItem;

public class PrintMenu {
    public String execute() {
        Menu menu = Menu.getInstance();

        StringBuilder builder = new StringBuilder();
        builder.append("----- MENU -----\n\n");

        for(MenuItem item : menu.getItems().values()) {
            builder.append("Id: ").append(item.getId())
                    .append("\nName: ").append(item.getName())
                    .append("\nCategory: ").append(item.getItemCategory())
                    .append("\nPrice: ").append(item.getPrice())
                    .append("\nQuantity: ").append(item.getQuantity())
                    .append("\n\n");
        }
        return builder.toString();
    }
}
