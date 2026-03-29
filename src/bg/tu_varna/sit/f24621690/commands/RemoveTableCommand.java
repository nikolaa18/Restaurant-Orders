package bg.tu_varna.sit.f24621690.commands;

import bg.tu_varna.sit.f24621690.base.Menu;
import bg.tu_varna.sit.f24621690.base.Restaurant;
import bg.tu_varna.sit.f24621690.base.Table;

public class RemoveTableCommand implements Command {
    private int number;

    //add data control - exceptions, if the id does not exist
    public RemoveTableCommand(int number) {
        this.number = number;
    }

    @Override
    public void execute() {
        Restaurant restaurant = Restaurant.getInstance();

        restaurant.getTables().remove(this.number);
    }
}
