package bg.tu_varna.sit.f24621690.commands.command.order;

import bg.tu_varna.sit.f24621690.models.Order;
import bg.tu_varna.sit.f24621690.models.Restaurant;
import bg.tu_varna.sit.f24621690.models.Table;
import bg.tu_varna.sit.f24621690.commands.command.Command;
import bg.tu_varna.sit.f24621690.enums.TableAvailability;

/**
 * Команда за стартиране на нова клиентска поръчка, асоциирана с конкретна маса в ресторанта.
 * <p>
 * Тази команда отговаря за генерирането на нов обект от тип {@link Order}, регистрирането му
 * в системата и заключването на съответната маса, за да се предотвратят дублирани поръчки.
 * </p>
 */public class OpenOrderCommand implements Command {

    /** Номер на маса, към която трябва да бъде отворена нова поръчка */
    private int number;

    /** Конструктор за инициализиране на командата за отваряне на нова поръчка.
    * @param number Номер на масата. */
    public OpenOrderCommand(int number) {
        this.number = number;
    }

    /**
     * Проверява дали масата съществува и е свободна, след което създава
     * нова поръчка и маркира масата като заета.
     *
     * @return Текстово съобщение, съдържащо номера на масата и генерирания уникален ID на поръчката.
     * @throws Exception Ако масата не съществува или вече е заета от друга отворена поръчка.
     */
    @Override
    public String execute() throws Exception {
        Restaurant restaurant = Restaurant.getInstance();
        Table table = restaurant.getTables().get(this.number);

        if (table == null) {
            throw new Exception("Table not found!");
        }

        if (table.getAvailability() == TableAvailability.TAKEN) {
            throw new Exception("Table #" + number + " is already occupied. Close the current order first.");
        }

        Order order = new Order(table);
        table.setAvailability(TableAvailability.TAKEN);
        restaurant.getOrders().put(order.getId(), order);

        return "Order opened for table " + number + ". Order ID: " + order.getId();
    }
}