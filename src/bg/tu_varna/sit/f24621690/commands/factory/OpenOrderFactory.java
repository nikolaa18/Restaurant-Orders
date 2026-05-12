package bg.tu_varna.sit.f24621690.commands.factory;

import bg.tu_varna.sit.f24621690.commands.command.OpenOrderCommand;

// Factory for: openorder <tableNumber>
public class OpenOrderFactory implements CommandFactory {
    public void execute(String[] args) throws Exception {
        new OpenOrderCommand(Integer.parseInt(args[1])).execute();
    }
}
