import java.util.ArrayList;
import java.util.Random;

public class Melee extends Hero {

    public Melee(String name, int maxHealth, int currentHealth, int maxArmor, int currentArmor, int[] damage, int x, int y, int initiative) {
        super(name, maxHealth, currentHealth, maxArmor, currentArmor, damage, x, y, initiative);
    }

    public Vector2D takeStep(Hero enemy) {
        int step = 1;
        Vector2D deltas = position.getDeltas(enemy.position);
        Vector2D nextPosition = new Vector2D(position.getX(), position.getY());

        if (deltas.getX() > 0) {
            nextPosition.setX(nextPosition.getX() + step);
        } else if (deltas.getX() < 0) {
            nextPosition.setX(nextPosition.getX() - step);
        } else if (deltas.getY() > 0) {
            nextPosition.setY(nextPosition.getY() + step);
        } else if (deltas.getY() < 0) {
            nextPosition.setY(nextPosition.getY() - step);
        }

        return nextPosition;
    }

    @Override
    public void attack(Hero enemy) {
        Random random = new Random();
        enemy.getDamage(random.nextInt(damage[0],damage[1]));
    }

    @Override
    public void play(ArrayList<Hero> enemies, ArrayList<Hero> teammates) {

        if (currentHealth == 0) return;

        Hero nearestEnemy = nearestAlive(enemies);
        if (position.getDistance(nearestEnemy.position) < 2) {
            attack(nearestEnemy);
        } else {
            Vector2D nextPosition = takeStep(nearestEnemy);
            boolean stepIsFree = true;
            for (Hero teammate : teammates) {
                if (nextPosition.equals(teammate.position)) stepIsFree = false;
            }
            if(stepIsFree) position = nextPosition;
        }

    }

}
