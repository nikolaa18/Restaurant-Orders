package bg.tu_varna.sit.f24621690.commands;

import bg.tu_varna.sit.f24621690.base.Menu;
import bg.tu_varna.sit.f24621690.base.MenuItem;

public class RemoveItem {
    private int id;

    //add data control - exceptions, if the id does not exist
    public RemoveItem(int id) {
        this.id = id;
    }

    public void execute() {
        Menu menu = Menu.getInstance();

        menu.getItems().remove(this.id);
    }
}
