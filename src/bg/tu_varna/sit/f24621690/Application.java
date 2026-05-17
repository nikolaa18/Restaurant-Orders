package bg.tu_varna.sit.f24621690;

import bg.tu_varna.sit.f24621690.commands.factory.*;
import bg.tu_varna.sit.f24621690.io.FileManager;
import java.util.*;

public class Application {
    private static final Map<String, CommandFactory> commandMap = new HashMap<>();
    private static final FileManager fileManager = new FileManager();
    private static boolean running = true;

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
                    if (fileManager.getCurrentFile() == null && !cmdName.equals("open") && !cmdName.equals("help")) {
                        System.out.println("Error: No file is currently open. Please use 'open <file>' to begin.");
                        continue;
                    }

                    String resultMessage = commandMap.get(cmdName).execute(parts);

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

    private static void initializeAllCommands() {
        // File Commands
        commandMap.put("open", new OpenFileFactory(fileManager));
        commandMap.put("close", new CloseFileFactory(fileManager));
        commandMap.put("save", new SaveFactory(fileManager));
        commandMap.put("saveas", new SaveAsFactory(fileManager));
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