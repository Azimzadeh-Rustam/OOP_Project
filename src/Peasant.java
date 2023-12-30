public class Peasant extends Hero {
    public Peasant(String name) {
        super(name,
                100,
                100,
                0,
                0,
                new int[]{0, 0});
    }

    @Override
    public String toString() {
        return "Peasant" + "-" + name + ", Health: " + currentHealth + "/" + maxHealth + ", Armor: " + currentArmor + "/" + maxArmor;
    }
}
