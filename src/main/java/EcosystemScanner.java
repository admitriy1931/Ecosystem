import java.util.Scanner;

public class EcosystemScanner {
    public static void run(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Добро пожаловать в симулятор экосистемы!");
        Ecosystem ecosystem = null;

        while (true) {
            System.out.println("\nВыберите действие:");
            System.out.println("1. Создать новую экосистему");
            System.out.println("2. Загрузить экосистему");
            System.out.println("3. Выйти");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1" -> {
                    // Создание новой экосистемы
                    System.out.print("Введите имя экосистемы: ");
                    String ecosystemName = scanner.nextLine();
                    ecosystem = new Ecosystem(ecosystemName);
                    manageEcosystem(scanner, ecosystem);
                }
                case "2" -> {
                    // Загрузка экосистемы
                    System.out.print("Введите имя экосистемы для загрузки: ");
                    String loadName = scanner.nextLine();
                    try {
                        ecosystem = Ecosystem.load(loadName);
                        System.out.println("Экосистема загружена: " + ecosystem.getName());
                        manageEcosystem(scanner, ecosystem);
                    } catch (Exception e) {
                        System.err.println("Ошибка при загрузке экосистемы: " + e.getMessage());
                    }
                }
                case "3" -> {
                    // Выход из приложения
                    System.out.println("Выход из программы.");
                    return;
                }
                default -> System.out.println("Неверный выбор. Пожалуйста, попробуйте еще раз.");
            }
        }
    }
    private static void manageEcosystem(Scanner scanner, Ecosystem ecosystem) {
        while (true) {
            System.out.println("Нажмите 'm' для возврата в главное меню.");
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("m")) {
                break; // Возврат в главное меню
            }
        }
    }
}
