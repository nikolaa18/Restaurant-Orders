package bg.tu_varna.sit.f24621690.commands.command.table;

import bg.tu_varna.sit.f24621690.models.Restaurant;
import bg.tu_varna.sit.f24621690.commands.command.Command;

/** Команда за премахване на маса от системата. */
public class RemoveTableCommand implements Command {

    /** Номерът на масата, която трябва да бъде премахната. */
    private int number;

    /**
     * Конструктор за инициализиране на командата.
     * @param number Номер на масата за изтриване.
     */
    public RemoveTableCommand(int number) {
        this.number = number;
    }

    /**
     * Проверява дали масата съществува в системата и я изтрива от паметта.
     * @return Съобщение за успешно премахната маса.
     * @throws Exception Ако маса с посочения номер не съществува.
     */
    @Override
    public String execute() throws Exception {
        Restaurant restaurant = Restaurant.getInstance();
        if (!restaurant.getTables().containsKey(this.number)) {
            throw new Exception("Cannot remove: Table " + number + " not found.");
        }
        restaurant.getTables().remove(this.number);
        return "Table " + number + " removed successfully.";
    }
}
