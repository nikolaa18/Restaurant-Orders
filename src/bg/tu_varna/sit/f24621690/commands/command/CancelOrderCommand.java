package bg.tu_varna.sit.f24621690.commands.command;

import bg.tu_varna.sit.f24621690.base.Order;
import bg.tu_varna.sit.f24621690.base.Restaurant;
import bg.tu_varna.sit.f24621690.enums.OrderStatus;
import bg.tu_varna.sit.f24621690.enums.TableAvailability;

// Command for: cancelorder <orderId>
public class CancelOrderCommand implements Command {
    private String orderId;

    public CancelOrderCommand(String orderId) {
        this.orderId = orderId;
    }

    @Override
    public String execute() throws Exception {
        Restaurant restaurant = Restaurant.getInstance();
        Order order = restaurant.getOrders().get(orderId);

        if (order == null) {
            throw new Exception("Order not found!");
        }

        order.setOrderStatus(OrderStatus.CANCELED);
        order.getTable().setAvailability(TableAvailability.AVAILABLE);

        return "Order " + orderId + " canceled. Table is now available.";
    }
}