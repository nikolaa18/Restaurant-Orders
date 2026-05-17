package bg.tu_varna.sit.f24621690.commands.command.statistics;

import bg.tu_varna.sit.f24621690.base.MenuItem;
import bg.tu_varna.sit.f24621690.base.Order;
import bg.tu_varna.sit.f24621690.base.Restaurant;
import bg.tu_varna.sit.f24621690.commands.command.Command;
import bg.tu_varna.sit.f24621690.enums.OrderStatus;

import java.time.LocalDateTime;
import java.util.*;

/** Команда за извеждане на най-продаваните артикули за определен период от време. */
public class TopItemsCommand implements Command {
    /** Броят артикули (Топ N), които трябва да бъдат изведени. */
    private int n;

    /** Начална дата и час на периода за анализ. */
    private LocalDateTime from;

    /** Крайна дата и час на периода за анализ. */
    private LocalDateTime to;

    /**
     * Конструктор за инициализиране на критериите за класацията.
     * @param n Брой артикули, които да се покажат в класацията.
     * @param from Начална дата.
     * @param to Крайна дата.
     */
    public TopItemsCommand(int n, LocalDateTime from, LocalDateTime to) {
        this.n = n;
        this.from = from;
        this.to = to;
    }

    /**
     * Анализира всички платени поръчки в зададения времеви период, сумира продадените
     * количества от всеки артикул и ги сортира в низходящ ред.
     * @return Форматирана класация на най-продаваните артикули или съобщение при липса на продажби.
     */
    @Override
    public String execute() {
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

        StringBuilder sb = new StringBuilder();
        sb.append("--- Top ").append(n).append(" Best Selling Items ---\n");
        int count = 0;
        for (Map.Entry<MenuItem, Integer> entry : list) {
            if (count >= n) {
                break;
            }
            sb.append(entry.getKey().getName()).append(" - Sold: ").append(entry.getValue()).append("\n");
            count++;
        }

        if (list.isEmpty()) sb.append("No sales found for this period.");
        return sb.toString().trim();
    }
}