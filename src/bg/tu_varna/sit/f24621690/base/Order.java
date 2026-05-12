package bg.tu_varna.sit.f24621690.base;

import bg.tu_varna.sit.f24621690.enums.OrderStatus;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class Order {
    private final String id;
    private Table table;
    private Map<MenuItem, Integer> items;
    private OrderStatus orderStatus;
    private LocalDateTime dateAndTime;
    private double total;

    public Order(Table table) throws Exception {
        if (table == null) {
            throw new Exception("Order cannot be created without a valid table.");
        }
        this.id = UUID.randomUUID().toString().substring(0, 3).toUpperCase();

        this.table = table;
        this.items = new HashMap<>();
        this.orderStatus = OrderStatus.OPEN;
        this.dateAndTime = LocalDateTime.now();
        this.total = 0;
    }

    public String getId() {
        return id;
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

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public LocalDateTime getDateAndTime() {
        return dateAndTime;
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
