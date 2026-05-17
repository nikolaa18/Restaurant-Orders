package bg.tu_varna.sit.f24621690.commands.command;

import bg.tu_varna.sit.f24621690.base.Order;
import bg.tu_varna.sit.f24621690.base.Restaurant;
import bg.tu_varna.sit.f24621690.enums.OrderStatus;
import java.time.LocalDateTime;

// Command for: report <from> <to>
public class ReportCommand implements Command {
    private LocalDateTime from;
    private LocalDateTime to;

    public ReportCommand(LocalDateTime from, LocalDateTime to) {
        this.from = from;
        this.to = to;
    }

    @Override
    public String execute() {
        Restaurant restaurant = Restaurant.getInstance();
        double totalRevenue = 0;

        for (Order order : restaurant.getOrders().values()) {
            if (order.getOrderStatus() == OrderStatus.PAID &&
                    !order.getDateAndTime().isBefore(from) &&
                    !order.getDateAndTime().isAfter(to)) {
                totalRevenue += order.getTotal();
            }
        }
        return String.format("Total revenue from %s to %s: %.2f eur.", from, to, totalRevenue);
    }
}