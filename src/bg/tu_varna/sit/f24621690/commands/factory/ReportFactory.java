package bg.tu_varna.sit.f24621690.commands.factory;

import bg.tu_varna.sit.f24621690.commands.command.ReportCommand;

// Factory for: report <from> <to>
public class ReportFactory implements CommandFactory {
    public void execute(String[] args) throws Exception {
        java.time.LocalDateTime from = java.time.LocalDateTime.parse(args[1]);
        java.time.LocalDateTime to = java.time.LocalDateTime.parse(args[2]);
        new ReportCommand(from, to).execute();
    }
}