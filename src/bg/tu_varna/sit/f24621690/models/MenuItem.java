package bg.tu_varna.sit.f24621690.models;

import bg.tu_varna.sit.f24621690.enums.ItemCategory;

/**
 * Клас, представляващ артикул от менюто на ресторанта.
 */
public class MenuItem {
    /** Уникален идентификатор на артикула. */
    private final String id;

    /** Наименование на артикула (напр. "Шопска салата"). */
    private final String name;

    /** Категория, към която спада артикулът (напр. предястие, основно). */
    private final ItemCategory itemCategory;

    /** Цена на артикула в евро. */
    private double price;

    /** Налично количество от артикула в склада. */
    private int quantity;

    /**
     * Създава нов артикул в менюто.
     * @param id Уникален идентификатор на артикула.
     * @param name Наименование на артикула.
     * @param itemCategory Категория на артикула (напр. MAIN, DRINK).
     * @param price Цена на артикула.
     * @param quantity Налично количество в склада.
     */
    public MenuItem(String id, String name, ItemCategory itemCategory, double price, int quantity) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Item name cannot be empty.");
        }
        if (price < 0) {
            throw new IllegalArgumentException("Price cannot be negative.");
        }
        if (quantity < 0) {
            throw new IllegalArgumentException("Quantity cannot be negative.");
        }
        this.id = id;
        this.name = name;
        this.itemCategory = itemCategory;
        this.price = price;
        this.quantity = quantity;
    }


    /**
     * Намаляява наличното количество на артикула.
     * @param amount Количествово, с което ще бъде намалено.
     */
    public void reduceQuantity(int amount) {
        this.quantity -= amount;
    }

    /**
     * Връща идентификатора на артикула.
     * @return Уникалното ID.
     */
    public String getId() {
        return id;
    }

    /**
     * Връща името на артикула.
     * @return Наименованието на артикула.
     */
    public String getName() {
        return name;
    }

    /**
     * Връща категорията на артикула.
     * @return Обект от тип ItemCategory.
     */
    public ItemCategory getItemCategory() {
        return itemCategory;
    }

    /**
     * Връща цената на артикула.
     * @return Цената като число с плаваща запетая.
     */
    public double getPrice() {
        return price;
    }

    /**
     * Връща текущата наличност от артикула.
     * @return Наличното количество в склада.
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Обновява наличното количество на артикула.
     * @param quantity Новото количество, което да бъде записано.
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
