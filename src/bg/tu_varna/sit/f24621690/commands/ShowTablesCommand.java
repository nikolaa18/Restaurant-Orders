package bg.tu_varna.sit.f24621690.commands;

import bg.tu_varna.sit.f24621690.base.Menu;
import bg.tu_varna.sit.f24621690.base.MenuItem;
import bg.tu_varna.sit.f24621690.base.Restaurant;
import bg.tu_varna.sit.f24621690.base.Table;

public class ShowTablesCommand {

    public String execute() {
        Restaurant restaurant = Restaurant.getInstance();

        StringBuilder builder = new StringBuilder();
        builder.append("----- Tables -----\n\n");

        for(Table table : restaurant.getTables().values()) {
            builder.append("Number: ").append(table.getNumber())
                    .append("\nSeats: ").append(table.getSeats())
                    .append("\nStatus: ").append(table.getAvailability())
                    .append("\n\n");
        }
        return builder.toString();
    }
}
