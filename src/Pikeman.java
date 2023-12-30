public class Pikeman extends Hero {
    public Pikeman(String name) {
        super(name,
                100,
                100,
                5,
                5,
                new int[]{20, 30});
    }

    @Override
    public String toString() {
        return "Pikeman" + "-" + name + ", Health: " + currentHealth + "/" + maxHealth + ", Armor: " + currentArmor + "/" + maxArmor;
    }
}
