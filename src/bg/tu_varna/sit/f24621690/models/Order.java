package bg.tu_varna.sit.f24621690.models;

import bg.tu_varna.sit.f24621690.enums.OrderStatus;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Клас, представляващ клиентска поръчка, свързана с конкретна маса.
 */

public class Order {
    /** Уникален автоматично генериран идентификатор на поръчката. */
    private final String id;

    /** Масата, за която е направена поръчката. */
    private Table table;

    /** Списък с поръчаните артикули и тяхното количество (Артикул -> Брой). */
    private Map<MenuItem, Integer> items;

    /** Текущ статус на поръчката (отворена, платена, анулирана). */
    private OrderStatus orderStatus;

    /** Дата и час на създаване на поръчката. */
    private LocalDateTime dateAndTime;

    /** Обща дължима сума за поръчката към момента. */
    private double total;

    /**
     * Създава нова отворена поръчка и генерира уникално ID.
     * @param table Масата, за която се отваря поръчката.
     */
    public Order(Table table) throws Exception {
        if (table == null) {
            throw new Exception("Order cannot be created without a valid table.");
        }
        this.id = UUID.randomUUID().toString().substring(0, 4).toUpperCase();

        this.table = table;
        this.items = new HashMap<>();
        this.orderStatus = OrderStatus.OPEN;
        this.dateAndTime = LocalDateTime.now();
        this.total = 0;
    }

    /**
     * Презареден конструктор за възстановяване на съществуваща поръчка от файл.
     * Използва се от FileManager при зареждане на историята на данните.
     *
     * @param id Оригиналният идентификатор на поръчката.
     * @param table Масата, свързана с поръчката.
     * @param orderStatus Статусът на поръчката (OPEN, PAID, CANCELED).
     * @param dateAndTime Датата и часът на създаване.
     * @param total Общата сума на поръчката.
     */
    public Order(String id, Table table, OrderStatus orderStatus, LocalDateTime dateAndTime, double total) {
        this.id = id;
        this.table = table;
        this.orderStatus = orderStatus;
        this.dateAndTime = dateAndTime;
        this.total = total;
        this.items = new HashMap<>();
    }

    /**
     * Връща ID-то на поръчката.
     * @return Уникалният идентификатор.
     */
    public String getId() {
        return id;
    }

    /**
     * Връща списъка с поръчани артикули.
     * @return Map колекция от артикули и техните количества.
     */
    public Map<MenuItem, Integer> getItems() {
        return items;
    }

    /**
     * Връща общата натрупана сума по поръчката.
     * @return Сумата в лева.
     */
    public double getTotal() {
        return total;
    }

    /**
     * Връща масата, свързана с тази поръчка.
     * @return Обект от тип Table.
     */
    public Table getTable() {
        return table;
    }

    /**
     * Връща текущия статус на поръчката.
     * @return Статусът (OPEN, PAID или CANCELED).
     */
    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    /**
     * Връща датата и часа на отваряне на поръчката.
     * @return Обект LocalDateTime.
     */
    public LocalDateTime getDateAndTime() {
        return dateAndTime;
    }

    /**
     * Променя статуса на поръчката.
     * @param orderStatus Новият статус, който да бъде зададен.
     */
    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    /**
     * Добавяне на артикул към поръчката.
     * @param item Артикулът, който е поръчан.
     * @param quantity Количеството.
     */
    public void addItem(MenuItem item, int quantity) {
        if (items.containsKey(item)) {
            int oldQuantity = items.get(item);
            items.put(item, oldQuantity + quantity);
        } else {
            items.put(item, quantity);
        }

        total += item.getPrice() * quantity;
    }

    public void removeItem(MenuItem item) {
        int quantity = items.get(item);
        total -= item.getPrice() * quantity;
        items.remove(item);
    }
}
