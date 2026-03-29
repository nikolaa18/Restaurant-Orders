package bg.tu_varna.sit.f24621690.base;

import bg.tu_varna.sit.f24621690.enums.TableAvailability;

public class Table {
    private final int number;
    private int seats;
    private TableAvailability availability;

    //add data control - exceptions
    public Table(int number, int seats) {
        this.number = number;
        this.seats = seats;
        this.availability = TableAvailability.AVAILABLE;
    }

    public int getNumber() {
        return number;
    }

    public int getSeats() {
        return seats;
    }

    public TableAvailability getAvailability() {
        return availability;
    }

    public void setAvailability(TableAvailability availability) {
        this.availability = availability;
    }
}
