public abstract class Organizm {
    protected String name;
    protected String species;
    protected int age;

    public Organizm(String name, String species, int age) {
        this.name = name;
        this.species = species;
        this.age = age;
    }

    public String getName() {
        return name;
    }
    public String getSpecies(){return  species;}

    public int getAge() {
        return age;
    }

    public abstract void interact();
    @Override
    public String toString(){
        return "Organism{name='" + name + "', age=" + age + "}";
    }

}
