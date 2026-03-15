package bg.tu_varna.sit.f24621690.commands;

import bg.tu_varna.sit.f24621690.base.Restaurant;
import bg.tu_varna.sit.f24621690.base.Table;

public class AddTable {
    private int number;
    private int seats;

    public AddTable(int number, int seats) {
        this.number = number;
        this.seats = seats;
    }

    public void execute() {
        Table table = new Table(number, seats);

        Restaurant restaurant = Restaurant.getInstance();
        restaurant.getTables().add(table);
    }
}
