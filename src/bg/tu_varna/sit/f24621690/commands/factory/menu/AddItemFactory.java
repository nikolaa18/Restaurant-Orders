package bg.tu_varna.sit.f24621690.commands.factory.menu;

import bg.tu_varna.sit.f24621690.commands.command.menu.AddItemCommand;
import bg.tu_varna.sit.f24621690.commands.factory.CommandFactory;
import bg.tu_varna.sit.f24621690.enums.ItemCategory;

/**
 * Фабрика за създаване и изпълнение на командата за добавяне на артикул (additem).
 * Парсва и валидира пет параметъра (id, име, категория, цена, количество) преди да създаде командата.
 */
public class AddItemFactory implements CommandFactory {

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
            String name = args[2];
            ItemCategory category = ItemCategory.valueOf(args[3].toUpperCase());
            double price = Double.parseDouble(args[4]);
            int quantity = Integer.parseInt(args[5]);

            return new AddItemCommand(id, name, category, price, quantity).execute();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}