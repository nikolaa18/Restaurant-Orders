package bg.tu_varna.sit.f24621690.commands.command.order;

import bg.tu_varna.sit.f24621690.models.Order;
import bg.tu_varna.sit.f24621690.models.Restaurant;
import bg.tu_varna.sit.f24621690.models.Table;
import bg.tu_varna.sit.f24621690.commands.command.Command;
import bg.tu_varna.sit.f24621690.enums.OrderStatus;
import bg.tu_varna.sit.f24621690.enums.TableAvailability;

/**
 * Команда за финализиране на поръчка и извършване на плащане.
 * <p>
 * Командата маркира финансовите задължения по поръчката като уредени и освобождава
 * ресурсите (масата), за да могат да бъдат обслужвани нови клиенти.
 * </p>
 */
public class CloseOrderCommand implements Command {
    /** Идентификатор на поръчка, която трябва да бъде затворена. */
    private String orderId;

    /** Конструктор за инициализиране на командата за затваряне на поръчка.
    * @param orderId Уникален идентификатор на поръчката. */
    public CloseOrderCommand(String orderId) {
        this.orderId = orderId;
    }

    /**
     * Проверява дали поръчката е отворена, променя статуса ѝ на платена (PAID)
     * и освобождава прикачената към нея маса.
     *
     * @return Съобщение за успешно приключване, указващо, че масата вече е свободна.
     * @throws Exception Ако поръчката не съществува или вече е била приключена/анулирана.
     */
    @Override
    public String execute() throws Exception {
        Restaurant restaurant = Restaurant.getInstance();
        Order order = restaurant.getOrders().get(orderId);

        if (order == null) {
            throw new Exception("Order not found!");
        }

        if (order.getOrderStatus() != OrderStatus.OPEN) {
            throw new Exception("Order is already closed or canceled.");
        }

        order.setOrderStatus(OrderStatus.PAID);

        Table table = order.getTable();
        if (table != null) {
            table.setAvailability(TableAvailability.AVAILABLE);
        }

        return "Order " + orderId + " closed and paid. Table is now available.";
    }
}