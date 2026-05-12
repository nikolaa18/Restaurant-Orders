package bg.tu_varna.sit.f24621690.commands.factory;

import bg.tu_varna.sit.f24621690.commands.command.LowStockCommand;

// Factory for: lowstock <threshold>
public class LowStockFactory implements CommandFactory {
    public void execute(String[] args) throws Exception {
        try {
            int threshold = Integer.parseInt(args[1]);
            new LowStockCommand(threshold).execute();
        } catch (NumberFormatException e) {
            throw new Exception("Threshold must be a whole number.");
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new Exception("Usage: lowstock <threshold>");
        }
    }
}
