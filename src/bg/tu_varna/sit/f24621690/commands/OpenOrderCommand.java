package bg.tu_varna.sit.f24621690.commands;

import bg.tu_varna.sit.f24621690.base.Order;
import bg.tu_varna.sit.f24621690.base.Restaurant;
import bg.tu_varna.sit.f24621690.base.Table;
import bg.tu_varna.sit.f24621690.enums.TableAvailability;

public class OpenOrderCommand implements Command {

    private int number;

    public OpenOrderCommand(int number) {
        this.number = number;
    }

    @Override
    public void execute() throws Exception {
        Restaurant restaurant = Restaurant.getInstance();
        Table table = restaurant.getTables().get(this.number);

        if (table == null) {
            throw new Exception("Table not found!");
        }

        if (table.getAvailability() == TableAvailability.TAKEN) {
            throw new Exception("Table " + number + " is already occupied. Close the current order first.");
        }

        Order order = new Order(table);
        table.setAvailability(TableAvailability.TAKEN);

        System.out.println("Order opened for table " + number);
    }
}