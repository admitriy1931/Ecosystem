import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //EcosystemScanner.run();



        System.out.println("Hello world!");
        Plant oak = new Plant("Дуб", "дерево", 100, 4, "black");
        System.out.println(oak.getColor());
        System.out.println(oak.getSpecies());
        Animal a = new Animal("белка", "мышь", 2);
        System.out.println(a.getSpecies());
        System.out.println(a.getName());
//        Ecosystem ecosystem = null;
//        ecosystem = Ecosystem.load("МояСимуляция");
//
//        for (Animal animal : ecosystem.getAnimals()) {
//            System.out.println("Животное: " + animal.getName() + ", Возраст: " + animal.getAge());
//        }
//
//        for (Plant pl : ecosystem.getPlants()){
//            System.out.println("Растение: " + pl.getName());
//        }
//        ecosystem.addPlant("Ромашка", 8, 1, "белый");
//        ecosystem.save("2");
//        ecosystem.setResource("Температура", 30);
//        ecosystem.setResource("Влажность", 70);
//        ecosystem.setResource("Вода", 50);
//        ecosystem.addAnimal("Жираф", 5);
//        ecosystem.addPlant("Ежовик", 1, 3,"красный" );
//        ecosystem.save();

    }
}