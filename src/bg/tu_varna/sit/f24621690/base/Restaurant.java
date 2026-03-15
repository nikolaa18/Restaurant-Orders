package bg.tu_varna.sit.f24621690.base;

import java.util.HashSet;
import java.util.Set;

public class Restaurant {
    public static Restaurant instance;
    private Set<Table> tables;
    private Set<Order> orders;

    public Restaurant() {
        this.tables = new HashSet<>();
        this.orders = new HashSet<>();
    }

    //Singleton
    public static Restaurant getInstance() {
        if(instance == null) {
            instance = new Restaurant();
        }
        return instance;
    }

    public Set<Table> getTables() {
        return tables;
    }

    public Set<Order> getOrders() {
        return orders;
    }
}
