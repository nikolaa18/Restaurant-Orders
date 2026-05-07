package bg.tu_varna.sit.f24621690.commands.factory;

import bg.tu_varna.sit.f24621690.commands.RemoveFromOrderCommand;
import bg.tu_varna.sit.f24621690.commands.factory.CommandFactory;

import java.util.Queue;

// Factory for: removefromorder <orderId> <itemId>
public class RemoveFromOrderFactory implements CommandFactory {
    public void execute(String[] args) throws Exception {
        String orderId = args[1];
        int itemId = Integer.parseInt(args[2]);
        new RemoveFromOrderCommand(orderId, itemId).execute();
        System.out.println("Item removed from order.");
    }
}