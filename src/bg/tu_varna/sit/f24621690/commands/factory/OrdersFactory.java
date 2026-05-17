package bg.tu_varna.sit.f24621690.commands.factory;

import bg.tu_varna.sit.f24621690.commands.command.OrdersCommand;
import bg.tu_varna.sit.f24621690.enums.OrderStatus;

// Factory for: orders [status=<status>]
public class OrdersFactory implements CommandFactory {
    @Override
    public String execute(String[] args) throws Exception {
        String statusFilter = null;

        if (args.length > 1) {
            String arg = args[1];
            if (arg.toLowerCase().startsWith("status=")) {
                statusFilter = arg.substring(7).trim().toUpperCase();
                try {
                    OrderStatus.valueOf(statusFilter);
                } catch (IllegalArgumentException e) {
                    throw new Exception("Invalid status filter. Available: OPEN, PAID, CANCELED");
                }
            } else {
                throw new Exception("Invalid parameter format. Usage: orders [status=<status>]");
            }
        }

        return new OrdersCommand(statusFilter).execute();
    }
}