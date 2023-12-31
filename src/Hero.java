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

    public Hero findNearestEnemy(ArrayList<Hero> enemies) {
        Hero nearestEnemy = enemies.getFirst();
        for (int i = 1; i < enemies.size(); i++) {
            if(position.getDistance(enemies.get(i).position) < position.getDistance(nearestEnemy.position)) {
                nearestEnemy = enemies.get(i);
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
}
