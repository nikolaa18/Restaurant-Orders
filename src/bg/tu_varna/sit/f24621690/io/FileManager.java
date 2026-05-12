package bg.tu_varna.sit.f24621690.io;

import bg.tu_varna.sit.f24621690.base.*;
import bg.tu_varna.sit.f24621690.enums.ItemCategory;
import bg.tu_varna.sit.f24621690.enums.TableAvailability;

import java.io.*;

public class FileManager {
    private String currentFile;

    public void save(String path) throws IOException {
        try (PrintWriter out = new PrintWriter(new FileWriter(path))) {
            for (MenuItem item : Menu.getInstance().getItems().values()) {
                out.println("ITEM," + item.getId() + "," + item.getName() + "," +
                        item.getItemCategory() + "," + item.getPrice() + "," + item.getQuantity());
            }
            for (Table table : Restaurant.getInstance().getTables().values()) {
                out.println("TABLE," + table.getNumber() + "," + table.getSeats() + "," + table.getAvailability());
            }
            System.out.println("Data successfully saved.");
        }
    }

    public void open(String filename) throws Exception {
        File file = new File(filename);
        if (!file.exists()) {
            file.createNewFile();
            System.out.println("Created new empty file: " + filename);
            this.currentFile = filename;
            return;
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
            System.out.println("Successfully loaded data from " + filename);
        } catch (IOException | IllegalArgumentException e) {
            throw new Exception("Error reading file: " + e.getMessage());
        }
    }

    public String getCurrentFile() {
        return currentFile;
    }
}