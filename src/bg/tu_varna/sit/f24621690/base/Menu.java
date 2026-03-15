package bg.tu_varna.sit.f24621690.base;

import java.util.HashMap;
import java.util.Map;

public class Menu {

    private static Menu instance;
    private Map<Integer, MenuItem> items;

    public Menu() {
        this.items = new HashMap<>();
    }

    //Singleton
    public static Menu getInstance() {
        if(instance == null) {
            instance = new Menu();
        }
        return instance;
    }

    public Map<Integer, MenuItem> getItems() {
        return items;
    }
}
