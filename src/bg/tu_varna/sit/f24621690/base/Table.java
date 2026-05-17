package bg.tu_varna.sit.f24621690.base;

import bg.tu_varna.sit.f24621690.enums.TableAvailability;

/**
 * Клас, представляващ маса в ресторанта.
 */
public class Table {
    /** Уникален номер на масата в ресторанта. */
    private final int number;

    /** Максимален капацитет (брой места) на масата. */
    private int seats;

    /** Текущ статус на масата (свободна или заета). */
    private TableAvailability availability;

    /**
     * Създава нова маса.
     * @param number Уникален номер на масата.
     * @param seats Капацитет (брой места) на масата.
     */
    public Table(int number, int seats) {
        if (number <= 0) {
            throw new IllegalArgumentException("Table number must be positive.");
        }
        if (seats <= 0) {
            throw new IllegalArgumentException("Seats must be at least 1.");
        }
        this.number = number;
        this.seats = seats;
        this.availability = TableAvailability.AVAILABLE;
    }

    /**
     * Връща номера на масата.
     * @return Номерът на масата.
     */
    public int getNumber() {
        return number;
    }

    /**
     * Връща капацитета на масата.
     * @return Броят на местата.
     */
    public int getSeats() {
        return seats;
    }

    /**
     * Връща текущия статус на заетост на масата.
     * @return Статусът (AVAILABLE или TAKEN).
     */
    public TableAvailability getAvailability() {
        return availability;
    }

    /**
     * Променя статуса на заетост на масата.
     * @param availability Новият статус на масата.
     */
    public void setAvailability(TableAvailability availability) {
        this.availability = availability;
    }
}
