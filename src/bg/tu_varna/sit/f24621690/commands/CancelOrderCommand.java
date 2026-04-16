package bg.tu_varna.sit.f24621690.commands;

import bg.tu_varna.sit.f24621690.base.Order;
import bg.tu_varna.sit.f24621690.base.Restaurant;
import bg.tu_varna.sit.f24621690.enums.OrderStatus;
import bg.tu_varna.sit.f24621690.enums.TableAvailability;

public class CancelOrderCommand implements Command {
    private int orderId;

    public CancelOrderCommand(int orderId) {
        this.orderId = orderId;
    }

    @Override
    public void execute() throws Exception {
        Restaurant restaurant = Restaurant.getInstance();
        Order order = restaurant.getOrders().get(orderId);

        if (order == null) {
            throw new Exception("Order not found!");
        }

        order.setOrderStatus(OrderStatus.CANCELED);
        order.getTable().setAvailability(TableAvailability.AVAILABLE);

        System.out.println("Order " + orderId + " canceled. Table is now available.");
    }
}