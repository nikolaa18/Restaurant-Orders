package bg.tu_varna.sit.f24621690.io;

import bg.tu_varna.sit.f24621690.base.*;
import bg.tu_varna.sit.f24621690.enums.ItemCategory;
import bg.tu_varna.sit.f24621690.enums.TableAvailability;
import java.io.*;

/**
 * Клас (Singleton), отговарящ за операциите по четене и запис на данни във файловата система.
 * Управлява състоянието на текущо отворения файл.
 */
public class FileManager {

    /** Единствената споделена инстанция на класа FileManager. */
    private static FileManager instance;

    /** Името на текущо отворения файл. */
    private String currentFile;

    /**
     * Частен конструктор за предотвратяване на директно инстанциране от други класове.
     */
    private FileManager() {}

    /**
     * Връща единствената споделена инстанция на FileManager.
     * @return Инстанцията на класа FileManager.
     */
    public static FileManager getInstance() {
        if (instance == null) {
            instance = new FileManager();
        }
        return instance;
    }

    /**
     * Записва текущото състояние на данните в посочения файл.
     * @param path Пътят към файла за запис.
     * @return Съобщение за успешен запис.
     * @throws IOException При проблем с достъпа до файловата система.
     */
    public String save(String path) throws IOException {
        try (PrintWriter out = new PrintWriter(new FileWriter(path))) {
            for (MenuItem item : Menu.getInstance().getItems().values()) {
                out.println("ITEM," + item.getId() + "," + item.getName() + "," +
                        item.getItemCategory() + "," + item.getPrice() + "," + item.getQuantity());
            }
            for (Table table : Restaurant.getInstance().getTables().values()) {
                out.println("TABLE," + table.getNumber() + "," + table.getSeats() + "," + table.getAvailability());
            }
            return "Data successfully saved to " + path;
        }
    }

    /**
     * Отваря и прочита данните от посочения текстов файл, като ги зарежда в работната памет на системата.
     * <p>
     * Този метод реализира логиката за десериализация на данните. Той работи по следния алгоритъм:
     * 1. Проверява дали файлът съществува. Ако не, създава нов празен файл и го маркира като текущ.
     * 2. Ако съществува, го чете ред по ред.
     * 3. Според първия елемент на всеки ред ("ITEM" или "TABLE"), методът парсва останалите стойности
     * и възстановява обектите от тип {@link MenuItem} и {@link Table}.
     * 4. Създадените обекти се записват директно в централните Singleton хранилища (Menu и Restaurant).
     * </p>
     *
     * @param filename Името (или пътят) на файла, който потребителят иска да отвори.
     * @return Текстово съобщение, което информира дали е създаден нов файл или са заредени съществуващи данни.
     * @throws Exception Хвърля общо изключение в два случая:
     * 1) При хардуерен/системен проблем с файла (IOException).
     * 2) Ако данните във файла са повредени или в невалиден формат
     * (напр. текст вместо число или несъществуваща категория) (IllegalArgumentException).
     */
    public String open(String filename) throws Exception {
        File file = new File(filename);
        if (!file.exists()) {
            file.createNewFile();
            this.currentFile = filename;
            return "Created new empty file: " + filename;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                String type = parts[0];

                if (type.equals("ITEM")) {
                    MenuItem item = new MenuItem(
                            parts[1],
                            parts[2],
                            ItemCategory.valueOf(parts[3]),
                            Double.parseDouble(parts[4]),
                            Integer.parseInt(parts[5])
                    );
                    Menu.getInstance().getItems().put(item.getId(), item);
                } else if (type.equals("TABLE")) {
                    Table table = new Table(Integer.parseInt(parts[1]), Integer.parseInt(parts[2]));
                    table.setAvailability(TableAvailability.valueOf(parts[3]));
                    Restaurant.getInstance().getTables().put(table.getNumber(), table);
                }
            }
            this.currentFile = filename;
            return "Successfully loaded data from " + filename;
        } catch (IOException | IllegalArgumentException e) {
            throw new Exception("Error reading file: " + e.getMessage());
        }
    }

    /**
     * Затваря текущия файл и изчиства паметта на приложението.
     * @return Съобщение за успешно затваряне.
     * @throws Exception Ако няма текущо отворен файл.
     */
    public String close() throws Exception {
        if (this.currentFile == null) {
            throw new Exception("There is no active file to close.");
        }

        Menu.getInstance().getItems().clear();
        Restaurant.getInstance().getTables().clear();
        Restaurant.getInstance().getOrders().clear();

        String successMessage = "Successfully closed " + this.currentFile;
        this.currentFile = null;
        return successMessage;
    }

    /**
     * Връща името на текущо отворения файл.
     * @return Името на текущия файл или null, ако няма зареден файл.
     */
    public String getCurrentFile() {
        return currentFile;
    }
}