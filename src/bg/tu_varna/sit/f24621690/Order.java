package bg.tu_varna.sit.f24621690;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class Order {
    private final int number;
    private Table table;
    private Map<MenuItem, Integer> items;
    private LocalDateTime dateAndTime;
    private double total;

    public Order(int number, Table table, LocalDateTime dateAndTime, double total) {
        this.number = number;
        this.table = table;
        this.items = new HashMap<>();
        this.dateAndTime = dateAndTime;
        this.total = total;
    }
}
