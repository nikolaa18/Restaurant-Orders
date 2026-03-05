package bg.tu_varna.sit.f24621690;

import java.util.HashMap;
import java.util.Map;

public class Menu {
    private final String name;
    private Map<Integer, MenuItem> items;

    public Menu(String name) {
        this.name = name;
        this.items = new HashMap<>();
    }
}
