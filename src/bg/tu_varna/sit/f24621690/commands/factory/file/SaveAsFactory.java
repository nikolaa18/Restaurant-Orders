package bg.tu_varna.sit.f24621690.commands.factory.file;

import bg.tu_varna.sit.f24621690.commands.factory.CommandFactory;
import bg.tu_varna.sit.f24621690.io.FileManager;

/**
 * Фабрика за създаване и изпълнение на командата за запазване като нов файл (saveas).
 * Валидира потребителския вход за ново име на файл и предава пътя към FileManager.
 */
public class SaveAsFactory implements CommandFactory {

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
            return FileManager.getInstance().save(args[1]);
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new Exception("Missing filename. Usage: saveas <filename>");
        }
    }
}