package bg.tu_varna.sit.f24621690.commands.command.order;

import bg.tu_varna.sit.f24621690.models.Menu;
import bg.tu_varna.sit.f24621690.models.MenuItem;
import bg.tu_varna.sit.f24621690.models.Order;
import bg.tu_varna.sit.f24621690.models.Restaurant;
import bg.tu_varna.sit.f24621690.commands.command.Command;

/**
 * Команда за премахване на конкретен артикул от текуща отворена поръчка.
 * При успешно премахване, количеството автоматично се възстановява в склада на менюто.
 */
public class RemoveFromOrderCommand implements Command {
    /** Уникален идентификатор на поръчката, от която се премахва продуктът. */
    private String orderId;

    /** Идентификатор на артикула от менюто, който трябва да бъде премахнат. */
    private String itemId;

    /**
     * Конструктор за инициализиране на командата за премахване на продукт от сметката.
     * @param orderId ID на поръчката.
     * @param itemId ID на артикула за премахване.
     */
    public RemoveFromOrderCommand(String orderId, String itemId) {
        this.orderId = orderId;
        this.itemId = itemId;
    }

    /**
     * Изпълнява премахването на артикула от поръчката и актуализира складовата наличност в менюто.
     * @return Текстово съобщение, потвърждаващо премахването на артикула и възстановяването на бройките.
     * @throws Exception Ако поръчката не съществува или артикулът не е намерен в текущата поръчка.
     */
    @Override
    public String execute() throws Exception {
        Restaurant restaurant = Restaurant.getInstance();
        Menu menu = Menu.getInstance();

        Order order = restaurant.getOrders().get(orderId);
        MenuItem item = menu.getItems().get(itemId);

        if (order == null) {
            throw new Exception("Order not found!");
        }

        Integer quantityInOrder = order.getItems().get(item);

        if (quantityInOrder != null) {
            item.setQuantity(item.getQuantity() + quantityInOrder);
            order.removeItem(item);
            return "Item removed from order. Restored to stock.";
        }
        throw new Exception("Item not found in current order.");
    }
}