package bg.tu_varna.sit.f24621690.commands.command.table;

import bg.tu_varna.sit.f24621690.base.Restaurant;
import bg.tu_varna.sit.f24621690.base.Table;
import bg.tu_varna.sit.f24621690.commands.command.Command;

/** Команда за визуализиране на всички маси в ресторанта и техния статус. */
public class ShowTablesCommand implements Command {

    /**
     * Генерира и връща форматиран списък с всички маси, техния капацитет
     * (брой места) и текущата им заетост (AVAILABLE или TAKEN).
     *
     * @return Форматиран низ с данните за масите.
     */
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