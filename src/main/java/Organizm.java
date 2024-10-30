public abstract class Organizm {
    protected String species;
    protected double growthRate;
    protected int initialCapacity;

    public Organizm(String species, double growthRate, int initialCapacity) {
        this.species = species;
        this.growthRate = growthRate;
        this.initialCapacity = initialCapacity;
    }

    public String getSpecies() {
        return species;
    }
    public double getGrowthRate(){return growthRate;}
    public int getInitialCapacity() {
        return initialCapacity;
    }


}
