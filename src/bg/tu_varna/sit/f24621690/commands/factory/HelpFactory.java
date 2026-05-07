package bg.tu_varna.sit.f24621690.commands.factory;

// Factory for: help
public class HelpFactory implements CommandFactory {
    public void execute(String[] args) throws Exception {
        System.out.println("Available commands: open <file>, close, save, saveas <file>, help, exit, " +
                "additem, removeitem, menu, addtable, removetable, tables, openorder, " +
                "addtoorder, removefromorder, showorder, closeorder, cancelorder, " +
                "report, topitems, lowstock");
    }
}