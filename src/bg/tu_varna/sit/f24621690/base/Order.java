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

    public void setItems(Map<MenuItem, Integer> items) {
        this.items = items;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
