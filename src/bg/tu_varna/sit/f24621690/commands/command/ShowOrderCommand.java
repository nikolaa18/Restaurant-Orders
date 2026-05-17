package bg.tu_varna.sit.f24621690.commands.command;

import bg.tu_varna.sit.f24621690.base.MenuItem;
import bg.tu_varna.sit.f24621690.base.Order;
import bg.tu_varna.sit.f24621690.base.Restaurant;
import java.util.Map;

// Command for: showorder <orderId>
public class ShowOrderCommand implements Command {
    private String orderId;

    public ShowOrderCommand(String orderId) {
        this.orderId = orderId;
    }

    @Override
    public String execute() throws Exception {
        Restaurant restaurant = Restaurant.getInstance();
        Order order = restaurant.getOrders().get(orderId);

        if (order == null) {
            throw new Exception("Order not found!");
        }

        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Order ID: %s | Table: %d\n", orderId, order.getTable().getNumber()));
        sb.append("Items:\n");
        for (Map.Entry<MenuItem, Integer> entry : order.getItems().entrySet()) {
            sb.append(String.format("- %s x%d : %.2f eur.\n",
                    entry.getKey().getName(), entry.getValue(), entry.getKey().getPrice() * entry.getValue()));
        }
        sb.append(String.format("Total Sum: %.2f eur.", order.getTotal()));
        return sb.toString();
    }
}