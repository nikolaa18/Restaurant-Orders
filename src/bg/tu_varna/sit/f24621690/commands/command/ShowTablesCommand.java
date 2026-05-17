package bg.tu_varna.sit.f24621690.commands.command;

import bg.tu_varna.sit.f24621690.base.Restaurant;
import bg.tu_varna.sit.f24621690.base.Table;

// Command for: tables (no parameters)
public class ShowTablesCommand implements Command {
    @Override
    public String execute() {
        Restaurant restaurant = Restaurant.getInstance();
        StringBuilder sb = new StringBuilder();
        sb.append("----- TABLES -----\n");
        for (Table table : restaurant.getTables().values()) {
            sb.append(String.format("Table #%d | Seats: %d | Status: %s\n",
                    table.getNumber(), table.getSeats(), table.getAvailability()));
        }
        return sb.toString().trim();
    }
}