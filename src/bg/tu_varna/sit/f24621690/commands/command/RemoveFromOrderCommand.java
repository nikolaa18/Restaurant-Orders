package bg.tu_varna.sit.f24621690.commands.command;

import bg.tu_varna.sit.f24621690.base.Menu;
import bg.tu_varna.sit.f24621690.base.MenuItem;
import bg.tu_varna.sit.f24621690.base.Order;
import bg.tu_varna.sit.f24621690.base.Restaurant;

// Command for: removefromorder <orderId> <itemId>
public class RemoveFromOrderCommand implements Command {
    private String orderId;
    private String itemId;

    public RemoveFromOrderCommand(String orderId, String itemId) {
        this.orderId = orderId;
        this.itemId = itemId;
    }

    @Override
    public String execute() throws Exception {
        Restaurant restaurant = Restaurant.getInstance();
        Menu menu = Menu.getInstance();

        Order order = restaurant.getOrders().get(orderId);
        MenuItem item = menu.getItems().get(itemId);

        if (order == null) {
            throw new Exception("Order not found!");
        }

        Integer quantityInOrder = order.getItems().get(item);

        if (quantityInOrder != null) {
            item.setQuantity(item.getQuantity() + quantityInOrder);
            order.removeItem(item);
            return "Item removed from order. Restored to stock.";
        }
        throw new Exception("Item not found in current order.");
    }
}