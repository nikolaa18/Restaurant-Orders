package bg.tu_varna.sit.f24621690.commands.factory;

import bg.tu_varna.sit.f24621690.commands.command.ShowOrderCommand;

// Factory for: showorder <orderId>
public class ShowOrderFactory implements CommandFactory {
    @Override
    public String execute(String[] args) throws Exception {
        try {
            String orderId = args[1];
            return new ShowOrderCommand(orderId).execute();
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new Exception("Usage: showorder <orderId>");
        }
    }
}