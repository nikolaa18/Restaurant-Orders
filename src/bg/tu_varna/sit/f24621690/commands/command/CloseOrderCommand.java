package bg.tu_varna.sit.f24621690.commands.command;

import bg.tu_varna.sit.f24621690.base.Order;
import bg.tu_varna.sit.f24621690.base.Restaurant;
import bg.tu_varna.sit.f24621690.base.Table;
import bg.tu_varna.sit.f24621690.enums.OrderStatus;
import bg.tu_varna.sit.f24621690.enums.TableAvailability;

// Command for: closeorder <orderId>
public class CloseOrderCommand implements Command {
    private String orderId;

    public CloseOrderCommand(String orderId) {
        this.orderId = orderId;
    }

    @Override
    public void execute() throws Exception {
        Restaurant restaurant = Restaurant.getInstance();
        Order order = restaurant.getOrders().get(orderId);

        if (order == null) {
            throw new Exception("Order not found!");
        }

        if (order.getOrderStatus() != OrderStatus.OPEN) {
            throw new Exception("Order is already closed or canceled.");
        }

        order.setOrderStatus(OrderStatus.PAID);

        Table table = order.getTable();
        if (table != null) {
            table.setAvailability(TableAvailability.AVAILABLE);
        }

        System.out.println("Order " + orderId + " closed and paid. Table " + table.getNumber() + " is now free.");
    }
}