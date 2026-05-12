package bg.tu_varna.sit.f24621690.commands.factory;

import bg.tu_varna.sit.f24621690.commands.command.CancelOrderCommand;

// Factory for: cancelorder <orderId>
public class CancelOrderFactory implements CommandFactory {
    public void execute(String[] args) throws Exception {
        try {
            String orderId = args[1];
            new CancelOrderCommand(orderId).execute();
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new Exception("Missing parameter. Usage: cancelorder <orderId>");
        }
    }
}
