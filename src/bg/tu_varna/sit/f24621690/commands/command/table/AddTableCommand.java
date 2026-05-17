package bg.tu_varna.sit.f24621690.commands.command.table;

import bg.tu_varna.sit.f24621690.base.Restaurant;
import bg.tu_varna.sit.f24621690.base.Table;
import bg.tu_varna.sit.f24621690.commands.command.Command;

/**
 * Команда за добавяне на нова маса в конфигурацията на ресторанта.
 * Проверява дали номерът на масата вече съществува в системата, за да се избегне дублиране.
 */
public class AddTableCommand implements Command {

    /** Номерът на новата маса, която ще бъде добавена. */
    private int number;

    /** Броят места (капацитетът) на новата маса. */
    private int seats;

    /**
     * Конструктор за инициализиране на командата с необходимите параметри за нова маса.
     * @param number Уникален номер на масата.
     * @param seats Брой места на масата.
     */
    public AddTableCommand(int number, int seats) {
        this.number = number;
        this.seats = seats;
    }

    /**
     * Изпълнява проверката за уникалност и регистрира новата маса в паметта на ресторанта.
     * @return Текстово съобщение за успешно добавена маса с нейния номер.
     * @throws Exception Ако маса със същия номер вече е регистрирана в ресторанта.
     */
    @Override
    public String execute() throws Exception {
        Restaurant restaurant = Restaurant.getInstance();

        if (restaurant.getTables().containsKey(number)) {
            throw new Exception("Table number " + number + " already exists.");
        }

        Table table = new Table(number, seats);
        restaurant.getTables().put(number, table);
        return "Table " + number + " added successfully.";
    }
}
