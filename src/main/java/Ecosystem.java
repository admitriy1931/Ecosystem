import java.util.*;
public class Ecosystem {
    private String name;
    private List<Plant> plants;
    private List<Animal> animals;
    private Map<String, Integer> resources;
    public Ecosystem(String name) {
        this.name = name;
        this.plants = new ArrayList<>();
        this.animals = new ArrayList<>();
        this.resources = new HashMap<>();
        initializeResources();
    }

    private void initializeResources() {
        resources.put("Температура", 25);
        resources.put("Площадь экосистемы", 60);
        resources.put("Вода", 100);
    }
    public void setResource(String resourceName, int value) {
        if (resources.containsKey(resourceName)) {
            resources.put(resourceName, value);
        } else {
            System.out.println("Ресурс \"" + resourceName + "\" не найден.");
        }
    }

    public void save(String fileName) {
        List<String> data = new ArrayList<>();
        data.add("Ресурсы:");
        for (Map.Entry<String, Integer> entry : resources.entrySet()) {
            data.add(entry.getKey() + ": " + entry.getValue());
        }

        data.add("\nРастения:");
        for (Plant plant : plants) {
            data.add(plant.getSpecies() + ": " + plant.getCarryingCapacity() + ": " + plant.getGrowthRate());
        }

        data.add("\nЖивотные:");
        for (Animal animal : animals) {
            data.add(animal.getSpecies() + ": " + animal.getCarryingCapacity() + ": " + animal.getGrowthRate() + ":" + animal.getMale() + ":" + animal.getFemale());
        }

        FileHandler.writeToFile(fileName + ".txt", data);
    }
    public static Ecosystem load(String name) {
        Ecosystem ecosystem = new Ecosystem(name);
        List<String> data = FileHandler.readFromFile(name + ".txt");

        String currentSection = "";
        for (String line : data) {
            if (line.startsWith("Ресурсы:")) {
                currentSection = "resources";
            } else if (line.startsWith("Растения:")) {
                currentSection = "plants";
            } else if (line.startsWith("Животные:")) {
                currentSection = "animals";
            } else {
                String[] parts = line.split(": ");
                if (parts.length < 2) {
                    continue;  // Пропустить некорректные строки
                }
                switch (currentSection) {
                    case "resources" -> {
                        ecosystem.resources.put(parts[0], Integer.parseInt(parts[1]));
                    }
                    case "plants" -> {
                        if (parts.length == 3) { // Ожидаем 4 части: Имя, Количество, Цвет, Доп. параметр
                            ecosystem.plants.add(new Plant(parts[0], Double.parseDouble(parts[1]), Double.parseDouble(parts[1])));
                        } else {
                            System.err.println("Неверный формат растения: " + line);
                        }
                    }
                    case "animals" -> {
                        if (parts.length == 5) { // Ожидаем 2 части: Имя, Количество
                            ecosystem.animals.add(new Animal(parts[0], Double.parseDouble(parts[1]), Double.parseDouble(parts[2]), Integer.parseInt(parts[3]), Integer.parseInt(parts[4])));
                        } else {
                            System.err.println("Неверный формат животного: " + line);
                        }
                    }
                }
            }
        }

        return ecosystem;
    }


    public void addPlant(String species, double growthRate, double carryingCapacity) {
        plants.add(new Plant(species, growthRate, carryingCapacity));
    }

    public void addAnimal(String species, double growthRate, double carryingCapacity, int m, int f) {
        animals.add(new Animal(species, growthRate, carryingCapacity, m, f));
    }

    public List<Plant> getPlants() {
        return plants;
    }

    public List<Animal> getAnimals() {
        return animals;
    }

    public Map<String, Integer> getResources() {
        return resources;
    }

    public String getName() {
        return name;
    }

 
}
