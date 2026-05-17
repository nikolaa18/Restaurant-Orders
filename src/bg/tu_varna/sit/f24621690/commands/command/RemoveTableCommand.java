package bg.tu_varna.sit.f24621690.commands.command;

import bg.tu_varna.sit.f24621690.base.Restaurant;

// Command for: removetable <number>
public class RemoveTableCommand implements Command {
    private int number;

    public RemoveTableCommand(int number) {
        this.number = number;
    }

    @Override
    public String execute() throws Exception {
        Restaurant restaurant = Restaurant.getInstance();
        if (!restaurant.getTables().containsKey(this.number)) {
            throw new Exception("Cannot remove: Table " + number + " not found.");
        }
        restaurant.getTables().remove(this.number);
        return "Table " + number + " removed successfully.";
    }
}
