package bg.tu_varna.sit.f24621690.commands.command;

import bg.tu_varna.sit.f24621690.base.Menu;
import bg.tu_varna.sit.f24621690.base.MenuItem;
import bg.tu_varna.sit.f24621690.base.Order;
import bg.tu_varna.sit.f24621690.base.Restaurant;
import bg.tu_varna.sit.f24621690.enums.OrderStatus;

// Command for: addtoorder <orderId> <itemId> <quantity>
public class AddToOrderCommand implements Command {
    private String orderId;
    private String itemId;
    private int quantity;

    public AddToOrderCommand(String orderId, String itemId, int quantity) {
        this.orderId = orderId;
        this.itemId = itemId;
        this.quantity = quantity;
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
        if (item == null) {
            throw new Exception("Item not found in menu!");
        }
        if (item.getQuantity() < quantity) {
            throw new Exception("Not enough stock!");
        }

        if (order.getOrderStatus() != OrderStatus.OPEN) {
            throw new Exception("Cannot add items to a closed or canceled order.");
        }

        if (quantity <= 0) {
            throw new Exception("Quantity to add must be greater than 0.");
        }

        order.addItem(item, quantity);
        item.reduceQuantity(quantity);

        return "Added " + quantity + " x " + item.getName() + " to order #" + orderId;
    }
}