public class Animal extends Organizm{
    public int male;
    public int female;
    public Animal(String species, double growthRate, int initialCapacity, int male, int female) {
        super(species, growthRate, initialCapacity);
        this.male = male;
        this.female = female;
    }
    public int getCount() {
        return male + female;
    }
    public int getMale(){
        return male;
    }
    public int getFemale(){
        return female;
    }


}
