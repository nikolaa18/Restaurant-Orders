package bg.tu_varna.sit.f24621690.commands.factory.statistics;

import bg.tu_varna.sit.f24621690.commands.command.statistics.TopItemsCommand;
import bg.tu_varna.sit.f24621690.commands.factory.CommandFactory;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

/**
 * Фабрика за създаване и изпълнение на командата за най-продавани артикули (topitems).
 * Валидира броя на желаните резултати (n) и времевия период за справката.
 */
public class TopItemsFactory implements CommandFactory {

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
            int n = Integer.parseInt(args[1]);
            if (n <= 0) {
                throw new Exception("The number of items (n) must be a positive integer.");
            }

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH:mm");
            LocalDateTime from = LocalDateTime.parse(args[2], formatter);
            LocalDateTime to = LocalDateTime.parse(args[3], formatter);

            return new TopItemsCommand(n, from, to).execute();
        } catch (NumberFormatException e) {
            throw new Exception("Invalid parameter: 'n' must be a whole number.");
        } catch (DateTimeParseException e) {
            throw new Exception("Invalid date format. Please use format: yyyy-MM-dd_HH:mm (2026-05-14_14:25)");
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new Exception("Missing parameters. Usage: topitems <n> <from> <to>");
        }
    }
}