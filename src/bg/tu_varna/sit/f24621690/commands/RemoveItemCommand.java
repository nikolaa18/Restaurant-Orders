package bg.tu_varna.sit.f24621690.commands;

import bg.tu_varna.sit.f24621690.base.Menu;

public class RemoveItemCommand  implements Command{
    private int id;

    //add data control - exceptions, if the id does not exist
    public RemoveItemCommand(int id) {
        this.id = id;
    }

    @Override
    public void execute() {
        Menu menu = Menu.getInstance();

        menu.getItems().remove(this.id);
    }
}
