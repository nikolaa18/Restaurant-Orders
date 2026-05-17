package bg.tu_varna.sit.f24621690.commands.factory.table;

import bg.tu_varna.sit.f24621690.commands.command.table.ShowTablesCommand;
import bg.tu_varna.sit.f24621690.commands.factory.CommandFactory;

/**
 * Фабрика за създаване и изпълнение на командата за преглед на масите (tables).
 * Директно инициира командата за визуализиране на всички маси и техните статуси.
 */
public class ShowTablesFactory implements CommandFactory {

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
        return new ShowTablesCommand().execute();
    }
}