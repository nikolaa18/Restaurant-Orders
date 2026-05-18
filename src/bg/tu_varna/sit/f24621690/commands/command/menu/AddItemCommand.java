package bg.tu_varna.sit.f24621690.commands.command.menu;

import bg.tu_varna.sit.f24621690.models.Menu;
import bg.tu_varna.sit.f24621690.models.MenuItem;
import bg.tu_varna.sit.f24621690.commands.command.Command;
import bg.tu_varna.sit.f24621690.enums.ItemCategory;

/**
 * Команда за добавяне на нов артикул в глобалното меню на ресторанта.
 * <p>
 * Осъществява строг контрол върху данните, за да гарантира, че в менюто няма
 * да попаднат дублиращи се записи, което би нарушило консистентността при поръчки.
 * </p>
 */
public class AddItemCommand implements Command {
    private final String id;
    private final String name;
    private final ItemCategory itemCategory;
    private double price;
    private int quantity;

    /**
     * Конструктор за инициализиране на командата за добавяне на нов артикул в менюто.
     * @param id Идентификатор на артикула.
     * @param name Име на артикула.
     * @param itemCategory Категория.
     * @param price Цена.
     * @param quantity Количество.
     */
    public AddItemCommand(String id, String name, ItemCategory itemCategory, double price, int quantity) {
        this.id = id;
        this.name = name;
        this.itemCategory = itemCategory;
        this.price = price;
        this.quantity = quantity;
    }

    /**
     * Проверява дали артикул с такова ID или име вече съществува в системата,
     * и ако не - го добавя към менюто.
     *
     * @return Потвърдително съобщение, съдържащо името на добавения артикул.
     * @throws Exception При опит за добавяне на артикул с вече съществуващо ID или Име.
     */
    @Override
    public String execute() throws Exception {
        Menu menu = Menu.getInstance();

        if (menu.getItems().containsKey(id)) {
            throw new Exception("Item with ID " + id + " already exists in the menu.");
        }

        for (MenuItem existingItem : menu.getItems().values()) {
            if (existingItem.getName().equalsIgnoreCase(name)) {
                throw new Exception("Item with name '" + name + "' already exists.");
            }
        }

        MenuItem item = new MenuItem(id, name, itemCategory, price, quantity);
        menu.getItems().put(id, item);
        return "Item '" + name + "' added to menu.";
    }
}
