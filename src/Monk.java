public class Monk extends Hero {
    public Monk(String name) {
        super(name,
                50,
                50,
                0,
                0,
                new int[]{-10, -15});
    }

    @Override
    public String toString() {
        return "Monk" + "-" + name + ", Health: " + currentHealth + "/" + maxHealth + ", Armor: " + currentArmor + "/" + maxArmor;
    }
}
