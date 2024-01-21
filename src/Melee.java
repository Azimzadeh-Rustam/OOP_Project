import java.util.ArrayList;
import java.util.Random;

public class Melee extends Hero {

    protected int maxRangeAttack;

    public Melee(String name, int maxHealth, int health, int maxArmor, int armor, int[] damage, int x, int y, int initiative, int maxRangeAttack) {
        super(name, maxHealth, health, maxArmor, armor, damage, x, y, initiative);
        this.maxRangeAttack = maxRangeAttack;
    }

    @Override
    public String getInfo() {
        return null;
    }

    @Override
    public void attack(Hero enemy) {
        Random random = new Random();
        enemy.receiveDamage(random.nextInt(damage[0],damage[1]));
    }

    public Vector2D takeStep(Hero hero) {
        int step = 1;
        Vector2D deltas = position.getDeltas(hero.position);
        Vector2D nextPosition = new Vector2D(position.getX(), position.getY());

        int deltaX = deltas.getX();
        int deltaY = deltas.getY();

        if (deltaX < 0) {
            nextPosition.setX(nextPosition.getX() + step);
        } else if (deltaX > 0) {
            nextPosition.setX(nextPosition.getX() - step);
        } else if (deltaY < 0) {
            nextPosition.setY(nextPosition.getY() + step);
        } else if (deltaY > 0) {
            nextPosition.setY(nextPosition.getY() - step);
        }

        return nextPosition;
    }

    @Override
    public void play(ArrayList<Hero> enemies, ArrayList<Hero> teammates) {

        if (this.isDead()) return;
        Hero nearestEnemy = nearestAlive(enemies);
        if(nearestEnemy == null) return;
        if (position.getDistance(nearestEnemy) < maxRangeAttack) {
            attack(nearestEnemy);
        } else {
            Vector2D nextPosition = takeStep(nearestEnemy);
            boolean stepIsFree = true;
            for (Hero teammate : teammates) {
                if (nextPosition.equals(teammate.position)) stepIsFree = false;
            }
            if (stepIsFree) position = nextPosition;
        }

    }

}
