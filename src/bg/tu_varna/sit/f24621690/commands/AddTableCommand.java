package bg.tu_varna.sit.f24621690.commands;

import bg.tu_varna.sit.f24621690.base.Restaurant;
import bg.tu_varna.sit.f24621690.base.Table;

public class AddTableCommand implements Command {
    private int number;
    private int seats;

    public AddTableCommand(int number, int seats) {
        this.number = number;
        this.seats = seats;
    }

    @Override
    public void execute() throws Exception {
        Restaurant restaurant = Restaurant.getInstance();

        if (restaurant.getTables().containsKey(number)) {
            throw new Exception("Table number " + number + " already exists.");
        }

        Table table = new Table(number, seats);
        restaurant.getTables().put(number, table);
    }
}
