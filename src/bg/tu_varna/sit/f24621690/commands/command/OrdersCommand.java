package bg.tu_varna.sit.f24621690.commands.command;

import bg.tu_varna.sit.f24621690.base.Order;
import bg.tu_varna.sit.f24621690.base.Restaurant;

// Command for: orders [status=<status>]
public class OrdersCommand implements Command {
    private final String statusFilter;

    public OrdersCommand(String statusFilter) {
        this.statusFilter = statusFilter;
    }

    @Override
    public String execute() throws Exception {
        Restaurant restaurant = Restaurant.getInstance();
        StringBuilder sb = new StringBuilder();
        sb.append("----- ORDERS -----\n");
        boolean found = false;

        for (Order order : restaurant.getOrders().values()) {
            if (statusFilter == null || order.getOrderStatus().name().equalsIgnoreCase(statusFilter)) {
                sb.append(String.format("ID: %s | Table #%d | Status: %s | Total: %.2f eur. | Date: %s\n",
                        order.getId(), order.getTable().getNumber(), order.getOrderStatus(),
                        order.getTotal(), order.getDateAndTime()));
                found = true;
            }
        }

        if (!found) {
            if (statusFilter != null) {
                sb.append("No orders found with status: " + statusFilter);
            } else {
                sb.append("No orders found in the system.");
            }
        }
        return sb.toString().trim();
    }
}