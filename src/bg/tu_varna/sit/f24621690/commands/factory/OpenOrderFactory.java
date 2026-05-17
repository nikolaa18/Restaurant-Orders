package bg.tu_varna.sit.f24621690.commands.factory;

import bg.tu_varna.sit.f24621690.commands.command.OpenOrderCommand;

// Factory for: openorder <tableNumber>
public class OpenOrderFactory implements CommandFactory {
    @Override
    public String execute(String[] args) throws Exception {
        try {
            int tableNumber = Integer.parseInt(args[1]);
            return new OpenOrderCommand(tableNumber).execute();
        } catch (NumberFormatException e) {
            throw new Exception("Error: Table number must be an integer.");
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new Exception("Usage: openorder <tableNumber>");
        }
    }
}
