package bg.tu_varna.sit.f24621690.base;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * Клас (Singleton), централно хранилище за всички маси и поръчки в системата.
 */
public class Restaurant {
    /** Единствената инстанция на ресторанта */
    private static Restaurant instance;

    /** Колекция от всички маси в ресторанта, достъпни по техния номер. */
    private Map<Integer, Table> tables;

    /** Колекция от всички поръчки в ресторанта, достъпни по тяхното ID. */
    private Map<String, Order> orders;

    /**
     * Частен конструктор, предотвратяващ директно директно инстанциране от други класове.
     * Инициализира празните колекции за маси и поръчки.
     */
    private Restaurant() {
        this.tables = new HashMap<>();
        this.orders = new HashMap<>();
    }

    /**
     * Връща единствената споделена инстанция на класа Restaurant в приложението.
     * Методът реализира шаблона за дизайн Singleton и служи за централна
     * точка, от която всички команди и фабрики достъпват текущото състояние на
     * ресторанта (всички маси и активни поръчки). Гарантира, че промените по
     * заетостта на масите се отразяват на едно единствено място в паметта.
     *
     * @return Единствената инстанция на класа Restaurant, координираща
     * състоянието на масите и хронологията на поръчките.
     */
    public static Restaurant getInstance() {
        if(instance == null) {
            instance = new Restaurant();
        }
        return instance;
    }

    /**
     * Връща списъка с всички маси.
     * @return Map колекция от маси.
     */
    public Map<Integer, Table> getTables() {
        return tables;
    }

    /**
     * Връща списъка с всички поръчки.
     * @return Map колекция от поръчки.
     */
    public Map<String, Order> getOrders() {
        return orders;
    }
}
