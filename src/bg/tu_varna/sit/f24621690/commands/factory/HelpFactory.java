package bg.tu_varna.sit.f24621690.commands.factory;

// Factory for: help
public class HelpFactory implements CommandFactory {
    @Override
    public void execute(String[] args) throws Exception {
        System.out.println("AVAILABLE COMMANDS:\n");
        System.out.println("=".repeat(85) + "\n");

        printLine("open <file>", "Opens a data file.");
        printLine("close", "Closes the current file.");
        printLine("save", "Saves changes to current file.");
        printLine("saveas <file>", "Saves data to a new file.");
        printLine("help", "Shows all available commands.");
        printLine("exit", "Exits the program.");

        System.out.println("-".repeat(85));

        printLine("additem <n> <cat> <p> <q>", "Adds a new item to the menu.");
        printLine("removeitem <itemId>", "Removes an item from the menu.");
        printLine("menu", "Displays the full menu.");

        System.out.println("-".repeat(85));

        printLine("addtable <num> <seats>", "Adds a new table.");
        printLine("removetable <num>", "Removes a table.");
        printLine("tables", "Shows all tables and their status.");

        System.out.println("-".repeat(85));

        printLine("openorder <tableNum>", "Opens a new order for a table.");
        printLine("addtoorder <id> <item> <q>", "Adds an item to an order.");
        printLine("removefromorder <id> <item>", "Removes an item from an order.");
        printLine("showorder <orderId>", "Shows order details and total.");
        printLine("closeorder <orderId>", "Finalizes and pays the order.");
        printLine("cancelorder <orderId>", "Cancels the order.");

        System.out.println("-".repeat(85));

        printLine("report <from> <to>", "Shows order history for a period.");
        printLine("topitems <n> <from> <to>", "Shows best selling items.");
        printLine("lowstock <threshold>", "Shows items with low availability.");

        System.out.println("=".repeat(85) + "\n");
    }

    private void printLine(String command, String description) {
        System.out.printf("%-40s => %s%n", command, description);
    }
}