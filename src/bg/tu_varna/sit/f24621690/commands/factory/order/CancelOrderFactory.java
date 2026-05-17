package bg.tu_varna.sit.f24621690.commands.factory.order;

import bg.tu_varna.sit.f24621690.commands.command.order.CancelOrderCommand;
import bg.tu_varna.sit.f24621690.commands.factory.CommandFactory;

/**
 * Фабрика за създаване и изпълнение на командата за анулиране на поръчка (cancelorder).
 * Предава идентификатора на поръчката към логиката за отказване и освобождаване на масата.
 */
public class CancelOrderFactory implements CommandFactory {

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
            String orderId = args[1];
            return new CancelOrderCommand(orderId).execute();
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new Exception("Usage: cancelorder <orderId>");
        }
    }
}
