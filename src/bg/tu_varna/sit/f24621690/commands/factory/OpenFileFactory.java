package bg.tu_varna.sit.f24621690.commands.factory;

import bg.tu_varna.sit.f24621690.io.FileManager;

// Factory for: open <filename>
public class OpenFileFactory implements CommandFactory {
    private final FileManager fm;

    public OpenFileFactory(FileManager fm) {
        this.fm = fm;
    }

    @Override
    public String execute(String[] args) throws Exception {
        try {
            if (args.length < 2) {
                throw new Exception("Please specify a file to open. Usage: open <filename>");
            }
            return fm.open(args[1]);
        } catch (Exception e) {
            System.out.println("Critical Error during file loading: " + e.getMessage());
            System.out.println("Application is terminating execution due to invalid data format.");

            System.exit(1);

            return null;
        }
    }
}