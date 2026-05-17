package bg.tu_varna.sit.f24621690.commands.factory.statistics;

import bg.tu_varna.sit.f24621690.commands.command.statistics.LowStockCommand;
import bg.tu_varna.sit.f24621690.commands.factory.CommandFactory;

/**
 * Фабрика за създаване и изпълнение на командата за критични наличности (lowstock).
 * Парсва зададения праг на наличност в цяло число и стартира проверката в склада.
 */
public class LowStockFactory implements CommandFactory {

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
            int threshold = Integer.parseInt(args[1]);
            return new LowStockCommand(threshold).execute();
        } catch (NumberFormatException e) {
            throw new Exception("Threshold must be a whole number.");
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new Exception("Usage: lowstock <threshold>");
        }
    }
}
