import java.util.ArrayList;

public abstract class Hero {

    protected String name;
    protected int maxHealth, currentHealth, maxArmor, currentArmor;
    protected int[] damage;
    protected Vector2D position;

    public Hero(String name, int maxHealth, int currentHealth, int maxArmor, int currentArmor, int[] damage, int x, int y) {
        this.name = name;
        this.maxHealth = maxHealth;
        this.currentHealth = currentHealth;
        this.maxArmor = maxArmor;
        this.currentArmor = currentArmor;
        this.damage = damage;
        this.position = new Vector2D(x, y);
    }

    public void printDistance(ArrayList<Hero> enemies) {
        enemies.forEach(n->System.out.print(position.getDistance(n.position) + ", "));
    }

    public Hero findNearestEnemy(ArrayList<Hero> enemies) {
        Hero nearestEnemy = enemies.getFirst();
        for (int i = 1; i < enemies.size(); i++) {
            Hero currentEnemy = enemies.get(i);
            if(this.position.getDistance(currentEnemy.position) < this.position.getDistance(nearestEnemy.position)) {
                nearestEnemy = currentEnemy;
            }
        }
        return nearestEnemy;
    }

    public void getDamage(int damage) {
        if (currentArmor > damage) {
            currentArmor = currentArmor - damage;
        } else {
            currentHealth = currentHealth + currentArmor - damage;
        }
    }

    @Override
    public String toString() {
        return "-" + name + ", Health: " + currentHealth + "/" + maxHealth + ", Armor: " + currentArmor + "/" + maxArmor;
    }
}
