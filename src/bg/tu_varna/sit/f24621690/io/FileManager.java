package bg.tu_varna.sit.f24621690.io;

import bg.tu_varna.sit.f24621690.base.*;
import java.io.*;
import java.util.Map;

public class FileManager {
    private String currentFilePath;

    public void save(String path) throws IOException {
        try (PrintWriter out = new PrintWriter(new FileWriter(path))) {
            for (MenuItem item : Menu.getInstance().getItems().values()) {
                out.println("ITEM," + item.getId() + "," + item.getName() + "," +
                        item.getItemCategory() + "," + item.getPrice() + "," + item.getQuantity());
            }
            for (Table table : Restaurant.getInstance().getTables().values()) {
                out.println("TABLE," + table.getNumber() + "," + table.getSeats());
            }
            this.currentFilePath = path;
            System.out.println("Successfully saved to " + path);
        }
    }

    public void open(String path) throws Exception {
        File file = new File(path);
        if (!file.exists()) {
            file.createNewFile();
            System.out.println("Created new empty file.");
            return;
        }

        this.currentFilePath = path;
        System.out.println("Successfully opened " + path);
    }

    public String getCurrentFilePath() {
        return currentFilePath;
    }
}