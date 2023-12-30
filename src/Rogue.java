public class Rogue extends Hero {
    public Rogue(String name) {
        super(name,
                100,
                100,
                50,
                50,
                new int[]{20, 30});
    }

    @Override
    public String toString() {
        return "Rogue" + "-" + name + ", Health: " + currentHealth + "/" + maxHealth + ", Armor: " + currentArmor + "/" + maxArmor;
    }
}
