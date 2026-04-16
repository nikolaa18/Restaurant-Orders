package bg.tu_varna.sit.f24621690.commands;

import bg.tu_varna.sit.f24621690.base.MenuItem;
import bg.tu_varna.sit.f24621690.base.Order;
import bg.tu_varna.sit.f24621690.base.Restaurant;
import java.util.Map;

public class ShowOrderCommand implements Command {
    private int orderId;

    public ShowOrderCommand(int orderId) {
        this.orderId = orderId;
    }

    @Override
    public void execute() throws Exception {
        Restaurant restaurant = Restaurant.getInstance();
        Order order = restaurant.getOrders().get(orderId);

        if (order == null) {
            throw new Exception("Order not found!");
        }

        System.out.println("Order ID: " + orderId + " | Table: " + order.getTable().getNumber());
        System.out.println("Items:");
        for (Map.Entry<MenuItem, Integer> entry : order.getItems().entrySet()) {
            System.out.println("- " + entry.getKey().getName() + " x" + entry.getValue() + " : " + (entry.getKey().getPrice() * entry.getValue()) + " lv.");
        }
        System.out.println("Total Sum: " + order.getTotal() + " lv.");
    }
}