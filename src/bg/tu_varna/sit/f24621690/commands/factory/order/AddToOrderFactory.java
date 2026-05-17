package bg.tu_varna.sit.f24621690.commands.factory.order;
import bg.tu_varna.sit.f24621690.commands.command.order.AddToOrderCommand;
import bg.tu_varna.sit.f24621690.commands.factory.CommandFactory;

/**
 * Фабрика за създаване и изпълнение на командата за добавяне към поръчка (addtoorder).
 * Обработва три параметъра: ID на поръчката, ID на артикула и количество за добавяне.
 */
public class AddToOrderFactory implements CommandFactory {

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
            String itemId = args[2];
            int quantity = Integer.parseInt(args[3]);
            return new AddToOrderCommand(orderId, itemId, quantity).execute();
        } catch (NumberFormatException e) {
            throw new Exception("Invalid format: Item ID and Quantity must be integers.");
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new Exception("Missing parameters. Usage: addtoorder <orderId> <itemId> <quantity>");
        }
    }
}

