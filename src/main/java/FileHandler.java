import java.io.*;
import java.util.*;
public class FileHandler {
    public static void writeToFile(String fileName, List<String> data) {
            // Проверка и создание файла, если он не существует
            File file = new File(fileName);
            try {
                if (file.createNewFile()) {
                    System.out.println("Файл создан: " + fileName);
                } else {
                    System.out.println("Файл уже существует: " + fileName);
                }

                // Запись данных в файл
                try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
                    for (String line : data) {
                        writer.write(line);
                        writer.newLine();
                    }
                }
                System.out.println("Данные успешно записаны в файл: " + fileName);
            } catch (IOException ex) {
                System.err.println("Ошибка записи в файл: " + ex.getMessage());
            }
        }
    public static List<String> readFromFile(String fileName) {
        List<String> data = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                data.add(line);
            }
        } catch (IOException ex) {
            System.err.println("Ошибка при чтении из файла: " + ex.getMessage());
        }
        return data;
    }

}
