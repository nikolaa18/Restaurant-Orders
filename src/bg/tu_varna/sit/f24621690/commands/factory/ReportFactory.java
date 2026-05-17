package bg.tu_varna.sit.f24621690.commands.factory;

import bg.tu_varna.sit.f24621690.commands.command.ReportCommand;
import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;

// Factory for: report <from> <to>
public class ReportFactory implements CommandFactory {
    @Override
    public String execute(String[] args) throws Exception {
        try {
            LocalDateTime from = LocalDateTime.parse(args[1]);
            LocalDateTime to = LocalDateTime.parse(args[2]);
            return new ReportCommand(from, to).execute();
        } catch (DateTimeParseException e) {
            throw new Exception("Invalid date format. Please use format: yyyy-MM-ddTHH:mm (2026-05-14T14:25)");
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new Exception("Missing parameters. Usage: report <from> <to>");
        }
    }
}