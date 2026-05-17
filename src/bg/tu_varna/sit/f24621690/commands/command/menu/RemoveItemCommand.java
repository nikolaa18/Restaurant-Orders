package bg.tu_varna.sit.f24621690.commands.command.menu;

import bg.tu_varna.sit.f24621690.base.Menu;
import bg.tu_varna.sit.f24621690.commands.command.Command;

/**
 * Команда за премахване на артикул от менюто на ресторанта.
 * Изтрива продукта от глобалната складова наличност на системата.
 */
public class RemoveItemCommand implements Command {
    /** Идентификатор на артикула от менюто, който трябва да бъде премахнат. */
    private String id;

    /**
    * Конструктор за инициализиране на командата за премахване на артикул менюто.
    * @param id Идентификатор на артикула за изтриване. */
    public RemoveItemCommand(String id) {
        this.id = id;
    }

    /**
     * Проверява дали артикулът съществува в системата и го премахва от менюто.
     * @return Текстово съобщение за успешно премахнат артикул.
     * @throws Exception Ако артикул с посоченото ID не бъде открит в менюто.
     */
    @Override
    public String execute() throws Exception {
        Menu menu = Menu.getInstance();
        if (!menu.getItems().containsKey(this.id)) {
            throw new Exception("Cannot remove: Item with ID " + id + " not found.");
        }
        menu.getItems().remove(this.id);
        return "Item removed successfully.";
    }
}
