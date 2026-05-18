package bg.tu_varna.sit.f24621690.commands.command.statistics;

import bg.tu_varna.sit.f24621690.models.Order;
import bg.tu_varna.sit.f24621690.models.Restaurant;
import bg.tu_varna.sit.f24621690.commands.command.Command;
import bg.tu_varna.sit.f24621690.enums.OrderStatus;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/** Команда за изчисляване на приходите от платени поръчки за даден период. */
public class ReportCommand implements Command {
    /** Начална дата и час на времевия диапазон. */
    private LocalDateTime from;

    /** Крайна дата и час на времевия диапазон. */
    private LocalDateTime to;

    /**
     * Конструктор за инициализиране на командата с времеви период.
     * @param from Начална дата и час.
     * @param to Крайна дата и час.
     */
    public ReportCommand(LocalDateTime from, LocalDateTime to) {
        this.from = from;
        this.to = to;
    }

    /**
     * Изчислява и връща общата сума от всички поръчки със статус PAID в посочения диапазон.
     * @return Текстово съобщение с общите приходи за периода.
     */
    @Override
    public String execute() {
        Restaurant restaurant = Restaurant.getInstance();
        double totalRevenue = 0;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

        for (Order order : restaurant.getOrders().values()) {
            if (order.getOrderStatus() == OrderStatus.PAID &&
                    !order.getDateAndTime().isBefore(from) &&
                    !order.getDateAndTime().isAfter(to)) {
                totalRevenue += order.getTotal();
            }
        }
        return String.format("Total revenue from %s to %s: %.2f eur.", from.format(formatter), to.format(formatter), totalRevenue);
    }
}