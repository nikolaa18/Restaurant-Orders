package bg.tu_varna.sit.f24621690.commands;

import bg.tu_varna.sit.f24621690.base.Menu;
import bg.tu_varna.sit.f24621690.base.MenuItem;
import bg.tu_varna.sit.f24621690.base.Order;
import bg.tu_varna.sit.f24621690.base.Restaurant;

public class AddToOrderCommand implements Command {
    private int orderId;
    private int itemId;
    private int quantity;

    public AddToOrderCommand(int orderId, int itemId, int quantity) {
        this.orderId = orderId;
        this.itemId = itemId;
        this.quantity = quantity;
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
        if (item == null) {
            throw new Exception("Item not found in menu!");
        }
        if (item.getQuantity() < quantity) {
            throw new Exception("Not enough stock!");
        }

        order.addItem(item, quantity);
    }
}