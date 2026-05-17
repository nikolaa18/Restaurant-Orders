package bg.tu_varna.sit.f24621690.commands.factory.menu;

import bg.tu_varna.sit.f24621690.commands.command.menu.RemoveItemCommand;
import bg.tu_varna.sit.f24621690.commands.factory.CommandFactory;

/**
 * Фабрика за създаване и изпълнение на командата за премахване на артикул (removeitem).
 * Валидира подадения идентификатор на артикула и извиква бизнес логиката за изтриване.
 */
public class RemoveItemFactory implements CommandFactory {

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
            String id = args[1];
            return new RemoveItemCommand(id).execute();
        } catch (NumberFormatException e) {
            throw new Exception("Invalid ID format. ID must be an integer.");
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new Exception("Usage: removeitem <id>");
        }
    }
}