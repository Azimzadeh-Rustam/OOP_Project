import java.util.ArrayList;

public abstract class Hero implements Game {

    protected String name;
    protected float maxHealth, currentHealth, maxArmor, currentArmor;
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

    public float getMaxHealth() {return maxHealth;}

    public float getCurrentHealth() {return currentHealth;}

    public float getMaxArmor() {return maxArmor;}

    public float getCurrentArmor() {return currentArmor;}

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

    protected void getDamage(float damage) {
        if (damage < currentArmor) {
            currentArmor -= damage;
        } else {
            currentHealth += currentArmor - damage;
        }

        if (currentHealth < 0) currentHealth = 0;
    }

    public void attack(Hero enemy) {}

    public void play(ArrayList<Hero> enemies, ArrayList<Hero> teammates) {}

    @Override
    public String toString() {
        return "-" + name + " => Health: " + currentHealth + "/" + maxHealth + ", Armor: " + currentArmor + "/" + maxArmor;
    }
}
