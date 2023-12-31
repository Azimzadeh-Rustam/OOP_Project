import java.util.ArrayList;

public abstract class Hero {
    protected int maxHealth, currentHealth, maxArmor, currentArmor;
    protected Vector2 position;
    protected int[] damage;
    protected String name;

    public Hero(String name, int maxHealth, int currentHealth, int maxArmor, int currentArmor, int[] damage, int x, int y) {
        this.name = name;
        this.maxHealth = maxHealth;
        this.currentHealth = currentHealth;
        this.maxArmor = maxArmor;
        this.currentArmor = currentArmor;
        this.damage = damage;
        this.position = new Vector2(x, y);
    }

    public void printDistance(ArrayList<Hero> enemies) {
        enemies.forEach(n->System.out.print(position.getDistance(n.position) + ", "));
    }
}
