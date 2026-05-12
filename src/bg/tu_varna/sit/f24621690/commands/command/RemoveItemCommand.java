package bg.tu_varna.sit.f24621690.commands.command;

import bg.tu_varna.sit.f24621690.base.Menu;

// Command for: removeitem <id>
public class RemoveItemCommand  implements Command{
    private String id;

    public RemoveItemCommand(String id) {
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
