package bg.tu_varna.sit.f24621690.commands.factory;

import bg.tu_varna.sit.f24621690.commands.command.RemoveTableCommand;

// Factory for: removetable <number>
public class RemoveTableFactory implements CommandFactory {
    @Override
    public String execute(String[] args) throws Exception {
        try {
            int number = Integer.parseInt(args[1]);
            return new RemoveTableCommand(number).execute();
        } catch (NumberFormatException e) {
            throw new Exception("Table number must be an integer.");
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new Exception("Usage: removetable <number>");
        }
    }
}