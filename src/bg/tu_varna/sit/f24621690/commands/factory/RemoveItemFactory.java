package bg.tu_varna.sit.f24621690.commands.factory;

import bg.tu_varna.sit.f24621690.commands.command.RemoveItemCommand;

// Factory for: removeitem <id>
public class RemoveItemFactory implements CommandFactory {
    @Override
    public void execute(String[] args) throws Exception {
        try {
            String id = args[1];
            new RemoveItemCommand(id).execute();
            System.out.println("Item removed successfully.");
        } catch (NumberFormatException e) {
            throw new Exception("Invalid ID format. ID must be an integer.");
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new Exception("Usage: removeitem <id>");
        }
    }
}