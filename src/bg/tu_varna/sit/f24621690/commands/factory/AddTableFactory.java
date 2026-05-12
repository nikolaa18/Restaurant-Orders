package bg.tu_varna.sit.f24621690.commands.factory;

import bg.tu_varna.sit.f24621690.commands.command.AddTableCommand;

// factory for: addtable <number> <seats>
public class AddTableFactory implements CommandFactory {
    public void execute(String[] args) throws Exception {
        try {
            int number = Integer.parseInt(args[1]);
            int seats = Integer.parseInt(args[2]);

            new AddTableCommand(number, seats).execute();
            System.out.println("Table added successfully.");
        } catch (NumberFormatException e) {
            throw new Exception("Table number and seats must be integers.");
        }
    }
}
