package bg.tu_varna.sit.f24621690.commands.command;

import bg.tu_varna.sit.f24621690.base.Restaurant;
import bg.tu_varna.sit.f24621690.base.Table;

// Command for: tables (no parameters)
public class ShowTablesCommand implements Command {
    @Override
    public void execute() {
        Restaurant restaurant = Restaurant.getInstance();
        System.out.println("----- TABLES -----");
        for (Table table : restaurant.getTables().values()) {
            System.out.println(
                    "Table #" + table.getNumber() +
                    " | Seats: " + table.getSeats() +
                    " | Status: " + table.getAvailability());
        }
    }
}