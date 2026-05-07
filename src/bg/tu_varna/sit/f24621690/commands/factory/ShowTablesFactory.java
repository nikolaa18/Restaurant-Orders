package bg.tu_varna.sit.f24621690.commands.factory;

import bg.tu_varna.sit.f24621690.commands.ShowTablesCommand;

// Factory for: tables
public class ShowTablesFactory implements CommandFactory {
    public void execute(String[] args) throws Exception {
        new ShowTablesCommand().execute();
    }
}