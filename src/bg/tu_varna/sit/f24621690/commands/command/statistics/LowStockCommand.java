package bg.tu_varna.sit.f24621690.commands.command.statistics;

import bg.tu_varna.sit.f24621690.models.Menu;
import bg.tu_varna.sit.f24621690.models.MenuItem;
import bg.tu_varna.sit.f24621690.commands.command.Command;

/** Команда за проверка и извеждане на артикулите, чиито наличности са под определена критична стойност. */
public class LowStockCommand implements Command {

    /** Количествен праг, под който наличността на даден продукт се счита за дефицитна. */
    private int threshold;

    /**
     * Конструктор за инициализиране на командата със специфичен праг за проверка.
     * @param threshold Праг, под който артикулът се счита за изчерпващ се.
     */
    public LowStockCommand(int threshold) {
        this.threshold = threshold;
    }

    /**
     * Обхожда текущото меню и филтрира продуктите с наличност по-малка от дефинирания праг.
     * @return Форматиран низ със списък от дефицитните продукти или потвърждение, че складът е зареден.
     */
    @Override
    public String execute() {
        Menu menu = Menu.getInstance();
        StringBuilder sb = new StringBuilder();
        sb.append("--- Low Stock Items (Below ").append(threshold).append(") ---\n");

        boolean found = false;
        for (MenuItem item : menu.getItems().values()) {
            if (item.getQuantity() < threshold) {
                sb.append(String.format("ID: %s | Name: %s | Stock: %d\n",
                        item.getId(), item.getName(), item.getQuantity()));
                found = true;
            }
        }

        if (!found) {
            sb.append("All items are well stocked.");
        }
        return sb.toString().trim();
    }
}