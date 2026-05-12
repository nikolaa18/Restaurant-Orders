package bg.tu_varna.sit.f24621690.commands.factory;

import bg.tu_varna.sit.f24621690.commands.command.CloseOrderCommand;

// Factory for: closeorder <orderId>
public class CloseOrderFactory implements CommandFactory {
    public void execute(String[] args) throws Exception {
        try {
            String orderId = args[1];
            new CloseOrderCommand(orderId).execute();
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new Exception("Missing parameter. Usage: closeorder <orderId>");
        }
    }
}