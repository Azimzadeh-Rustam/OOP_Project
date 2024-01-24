import java.util.ArrayList;
import java.util.Random;

public class Melee extends Hero {

    protected int maxRangeAttack;

    public Melee(String name, int maxHealth, int health, int maxArmor, int armor, int[] damage, int x, int y, int initiative, int maxRangeAttack) {
        super(name, maxHealth, health, maxArmor, armor, damage, x, y, initiative);
        this.maxRangeAttack = maxRangeAttack;
    }

    @Override
    public String getType() {
        return null;
    }

    @Override
    public void attack(Hero enemy) {
        Random random = new Random();
        enemy.receiveDamage(random.nextInt(damage[0],damage[1]));
    }

    @Override
    public void play(ArrayList<Hero> enemies, ArrayList<Hero> teammates) {

        if (this.isDead()) return;

        Hero nearestAliveEnemy = nearest(enemies, "alive", "any");

        if (nearestAliveEnemy == null) return;

        if (position.getDistance(nearestAliveEnemy) < maxRangeAttack) {
            attack(nearestAliveEnemy);
            return;
        }

        Vector2D nextPosition = nextPosition(nearestAliveEnemy);
        boolean stepIsFree = true;
        for (Hero teammate : teammates) {
            if (nextPosition.equals(teammate.position)) {
                stepIsFree = false;
                break;
            }
        }
        if (stepIsFree) position = nextPosition;
    }
}
