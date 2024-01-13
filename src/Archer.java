import java.util.ArrayList;
import java.util.Random;

public abstract class Archer extends Hero{

    protected int maxArrows, currentArrows;

    public Archer(String name, int maxHealth, int currentHealth, int maxArmor, int currentArmor, int[] damage, int x, int y, int initiative) {
        super(name, maxHealth, currentHealth, maxArmor, currentArmor, damage, x, y, initiative);
    }

    protected void attack(Hero enemy) {
        currentArrows -= 1;
        Random random = new Random();
        enemy.getDamage(random.nextInt(damage[0],damage[1]));
    }

    protected void getArrows(int newArrows) {
        return;
    }

    @Override
    public void step(ArrayList<Hero> enemies) {
        if (currentHealth > 0 && currentArrows > 0) {
            Hero nearestEnemy = findNearestAliveEnemy(enemies);
            attack(nearestEnemy);
        } else {
            return;
        }
    }

    @Override
    public String toString() {
        return super.toString() + ", Arrows: " + currentArrows + "/" + maxArrows;
    }
}
