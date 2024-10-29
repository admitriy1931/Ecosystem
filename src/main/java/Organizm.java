public abstract class Organizm {
    protected String species;
    protected double growthRate;
    protected double carryingCapacity;

    public Organizm(String species, double growthRate, double carryingCapacity) {
        this.species = species;
        this.growthRate = growthRate;
        this.carryingCapacity = carryingCapacity;
    }

    public String getSpecies() {
        return species;
    }
    public double getGrowthRate(){return growthRate;}
    public double getCarryingCapacity() {
        return carryingCapacity;
    }


}
