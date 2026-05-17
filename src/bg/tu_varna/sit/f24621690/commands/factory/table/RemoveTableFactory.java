package bg.tu_varna.sit.f24621690.commands.factory.table;

import bg.tu_varna.sit.f24621690.commands.command.table.RemoveTableCommand;
import bg.tu_varna.sit.f24621690.commands.factory.CommandFactory;

/**
 * Фабрика за създаване и изпълнение на командата за премахване на маса (removetable).
 * Валидира подадения номер на маса и извиква съответната логика за изтриване.
 */
public class RemoveTableFactory implements CommandFactory {

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
            int number = Integer.parseInt(args[1]);
            return new RemoveTableCommand(number).execute();
        } catch (NumberFormatException e) {
            throw new Exception("Table number must be an integer.");
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new Exception("Usage: removetable <number>");
        }
    }
}