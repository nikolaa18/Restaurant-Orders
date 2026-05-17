package bg.tu_varna.sit.f24621690;

import bg.tu_varna.sit.f24621690.commands.factory.*;
import bg.tu_varna.sit.f24621690.commands.factory.file.*;
import bg.tu_varna.sit.f24621690.commands.factory.menu.AddItemFactory;
import bg.tu_varna.sit.f24621690.commands.factory.menu.RemoveItemFactory;
import bg.tu_varna.sit.f24621690.commands.factory.menu.ShowMenuFactory;
import bg.tu_varna.sit.f24621690.commands.factory.order.*;
import bg.tu_varna.sit.f24621690.commands.factory.statistics.LowStockFactory;
import bg.tu_varna.sit.f24621690.commands.factory.statistics.ReportFactory;
import bg.tu_varna.sit.f24621690.commands.factory.statistics.TopItemsFactory;
import bg.tu_varna.sit.f24621690.commands.factory.table.AddTableFactory;
import bg.tu_varna.sit.f24621690.commands.factory.table.RemoveTableFactory;
import bg.tu_varna.sit.f24621690.commands.factory.table.ShowTablesFactory;
import bg.tu_varna.sit.f24621690.io.FileManager;
import java.util.*;

/**
 * Главният входен клас на приложението за управление на ресторант.
 * Отговаря за инициализацията на всички команди и управлява основния
 * жизнен цикъл на програмата (чете потребителски вход от конзолата,
 * валидира състоянието на файловата система и препраща изпълнението
 * към съответните фабрики).
 */
public class Application {
    /** * Речник (Map), който свързва текстовото име на всяка команда (напр. "open")
     * с нейната съответна фабрика, която ще я обработи. */
    private static final Map<String, CommandFactory> commandMap = new HashMap<>();

    /** Флаг, указващ дали основният цикъл на приложението продължава да работи. */
    private static boolean running = true;

    /**
     * Входна точка на приложението. Стартира безкрайния цикъл за четене на команди.
     * Обработва потребителския вход, проверява дали има зареден файл и прихваща
     * глобални грешки при изпълнението на командите.
     * @param args Аргументи при стартиране на програмата от конзолата (не се използват).
     */
    public static void main(String[] args) {
        initializeAllCommands();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Restaurant Management System started. Type 'help' for commands.");

        while (running) {
            System.out.print("> ");
            String input = scanner.nextLine().trim();
            if (input.isEmpty()) {
                continue;
            }

            String[] parts = input.split("\\s+");
            String cmdName = parts[0].toLowerCase();

            if (cmdName.equals("exit")) {
                running = false;
                System.out.println("Exiting program...");
            } else if (commandMap.containsKey(cmdName)) {
                try {
                    // Защита: Позволява само команди open и help, ако няма отворен файл
                    if (FileManager.getInstance().getCurrentFile() == null && !cmdName.equals("open") && !cmdName.equals("help")) {
                        System.out.println("Error: No file is currently open. Please use 'open <file>' to begin.");
                        continue;
                    }

                    // Изпълнение на командата чрез съответната фабрика
                    String resultMessage = commandMap.get(cmdName).execute(parts);

                    // Отпечатване на върнатия резултат, ако има такъв
                    if (resultMessage != null && !resultMessage.isEmpty()) {
                        System.out.println(resultMessage);
                    }

                } catch (ArrayIndexOutOfBoundsException e) {
                    System.out.println("Error: Missing parameters for '" + cmdName + "'.");
                } catch (Exception e) {
                    System.out.println("Error: " + e.getMessage());
                }
            } else {
                System.out.println("Unknown command. Type 'help' for info.");
            }
        }
        scanner.close();
    }

    /**
     * Инициализира и регистрира всички поддържани команди в системата.
     * Свързва текстовите ключове (командите) с техните съответни обекти
     * от тип {@link CommandFactory}. Този метод се извиква еднократно
     * при стартиране на програмата.
     */
    private static void initializeAllCommands() {
        // File Commands
        commandMap.put("open", new OpenFileFactory());
        commandMap.put("close", new CloseFileFactory());
        commandMap.put("save", new SaveFactory());
        commandMap.put("saveas", new SaveAsFactory());
        commandMap.put("help", new HelpFactory());

        // Menu Management
        commandMap.put("additem", new AddItemFactory());
        commandMap.put("removeitem", new RemoveItemFactory());
        commandMap.put("menu", new ShowMenuFactory());

        // Table Management
        commandMap.put("addtable", new AddTableFactory());
        commandMap.put("removetable", new RemoveTableFactory());
        commandMap.put("tables", new ShowTablesFactory());

        // Order Management
        commandMap.put("openorder", new OpenOrderFactory());
        commandMap.put("addtoorder", new AddToOrderFactory());
        commandMap.put("removefromorder", new RemoveFromOrderFactory());
        commandMap.put("showorder", new ShowOrderFactory());
        commandMap.put("closeorder", new CloseOrderFactory());
        commandMap.put("cancelorder", new CancelOrderFactory());
        commandMap.put("orders", new OrdersFactory());

        // Statistics
        commandMap.put("report", new ReportFactory());
        commandMap.put("topitems", new TopItemsFactory());
        commandMap.put("lowstock", new LowStockFactory());
    }
}