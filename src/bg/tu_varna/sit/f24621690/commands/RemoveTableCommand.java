package bg.tu_varna.sit.f24621690.commands;

import bg.tu_varna.sit.f24621690.base.Menu;
import bg.tu_varna.sit.f24621690.base.Restaurant;
import bg.tu_varna.sit.f24621690.base.Table;

public class RemoveTableCommand implements Command {
    private int number;

    public RemoveTableCommand(int number) {
        this.number = number;
    }

    @Override
    public void execute() throws Exception {
        Restaurant restaurant = Restaurant.getInstance();
        if (!restaurant.getTables().containsKey(this.number)) {
            throw new Exception("Cannot remove: Table " + number + " not found.");
        }
        restaurant.getTables().remove(this.number);
    }
}
