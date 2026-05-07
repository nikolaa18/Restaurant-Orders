package bg.tu_varna.sit.f24621690.commands.factory;

import bg.tu_varna.sit.f24621690.commands.factory.CommandFactory;
import bg.tu_varna.sit.f24621690.io.FileManager;

// Factory for: saveas <file>
public class SaveAsFactory implements CommandFactory {
    private FileManager fm;
    public SaveAsFactory(FileManager fm) { this.fm = fm; }
    public void execute(String[] args) throws Exception {
        fm.save(args[1]);
    }
}