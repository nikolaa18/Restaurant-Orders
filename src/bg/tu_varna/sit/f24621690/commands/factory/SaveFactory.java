package bg.tu_varna.sit.f24621690.commands.factory;

import bg.tu_varna.sit.f24621690.commands.factory.CommandFactory;
import bg.tu_varna.sit.f24621690.io.FileManager;

// Factory for: save
public class SaveFactory implements CommandFactory {
    private FileManager fm;
    public SaveFactory(FileManager fm) { this.fm = fm; }
    public void execute(String[] args) throws Exception {
        fm.save(fm.getCurrentFilePath());
    }
}