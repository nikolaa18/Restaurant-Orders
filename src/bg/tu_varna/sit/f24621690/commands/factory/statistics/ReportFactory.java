package bg.tu_varna.sit.f24621690.commands.factory.statistics;

import bg.tu_varna.sit.f24621690.commands.command.statistics.ReportCommand;
import bg.tu_varna.sit.f24621690.commands.factory.CommandFactory;

import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;

/**
 * Фабрика за създаване и изпълнение на командата за финансов отчет (report).
 * Парсва началната и крайната дата от текстов вид към обекти от тип LocalDateTime.
 */
public class ReportFactory implements CommandFactory {

    /**
     * Обработва и валидира входните аргументи от конзолата, след което създава
     * и стартира съответната команда от бизнес логиката.
     *
     * @param args Масив от текстови низове (String), съдържащ името на командата
     * и всички подадени към нея параметри.
     * @return Текстово съобщение с резултата от изпълнението, което да бъде показано на потребителя.
     * @throws Exception Ако входните параметри липсват, са в невалиден формат (напр. текст вместо число)
     * или възникне грешка при изпълнението на самата команда.
     */
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