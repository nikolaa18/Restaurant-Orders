package bg.tu_varna.sit.f24621690.base;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Restaurant {
    public static Restaurant instance;
    private Map<Integer, Table> tables;
    private Map<Integer, Order> orders;

    public Restaurant() {
        this.tables = new HashMap<>();
        this.orders = new HashMap<>();
    }

    //Singleton
    public static Restaurant getInstance() {
        if(instance == null) {
            instance = new Restaurant();
        }
        return instance;
    }

    public Map<Integer, Table> getTables() {
        return tables;
    }

    public Map<Integer, Order> getOrders() {
        return orders;
    }
}
