package bg.tu_varna.sit.f24621690.commands.factory;

import bg.tu_varna.sit.f24621690.commands.RemoveTableCommand;
import bg.tu_varna.sit.f24621690.commands.factory.CommandFactory;

// Factory for: removetable <number>
public class RemoveTableFactory implements CommandFactory {
    public void execute(String[] args) throws Exception {
        new RemoveTableCommand(Integer.parseInt(args[1]));
    }
}