package bg.tu_varna.sit.f24621690.commands;

import bg.tu_varna.sit.f24621690.base.MenuItem;
import bg.tu_varna.sit.f24621690.base.Order;
import bg.tu_varna.sit.f24621690.base.Restaurant;
import bg.tu_varna.sit.f24621690.enums.OrderStatus;

import java.time.LocalDateTime;
import java.util.*;

public class TopItemsCommand implements Command {
    private int n;
    private LocalDateTime from;
    private LocalDateTime to;

    public TopItemsCommand(int n, LocalDateTime from, LocalDateTime to) {
        this.n = n;
        this.from = from;
        this.to = to;
    }

    @Override
    public void execute() {
        Restaurant restaurant = Restaurant.getInstance();
        Map<MenuItem, Integer> itemCounts = new HashMap<>();

        for (Order order : restaurant.getOrders().values()) {
            if (order.getOrderStatus() == OrderStatus.PAID &&
                    !order.getDateAndTime().isBefore(from) &&
                    !order.getDateAndTime().isAfter(to)) {

                for (Map.Entry<MenuItem, Integer> entry : order.getItems().entrySet()) {
                    MenuItem item = entry.getKey();
                    int quantity = entry.getValue();
                    itemCounts.put(item, itemCounts.getOrDefault(item, 0) + quantity);
                }
            }
        }

        List<Map.Entry<MenuItem, Integer>> list = new ArrayList<>(itemCounts.entrySet());

        list.sort(Comparator.comparing(Map.Entry<MenuItem, Integer>::getValue).reversed());

        System.out.println("--- Top " + n + " Best Selling Items ---");
        int count = 0;
        for (Map.Entry<MenuItem, Integer> entry : list) {
            if (count >= n) break;
            System.out.println(entry.getKey().getName() + " - Sold: " + entry.getValue());
            count++;
        }

        if (list.isEmpty()) {
            System.out.println("No sales found for this period.");
        }
    }
}