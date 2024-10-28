
public class Plant extends Organizm {
    private int height;
    private String color;
    public Plant(String name, String species, int age, int height, String color) {
        super(name, species, age);
        this.height = height;
        this.color = color;
    }

    @Override
    public void interact() {
        System.out.println(this.name + "растение");
    }

    public int getHeight() {
        return height;
    }
    public String getColor() {
        return color;
    }
}
