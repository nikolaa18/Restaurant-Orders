package bg.tu_varna.sit.f24621690.commands.factory;

import bg.tu_varna.sit.f24621690.commands.command.ShowOrderCommand;

// Factory for: showorder <orderId>
public class ShowOrderFactory implements CommandFactory {
    public void execute(String[] args) throws Exception {
        new ShowOrderCommand(args[1]);
    }
}