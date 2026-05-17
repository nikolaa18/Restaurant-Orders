package bg.tu_varna.sit.f24621690.commands.command.order;

import bg.tu_varna.sit.f24621690.base.Order;
import bg.tu_varna.sit.f24621690.base.Restaurant;
import bg.tu_varna.sit.f24621690.commands.command.Command;
import bg.tu_varna.sit.f24621690.enums.OrderStatus;
import bg.tu_varna.sit.f24621690.enums.TableAvailability;

/**
 * Команда за пълно анулиране на съществуваща поръчка.
 * Променя статуса на поръчката на отказана и освобождава прилежащата маса.
 */
public class CancelOrderCommand implements Command {

    /** Уникален идентификатор на поръчката, която се анулира. */
    private String orderId;

    /**
     * Конструктор за създаване на команда за анулиране на поръчка по нейното ID.
     * @param orderId Уникален идентификатор на поръчката.
     */
    public CancelOrderCommand(String orderId) {
        this.orderId = orderId;
    }

    /**
     * Прекратява активността на поръчката, маркира я като CANCELED и прави масата отново свободна.
     * @return Текстово съобщение, потвърждаващо анулирането и освобождаването на масата.
     * @throws Exception Ако поръчка с посоченото ID не е открита в системата.
     */
    @Override
    public String execute() throws Exception {
        Restaurant restaurant = Restaurant.getInstance();
        Order order = restaurant.getOrders().get(orderId);

        if (order == null) {
            throw new Exception("Order not found!");
        }

        order.setOrderStatus(OrderStatus.CANCELED);
        order.getTable().setAvailability(TableAvailability.AVAILABLE);

        return "Order " + orderId + " canceled. Table is now available.";
    }
}