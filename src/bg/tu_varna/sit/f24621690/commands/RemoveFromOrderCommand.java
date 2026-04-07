package bg.tu_varna.sit.f24621690.commands;

import bg.tu_varna.sit.f24621690.base.Menu;
import bg.tu_varna.sit.f24621690.base.MenuItem;
import bg.tu_varna.sit.f24621690.base.Order;
import bg.tu_varna.sit.f24621690.base.Restaurant;

public class RemoveFromOrderCommand implements Command {
    private int orderId;
    private int itemId;

    public RemoveFromOrderCommand(int orderId, int itemId) {
        this.orderId = orderId;
        this.itemId = itemId;
    }

    @Override
    public void execute() throws Exception {
        Restaurant restaurant = Restaurant.getInstance();
        Menu menu = Menu.getInstance();

        Order order = restaurant.getOrders().get(orderId);
        MenuItem item = menu.getItems().get(itemId);

        if (order == null) {
            throw new Exception("Order not found!");
        }
        order.removeItem(item);
    }
}