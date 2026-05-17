package bg.tu_varna.sit.f24621690.commands.factory.file;

import bg.tu_varna.sit.f24621690.commands.factory.CommandFactory;

/**
 * Фабрика за създаване и изпълнение на командата за помощ (help).
 * Не изисква параметри. Връща форматиран списък с всички налични команди в системата.
 */
public class HelpFactory implements CommandFactory {

    /**
     * Обработва и валидира входните аргументи от конзолата, след което създава
     * и стартира съответната команда от бизнес логиката.
     *
     * @param args Масив от текстови низове (String), съдържащ името на командата
     * и всички подадени към нея параметри.
     * @return Текстово съобщение с резултата от изпълнението, което да бъде показано на потребителя.
     */
    @Override
    public String execute(String[] args) throws Exception {
        StringBuilder sb = new StringBuilder();
        sb.append("AVAILABLE COMMANDS:\n");
        sb.append("=".repeat(85)).append("\n");

        sb.append(formatLine("open <file>", "Opens a data file."));
        sb.append(formatLine("close", "Closes the current file."));
        sb.append(formatLine("save", "Saves changes to current file."));
        sb.append(formatLine("saveas <file>", "Saves data to a new file."));
        sb.append(formatLine("help", "Shows all available commands."));
        sb.append(formatLine("exit", "Exits the program."));

        sb.append("-".repeat(85)).append("\n");

        sb.append(formatLine("additem <n> <cat> <p> <q>", "Adds a new item to the menu."));
        sb.append(formatLine("removeitem <itemId>", "Removes an item from the menu."));
        sb.append(formatLine("menu", "Displays the full menu."));

        sb.append("-".repeat(85)).append("\n");

        sb.append(formatLine("addtable <num> <seats>", "Adds a new table."));
        sb.append(formatLine("removetable <num>", "Removes a table."));
        sb.append(formatLine("tables", "Shows all tables and their status."));

        sb.append("-".repeat(85)).append("\n");

        sb.append(formatLine("openorder <tableNum>", "Opens a new order for a table."));
        sb.append(formatLine("addtoorder <id> <item> <q>", "Adds an item to an order."));
        sb.append(formatLine("removefromorder <id> <item>", "Removes an item from an order."));
        sb.append(formatLine("showorder <orderId>", "Shows order details and total."));
        sb.append(formatLine("closeorder <orderId>", "Finalizes and pays the order."));
        sb.append(formatLine("cancelorder <orderId>", "Cancels the order."));

        sb.append("-".repeat(85)).append("\n");

        sb.append(formatLine("report <from> <to>", "Shows order history for a period."));
        sb.append(formatLine("topitems <n> <from> <to>", "Shows best selling items."));
        sb.append(formatLine("lowstock <threshold>", "Shows items with low availability."));

        sb.append("=".repeat(85)).append("\n");

        return sb.toString();
    }

    /** Форматира начина, по който ще се отпечатва завсиимостта команда - описание */
    private String formatLine(String command, String description) {
        return String.format("%-40s => %s%n", command, description);
    }
}