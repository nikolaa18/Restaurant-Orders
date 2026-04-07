package bg.tu_varna.sit.f24621690.base;

import bg.tu_varna.sit.f24621690.enums.OrderStatus;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class Order {
    private final int number;
    private Table table;
    private Map<MenuItem, Integer> items;
    private OrderStatus orderStatus;
    private LocalDateTime dateAndTime;
    private double total;

    //add data control - exceptions
    public Order(Table table) {
        this.number = 0;
        this.table = table;
        this.items = new HashMap<>();
        this.orderStatus = OrderStatus.OPEN;
        this.dateAndTime = LocalDateTime.now();
        this.total = 0;
    }

    public Map<MenuItem, Integer> getItems() {
        return items;
    }

    public double getTotal() {
        return total;
    }

    public Table getTable() {
        return table;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public void addItem(MenuItem item, int quantity) {
        if (items.containsKey(item)) {
            int oldQuantity = items.get(item);
            items.put(item, oldQuantity + quantity);
        } else {
            items.put(item, quantity);
        }

        total += item.getPrice() * quantity;
    }

    public void removeItem(MenuItem item) {
        int quantity = items.get(item);
        total -= item.getPrice() * quantity;
        items.remove(item);
    }
}
