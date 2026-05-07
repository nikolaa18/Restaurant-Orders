package bg.tu_varna.sit.f24621690.commands.factory;

import bg.tu_varna.sit.f24621690.commands.RemoveItemCommand;

// Factory for: removeitem <id>
public class RemoveItemFactory implements CommandFactory {
    @Override
    public void execute(String[] args) throws Exception {
        int id = Integer.parseInt(args[1]);
        new RemoveItemCommand(id).execute();
        System.out.println("Item removed successfully.");
    }
}