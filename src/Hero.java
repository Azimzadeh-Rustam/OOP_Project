import java.util.ArrayList;

public abstract class Hero implements Game {

    protected String name;
    protected int maxHealth, currentHealth, maxArmor, currentArmor;
    protected int[] damage;
    protected Vector2D position;

    protected int initiative;

    public Hero(String name, int maxHealth, int currentHealth, int maxArmor, int currentArmor, int[] damage, int x, int y, int initiative) {
        this.name = name;
        this.maxHealth = maxHealth;
        this.currentHealth = currentHealth;
        this.maxArmor = maxArmor;
        this.currentArmor = currentArmor;
        this.damage = damage;
        this.position = new Vector2D(x, y);
        this.initiative = initiative;
    }

    public String getName() {return name;}

    public int getMaxHealth() {return maxHealth;}

    public int getCurrentHealth() {return currentHealth;}

    public int getMaxArmor() {return maxArmor;}

    public int getCurrentArmor() {return currentArmor;}

    public int getInitiative() {return initiative;}

    protected void printDistance(ArrayList<Hero> enemies) {
        enemies.forEach(n->System.out.print(position.getDistance(n.position) + ", "));
    }

    protected Hero findNearestAliveEnemy(ArrayList<Hero> enemies) {
        int i;
        Hero currentEnemy, nearestAliveEnemy = null;
        int enemiesNumber = enemies.size();

        for (i = 0; i < enemiesNumber; i++) {
            currentEnemy = enemies.get(i);
            if (currentEnemy.currentHealth > 0) {
                nearestAliveEnemy = currentEnemy;
                break;
            }
        }

        for (int j = i + 1; j < enemiesNumber; j++) {
            currentEnemy = enemies.get(j);
            if(currentEnemy.currentHealth > 0) {
                assert nearestAliveEnemy != null;
                if (position.getDistance(currentEnemy.position) < position.getDistance(nearestAliveEnemy.position)) {
                    nearestAliveEnemy = currentEnemy;
                }
            }
        }
        return nearestAliveEnemy;
    }

    protected void getDamage(int damage) {
        if (currentArmor > damage) {
            currentArmor -= damage;
        } else {
            currentHealth = currentHealth + currentArmor - damage;
        }
    }
/*
    public void die(Hero this) {
        this = null;
    }
*/

    @Override
    public void step(ArrayList<Hero> enemies) {}

    @Override
    public String toString() {
        return "-" + name + " => Health: " + currentHealth + "/" + maxHealth + ", Armor: " + currentArmor + "/" + maxArmor;
    }
}
