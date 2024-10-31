import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EcosystemScanner {
    private static List<String> availableEcosystems = new ArrayList<>();

    public static void run() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Симулятор экосистемы");
        loadAvailableEcosystems();

        while (true) {
            System.out.println("\nВыберите действие:");
            System.out.println("1. Создать новую экосистему");
            System.out.println("2. Загрузить экосистему");
            System.out.println("3. Посмотреть доступные экосистемы");
            System.out.println("4. Выйти");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1" -> {
                    System.out.print("Введите имя экосистемы: ");
                    String ecosystemName = scanner.nextLine().trim() + ".txt";

                    if (!availableEcosystems.contains(ecosystemName)) {
                        Ecosystem ecosystem = new Ecosystem(ecosystemName.replace(".txt", ""));
                        System.out.print("Введите емкость: ");
                        int capacity = Integer.parseInt(scanner.nextLine());
                        ecosystem.setResource("Емкость", capacity);
                        System.out.print("Введите доступность ресурсов (например, 1 для полной доступности): ");
                        int resourceAvailability = Integer.parseInt(scanner.nextLine());
                        ecosystem.setResource("Доступность ресурсов", resourceAvailability);
                        availableEcosystems.add(ecosystemName);
                        manageEcosystem(scanner, ecosystem);
                    } else {
                        System.out.println("Экосистема с таким именем уже существует.");
                    }
                }
                case "2" -> {
                    if (availableEcosystems.isEmpty()) {
                        System.out.println("Нет доступных экосистем для загрузки.");
                        break;
                    }
                    System.out.println("Выберите экосистему для загрузки:");
                    for (int i = 0; i < availableEcosystems.size(); i++) {
                        System.out.println((i + 1) + ". " + availableEcosystems.get(i));
                    }
                    int index = Integer.parseInt(scanner.nextLine()) - 1;
                    if (index >= 0 && index < availableEcosystems.size()) {
                        String loadName = availableEcosystems.get(index).replace(".txt", "");
                        try {
                            Ecosystem ecosystem = Ecosystem.load(loadName);
                            System.out.println("Экосистема загружена: " + ecosystem.getName());
                            manageEcosystem(scanner, ecosystem);
                        } catch (Exception e) {
                            System.err.println("Ошибка при загрузке экосистемы: " + e.getMessage());
                        }
                    } else {
                        System.out.println("Неверный выбор.");
                    }
                }
                case "3" -> {
                    if (availableEcosystems.isEmpty()) {
                        System.out.println("Нет доступных экосистем.");
                    } else {
                        System.out.println("Доступные экосистемы:");
                        availableEcosystems.forEach(System.out::println);
                    }
                }
                case "4" -> {
                    System.out.println("Выход из программы.");
                    return;
                }
                default -> System.out.println("Неверный ввод");
            }
        }
    }

    private static void loadAvailableEcosystems() {
        File directory = new File(".");
        File[] files = directory.listFiles((dir, name) -> name.endsWith(".txt"));
        if (files != null) {
            for (File file : files) {
                availableEcosystems.add(file.getName());
            }
        }
    }

    private static void manageEcosystem(Scanner scanner, Ecosystem ecosystem) {
        while (true) {
            System.out.println("\nВыберите действие:");
            System.out.println("1. Добавить растение");
            System.out.println("2. Добавить животное");
            System.out.println("3. Посмотреть ресурсы");
            System.out.println("4. Посмотреть растения");
            System.out.println("5. Посмотреть животных");
            System.out.println("6. Сохранить экосистему");
            System.out.println("7. Предсказать число особей");
            System.out.println("Нажмите 'm' для возврата в главное меню.");

            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("m")) {
                break;
            }

            switch (input) {
                case "1" -> {
                    System.out.print("Введите название вида растения: ");
                    String species = scanner.nextLine();
                    System.out.print("Введите скорость репродукции (от 0 до 1): ");
                    double growthRate = Double.parseDouble(scanner.nextLine());
                    System.out.print("Введите начальный размер популяции: ");
                    int initialCapacity = Integer.parseInt(scanner.nextLine());
                    ecosystem.addPlant(species, growthRate, initialCapacity);
                    System.out.println("Растение добавлено.");
                }
                case "2" -> {
                    System.out.print("Введите название вида животного: ");
                    String species = scanner.nextLine();
                    System.out.print("Введите скорость репродукции (от 0 до 1): ");
                    double growthRate = Double.parseDouble(scanner.nextLine());
                    System.out.print("Введите начальный размер популяции: ");
                    int initialCapacity = Integer.parseInt(scanner.nextLine());
                    System.out.print("Введите количество самцов: ");
                    int males = Integer.parseInt(scanner.nextLine());
                    System.out.print("Введите количество самок: ");
                    int females = Integer.parseInt(scanner.nextLine());
                    ecosystem.addAnimal(species, growthRate, initialCapacity, males, females);
                    System.out.println("Животное добавлено.");
                }
                case "3" -> {
                    System.out.println("Ресурсы экосистемы:");
                    ecosystem.getResources().forEach((key, value) -> {
                        System.out.println(key + ": " + value);
                    });
                }
                case "4" -> {
                    System.out.println("Растения в экосистеме:");
                    for (Plant plant : ecosystem.getPlants()) {
                        System.out.println("Вид: " + plant.getSpecies() +
                                ", Скорость репродукции: " + plant.getGrowthRate() +
                                ", Начальный размер популяции: " + plant.getInitialCapacity());
                    }
                }
                case "5" -> {
                    System.out.println("Животные в экосистеме:");
                    for (Animal animal : ecosystem.getAnimals()) {
                        System.out.println("Вид: " + animal.getSpecies() +
                                ", Скорость репродукции: " + animal.getGrowthRate() +
                                ", Начальный размер популяции: " + animal.getInitialCapacity() +
                                ", Самцы: " + animal.getMale() +
                                ", Самки: " + animal.getFemale());
                    }
                }
                case "6" -> {
                    String fileName = ecosystem.getName();
                    ecosystem.save(fileName);
                    System.out.println("Экосистема сохранена в " + fileName + ".txt.");
                }
                case "7" -> {
                    System.out.println("Введите название вида: ");
                    String species = scanner.nextLine();
                    System.out.println("Введите t: ");
                    int time = Integer.parseInt(scanner.nextLine());
                    for (Plant plant : ecosystem.getPlants()) {
                        if (plant.getSpecies().equals(species)) {
                            System.out.println("Предсказанное число особей для вида " + species + ": " + ecosystem.getPrediction(species, time));
                        }
                    }
                    for (Animal animal : ecosystem.getAnimals()) {
                        if (animal.getSpecies().equals(species)) {
                            System.out.println("Предсказанное число особей " + species + ": " + ecosystem.getPrediction(species, time));
                        }
                    }

                    System.out.println("Вид " + species + " не найден в экосистеме.");
                }
                default -> System.out.println("Неверный выбор. Пожалуйста, попробуйте еще раз.");
            }
        }
    }
}