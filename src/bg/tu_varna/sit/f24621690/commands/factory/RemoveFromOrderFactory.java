package bg.tu_varna.sit.f24621690.commands.factory;

import bg.tu_varna.sit.f24621690.commands.command.RemoveFromOrderCommand;

// Factory for: removefromorder <orderId> <itemId>
public class RemoveFromOrderFactory implements CommandFactory {
    @Override
    public String execute(String[] args) throws Exception {
        try {
            String orderId = args[1];
            String itemId = args[2];
            return new RemoveFromOrderCommand(orderId, itemId).execute();
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new Exception("Missing parameters. Usage: removefromorder <orderId> <itemId>");
        }
    }
}