package bg.tu_varna.sit.f24621690.commands.command.order;

import bg.tu_varna.sit.f24621690.models.Menu;
import bg.tu_varna.sit.f24621690.models.MenuItem;
import bg.tu_varna.sit.f24621690.models.Order;
import bg.tu_varna.sit.f24621690.models.Restaurant;
import bg.tu_varna.sit.f24621690.commands.command.Command;
import bg.tu_varna.sit.f24621690.enums.OrderStatus;

/**
 * Команда за добавяне на определено количество от даден артикул към вече съществуваща и отворена поръчка.
 * <p>
 * Тази команда управлява едновременно обектите {@link Order} и {@link MenuItem}.
 * При успешно добавяне, тя автоматично редуцира наличните количества на артикула в склада.
 * </p>
 */
public class AddToOrderCommand implements Command {

    /** Идентификаторът на поръчката, към която ще се добавя. */
    private String orderId;

    /** Идентификаторът на артикула, който се поръчва. */
    private String itemId;

    /** Количеството от артикула, което клиентът желае. */
    private int quantity;

    /**
     * Конструктор за инициализиране на командата за добавяне на артикул към поръчка.
     * @param orderId ID на поръчката.
     * @param itemId ID на артикула.
     * @param quantity Количество за добавяне.
     */
    public AddToOrderCommand(String orderId, String itemId, int quantity) {
        this.orderId = orderId;
        this.itemId = itemId;
        this.quantity = quantity;
    }

    /**
     * Проверява наличностите и статуса на поръчката, след което добавя артикула
     * и намалява количеството му в склада.
     *
     * @return Форматирано съобщение, потвърждаващо добавянето (напр. "Added 2 x Salad to order #123").
     * @throws Exception Ако някоя от горепосочените валидации се провали. Съобщението за грешка е
     * специфично за всяко нарушено правило.
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
        if (item == null) {
            throw new Exception("Item not found in menu!");
        }
        if (item.getQuantity() < quantity) {
            throw new Exception("Not enough stock!");
        }

        if (order.getOrderStatus() != OrderStatus.OPEN) {
            throw new Exception("Cannot add items to a closed or canceled order.");
        }

        if (quantity <= 0) {
            throw new Exception("Quantity to add must be greater than 0.");
        }

        order.addItem(item, quantity);
        item.reduceQuantity(quantity);

        return "Added " + quantity + " x " + item.getName() + " to order #" + orderId;
    }
}