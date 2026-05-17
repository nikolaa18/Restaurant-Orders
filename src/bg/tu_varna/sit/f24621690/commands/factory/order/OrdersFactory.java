package bg.tu_varna.sit.f24621690.commands.factory.order;

import bg.tu_varna.sit.f24621690.commands.command.order.OrdersCommand;
import bg.tu_varna.sit.f24621690.commands.factory.CommandFactory;
import bg.tu_varna.sit.f24621690.enums.OrderStatus;

/**
 * Фабрика за създаване и изпълнение на командата за списък с поръчки (orders).
 * Проверява за наличие на опционален параметър за филтриране по статус (напр. status=PAID).
 */
public class OrdersFactory implements CommandFactory {

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
        String statusFilter = null;

        if (args.length > 1) {
            String arg = args[1];
            if (arg.toLowerCase().startsWith("status=")) {
                statusFilter = arg.substring(7).trim().toUpperCase();
                try {
                    OrderStatus.valueOf(statusFilter);
                } catch (IllegalArgumentException e) {
                    throw new Exception("Invalid status filter. Available: OPEN, PAID, CANCELED");
                }
            } else {
                throw new Exception("Invalid parameter format. Usage: orders [status=<status>]");
            }
        }

        return new OrdersCommand(statusFilter).execute();
    }
}