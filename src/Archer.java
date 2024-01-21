import java.util.ArrayList;
import java.util.Random;

public abstract class Archer extends Hero {

    protected int maxArrows, arrows, maxRangeShoot;

    public Archer(String name, int maxHealth, int currentHealth, int maxArmor, int currentArmor, int[] damage, int x, int y, int initiative, int maxArrows, int arrows, int maxRangeShoot) {
        super(name, maxHealth, currentHealth, maxArmor, currentArmor, damage, x, y, initiative);
        this.maxArrows = maxArrows;
        this.arrows = arrows;
        this.maxRangeShoot = maxRangeShoot;
    }

    protected void receiveArrows(int newArrows) {
        arrows += newArrows;
    }

    @Override
    public void attack(Hero enemy) {
        arrows -= 1;

        Random random = new Random();
        int damagePoint = position.getDistance(enemy) < maxRangeShoot ? random.nextInt(damage[0],damage[1]) : damage[0];
        enemy.receiveDamage(damagePoint);
    }

    @Override
    public void play(ArrayList<Hero> enemies, ArrayList<Hero> teammates) {

        if (this.isDead() || arrows == 0) return;
        Hero nearestEnemy = nearestAlive(enemies);
        if (nearestEnemy == null) return;
        if (position.getDistance(nearestEnemy) < maxRangeShoot) {
            attack(nearestEnemy);
        }
    }

    @Override
    public String toString() {
        return super.toString() + ", Arrows: " + arrows + "/" + maxArrows;
    }
}
