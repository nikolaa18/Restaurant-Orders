package bg.tu_varna.sit.f24621690.commands.factory;

import bg.tu_varna.sit.f24621690.commands.command.TopItemsCommand;
import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;

// Factory for: topitems <n> <from> <to>
public class TopItemsFactory implements CommandFactory {
    @Override
    public String execute(String[] args) throws Exception {
        try {
            int n = Integer.parseInt(args[1]);
            if (n <= 0) {
                throw new Exception("The number of items (n) must be a positive integer.");
            }

            LocalDateTime from = LocalDateTime.parse(args[2]);
            LocalDateTime to = LocalDateTime.parse(args[3]);

            return new TopItemsCommand(n, from, to).execute();
        } catch (NumberFormatException e) {
            throw new Exception("Invalid parameter: 'n' must be a whole number.");
        } catch (DateTimeParseException e) {
            throw new Exception("Invalid date format. Please use format: yyyy-MM-ddTHH:mm (2026-05-14T14:25)");
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new Exception("Missing parameters. Usage: topitems <n> <from> <to>");
        }
    }
}