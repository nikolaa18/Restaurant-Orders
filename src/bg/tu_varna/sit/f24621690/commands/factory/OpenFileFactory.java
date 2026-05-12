package bg.tu_varna.sit.f24621690.commands.factory;

import bg.tu_varna.sit.f24621690.io.FileManager;

// Factory for: open <filename>
public class OpenFileFactory implements CommandFactory {
    private FileManager fm;
    public OpenFileFactory(FileManager fm) {
        this.fm = fm;
    }

    public void execute(String[] args) throws Exception {
        try {
            fm.open(args[1]);
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new Exception("Please specify a file to open. Usage: open <filename>");
        }
    }
}
