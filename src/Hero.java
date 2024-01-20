import java.util.ArrayList;

public abstract class Hero implements Game {

    protected String name;
    protected float maxHealth, health, maxArmor, armor;
    protected int[] damage;
    protected Vector2D position;

    protected int initiative;

    public Hero(String name, int maxHealth, int health, int maxArmor, int armor, int[] damage, int x, int y, int initiative) {
        this.name = name;
        this.maxHealth = maxHealth;
        this.health = health;
        this.maxArmor = maxArmor;
        this.armor = armor;
        this.damage = damage;
        this.position = new Vector2D(x, y);
        this.initiative = initiative;
    }

    public String getName() {return name;}

    public float getMaxHealth() {return maxHealth;}

    public float getHealth() {return health;}

    public float getMaxArmor() {return maxArmor;}

    public float getArmor() {return armor;}

    public int[] getPosition() {
        return new int[]{position.x, position.y};
    }

    public int getInitiative() {return initiative;}

    public abstract String getInfo();

    protected void printDistance(ArrayList<Hero> enemies) {
        enemies.forEach(n->System.out.print(position.getDistance(n) + ", "));
    }

    protected Hero nearestAlive(ArrayList<Hero> heroes) {
        int i;
        Hero currentEnemy, nearestAliveEnemy = null;
        int enemiesSize = heroes.size();

        for (i = 0; i < enemiesSize; i++) {
            currentEnemy = heroes.get(i);
            if (currentEnemy.health > 0) {
                nearestAliveEnemy = currentEnemy;
                break;
            }
        }

        for (int j = i + 1; j < enemiesSize; j++) {
            currentEnemy = heroes.get(j);
            if(currentEnemy.health > 0) {
                assert nearestAliveEnemy != null;
                if (position.getDistance(currentEnemy) < position.getDistance(nearestAliveEnemy)) {
                    nearestAliveEnemy = currentEnemy;
                }
            }
        }

        return nearestAliveEnemy;
    }

    protected void receiveDamage(float damage) {
        if (damage < armor) {
            armor -= damage;
        } else {
            health -= (damage - armor);
            armor = 0;
        }

        if (health < 0) health = 0;
    }

    protected void receiveHealing(float healPoint) {
        health += healPoint;
    }

    public void attack(Hero enemy) {}

    public void play(ArrayList<Hero> enemies, ArrayList<Hero> teammates) {}

    @Override
    public String toString() {
        return "-" + name + " => Health: " + health + "/" + maxHealth + ", Armor: " + armor + "/" + maxArmor + ", Coords: (" + position.x + ", " + position.y + ")";
    }
}
