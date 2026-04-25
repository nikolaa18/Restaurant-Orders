package bg.tu_varna.sit.f24621690.commands;

import bg.tu_varna.sit.f24621690.base.Menu;

public class RemoveItemCommand  implements Command{
    private int id;

    public RemoveItemCommand(int id) {
        this.id = id;
    }

    @Override
    public void execute() throws Exception {
        Menu menu = Menu.getInstance();
        if (!menu.getItems().containsKey(this.id)) {
            throw new Exception("Cannot remove: Item with ID " + id + " not found.");
        }
        menu.getItems().remove(this.id);
    }
}
