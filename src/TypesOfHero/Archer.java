package TypesOfHero;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;

public abstract class Archer extends Hero {

    protected int maxArrows, arrows, maxRangeShoot, meleeDamage, maxRangeAttack;

    protected Archer(String name, int maxHealth, int health, int maxArmor, int armor, int[] damage, int x, int y, int initiative, int maxArrows, int arrows, int maxRangeShoot, int meleeDamage, int maxRangeAttack) {
        super(name, maxHealth, health, maxArmor, armor, damage, x, y, initiative);
        this.maxArrows = maxArrows;
        this.arrows = arrows;
        this.maxRangeShoot = maxRangeShoot;
        this.meleeDamage = meleeDamage;
        this.maxRangeAttack = maxRangeAttack;
    }

    protected Citizen nearestFreeCitizen(ArrayList<Hero> teammates) {
        Citizen nearestFreeCitizen = null;

        for (Hero teammate : teammates) {
            if (    teammate.health > 0 &&
                    Objects.equals(teammate.getType(), "Peasant") &&
                    !((Citizen) teammate).getIsBusy() ) {

                if (    nearestFreeCitizen == null ||
                        position.getDistance(teammate) < position.getDistance(nearestFreeCitizen) ) {

                    nearestFreeCitizen = (Citizen) teammate;
                }
            }
        }

        return nearestFreeCitizen;
    }

    public void receiveArrows(int newArrows) {
        arrows += newArrows;
    }

    protected void shoot(Hero enemy) {
        arrows -= 1;

        Random random = new Random();
        int damagePoint = position.getDistance(enemy) < maxRangeShoot ? random.nextInt(damage[0], damage[1]) : damage[0];
        enemy.receiveDamage(damagePoint);
    }

    @Override
    public void attack(Hero enemy) {
        enemy.receiveDamage(meleeDamage);
    }

    @Override
    public void play(ArrayList<Hero> enemies, ArrayList<Hero> teammates) {

        if (this.isDead()) return;

        Hero nearestEnemy = nearest(enemies, "alive", "any");

        if (nearestEnemy == null) return;

        int CRITICAL_AMOUNT_SNIPER_ARROWS = 3;
        int CRITICAL_AMOUNT_CROSSBOWMAN_ARROWS = 7;
        int criticalArrows = (Objects.equals(getType(), "Sniper") ? CRITICAL_AMOUNT_SNIPER_ARROWS : CRITICAL_AMOUNT_CROSSBOWMAN_ARROWS);
        if (arrows < criticalArrows) {
            Citizen nearestFreePeasant = nearestFreeCitizen(teammates);
            if (nearestFreePeasant != null) {
                nearestFreePeasant.bringArrows(this, teammates);
            }
        }

        double distanceToNearestEnemy = position.getDistance(nearestEnemy);

        if (arrows == 0) {
            if (distanceToNearestEnemy < maxRangeAttack) {
                attack(nearestEnemy);
            }
            else {
                moveToward(nearestEnemy, teammates);
            }
            return;
        }

        if (distanceToNearestEnemy < maxRangeShoot) {
            shoot(nearestEnemy);
            return;
        }

        moveToward(nearestEnemy, teammates);
    }

    @Override
    public String toString() {
        return super.toString() + ", Arrows: " + arrows + "/" + maxArrows;
    }
}
