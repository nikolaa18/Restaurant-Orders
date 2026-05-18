package bg.tu_varna.sit.f24621690.commands.command.order;

import bg.tu_varna.sit.f24621690.models.Order;
import bg.tu_varna.sit.f24621690.models.Restaurant;
import bg.tu_varna.sit.f24621690.commands.command.Command;

import java.time.format.DateTimeFormatter;

/**
 * Команда за извеждане на пълния списък или хронология на направените поръчки в ресторанта.
 * Поддържа филтриране по определен статус на поръчката.
 */
public class OrdersCommand implements Command {

    /** Текстов филтър за състояние на поръчката (напр. "OPEN", "PAID"), като може да бъде null за всички поръчки. */
    private final String statusFilter;

    /**
     * Конструктор за създаване на командата с опционален критерий за филтриране на резултатите.
     * @param statusFilter Опционален филтър по статус (може да е null).
     */
    public OrdersCommand(String statusFilter) {
        this.statusFilter = statusFilter;
    }

    /**
     * Генерира хронологичен преглед на поръчките, отговарящи на зададения филтър.
     * @return Форматиран списък, съдържащ ID, номер на маса, статус, тотал и дата на всяка поръчка.
     * @throws Exception При проблем с четенето или обработката на колекцията от поръчки.
     */
    @Override
    public String execute() throws Exception {
        Restaurant restaurant = Restaurant.getInstance();
        StringBuilder sb = new StringBuilder();
        sb.append("----- ORDERS -----\n");
        boolean found = false;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

        for (Order order : restaurant.getOrders().values()) {
            if (statusFilter == null || order.getOrderStatus().name().equalsIgnoreCase(statusFilter)) {
                sb.append(String.format("ID: %s | Table #%d | Status: %s | Total: %.2f eur. | Date: %s\n",
                        order.getId(), order.getTable().getNumber(), order.getOrderStatus(),
                        order.getTotal(), order.getDateAndTime().format(formatter)));
                found = true;
            }
        }

        if (!found) {
            if (statusFilter != null) {
                sb.append("No orders found with status: " + statusFilter);
            } else {
                sb.append("No orders found in the system.");
            }
        }
        return sb.toString().trim();
    }
}