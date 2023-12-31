public class Sniper extends Hero {
    public Sniper(String name, int x, int y) {
        super(name,
                75,
                75,
                5,
                5,
                new int[]{20, 30},
                x,
                y);
    }

    @Override
    public String toString() {
        return "Sniper" + "-" + name + ", Health: " + currentHealth + "/" + maxHealth + ", Armor: " + currentArmor + "/" + maxArmor;
    }
}
