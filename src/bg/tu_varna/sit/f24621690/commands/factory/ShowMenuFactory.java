package bg.tu_varna.sit.f24621690.commands.factory;

import bg.tu_varna.sit.f24621690.commands.command.ShowMenuCommand;

// Factory for: menu (no parameters)
public class ShowMenuFactory implements CommandFactory {
    @Override
    public String execute(String[] args) throws Exception {
        return new ShowMenuCommand().execute();
    }
}