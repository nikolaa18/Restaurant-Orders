package bg.tu_varna.sit.f24621690.commands.factory;

import bg.tu_varna.sit.f24621690.commands.AddTableCommand;

public class AddTableFactory implements CommandFactory {
    public void execute(String[] args) throws Exception {
        new AddTableCommand(Integer.parseInt(args[1]), Integer.parseInt(args[2])).execute();
        System.out.println("Table added successfully.");
    }
}
