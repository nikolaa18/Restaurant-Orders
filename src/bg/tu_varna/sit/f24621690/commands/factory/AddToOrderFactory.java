package bg.tu_varna.sit.f24621690.commands.factory;
import bg.tu_varna.sit.f24621690.commands.command.AddToOrderCommand;

// Factory for: addtoorder <orderId> <itemId> <quantity>
public class AddToOrderFactory implements CommandFactory {
    public void execute(String[] args) throws Exception {
        try {
            String orderId = args[1];
            int itemId = Integer.parseInt(args[2]);
            int quantity = Integer.parseInt(args[3]);
            new AddToOrderCommand(orderId, itemId, quantity).execute();
        } catch (NumberFormatException e) {
            throw new Exception("Invalid format: Item ID and Quantity must be integers.");
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new Exception("Missing parameters. Usage: addtoorder <orderId> <itemId> <quantity>");
        }
    }
}

