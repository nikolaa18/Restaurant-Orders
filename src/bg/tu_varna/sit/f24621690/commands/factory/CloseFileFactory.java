package bg.tu_varna.sit.f24621690.commands.factory;

import bg.tu_varna.sit.f24621690.io.FileManager;

// Factory for: close
public class CloseFileFactory implements CommandFactory {
    private final FileManager fm;

    public CloseFileFactory(FileManager fm) {
        this.fm = fm;
    }

    @Override
    public String execute(String[] args) throws Exception {
        return fm.close();
    }
}