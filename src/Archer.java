import java.util.ArrayList;
import java.util.Random;

public abstract class Archer extends Hero{

    protected int maxArrows, currentArrows, maxRangeDamage;

    public Archer(String name, int maxHealth, int currentHealth, int maxArmor, int currentArmor, int[] damage, int x, int y, int initiative) {
        super(name, maxHealth, currentHealth, maxArmor, currentArmor, damage, x, y, initiative);
    }

    protected void getArrows(int newArrows) {
        currentArrows += newArrows;
    }

    @Override
    public void attack(Hero enemy) {
        currentArrows -= 1;

        Random random = new Random();
        int damagePoint = position.getDistance(enemy.position) < maxRangeDamage? random.nextInt(damage[0],damage[1]) : damage[0];
        enemy.getDamage(damagePoint);
    }

    @Override
    public void play(ArrayList<Hero> enemies, ArrayList<Hero> teammates) {

        if (currentHealth == 0 || currentArrows == 0) return;

        Hero nearestEnemy = findNearestAliveEnemy(enemies);
        attack(nearestEnemy);

    }

    @Override
    public String toString() {
        return super.toString() + ", Arrows: " + currentArrows + "/" + maxArrows;
    }
}
