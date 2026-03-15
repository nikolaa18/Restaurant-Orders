package bg.tu_varna.sit.f24621690.base;

import bg.tu_varna.sit.f24621690.enums.TableAvailability;

public class Table {
    private final int number;
    private int seats;
    private TableAvailability availability;

    public Table(int number, int seats, TableAvailability availability) {
        this.number = number;
        this.seats = seats;
        this.availability = availability;
    }
}
