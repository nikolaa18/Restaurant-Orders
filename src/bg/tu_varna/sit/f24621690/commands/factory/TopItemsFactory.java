package bg.tu_varna.sit.f24621690.commands.factory;

import bg.tu_varna.sit.f24621690.commands.command.TopItemsCommand;

// Factory for: topitems <n> <from> <to>
public class TopItemsFactory implements CommandFactory {
    public void execute(String[] args) throws Exception {
        int n = Integer.parseInt(args[1]);
        java.time.LocalDateTime from = java.time.LocalDateTime.parse(args[2]);
        java.time.LocalDateTime to = java.time.LocalDateTime.parse(args[3]);
        new TopItemsCommand(n, from, to).execute();
    }
}