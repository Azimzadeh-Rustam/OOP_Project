public class Wizard extends Hero {
    public Wizard(String name) {
        super(name,
                100,
                100,
                5,
                5,
                new int[]{20, 30});
        maxMana = 100;
        currentMana = maxMana;
    }

    int maxMana, currentMana;

    @Override
    public String toString() {
        return "Wizard" + "-" + name + ", Health: " + currentHealth + "/" + maxHealth + ", Armor: " + currentArmor + "/" + maxArmor + ", Mana: " + currentMana + "/" + maxMana;
    }
}
