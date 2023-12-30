public abstract class Hero {
    protected int maxHealth, currentHealth, maxArmor, currentArmor;
    protected int[] damage;
    protected String name;

    public Hero(String name, int maxHealth, int currentHealth, int maxArmor, int currentArmor, int[] damage) {
        this.name = name;
        this.maxHealth = maxHealth;
        this.currentHealth = currentHealth;
        this.maxArmor = maxArmor;
        this.currentArmor = currentArmor;
        this.damage = damage;
    }
}
