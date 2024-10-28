public class Animal extends Organizm{
    public Animal(String name, String species, int age) {
        super(name, species, age);
    }
    @Override
    public void interact() {
        System.out.println(this.name + "животное");
    }
    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }
}
