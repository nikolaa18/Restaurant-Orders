package bg.tu_varna.sit.f24621690.commands.factory.file;

import bg.tu_varna.sit.f24621690.commands.factory.CommandFactory;
import bg.tu_varna.sit.f24621690.io.FileManager;

/**
 * Фабрика за създаване и изпълнение на командата за отваряне на файл (open).
 * Валидира наличието на име на файл и извиква FileManager за зареждане на данните.
 * При критична грешка във формата на файла, прекратява изпълнението на програмата.
 */
public class OpenFileFactory implements CommandFactory {
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
            if (args.length < 2) {
                throw new Exception("Please specify a file to open. Usage: open <filename>");
            }
            return FileManager.getInstance().open(args[1]);
        } catch (Exception e) {
            System.out.println("Critical Error during file loading: " + e.getMessage());
            System.out.println("Application is terminating execution due to invalid data format.");

            System.exit(1);

            return null;
        }
    }
}