import java.util.ArrayList;

public abstract class Healer extends Hero {

    protected float healPoint;
    protected int maxRangeHeal;

    public Healer(String name, int maxHealth, int health, int maxArmor, int armor, int[] damage, int x, int y, int initiative, float healPoint, int maxRangeHeal) {
        super(name, maxHealth, health, maxArmor, armor, damage, x, y, initiative);
        this.healPoint = healPoint;
        this.maxRangeHeal = maxRangeHeal;
    }

    public void heal (Hero teammate) {
        teammate.receiveHealing(healPoint);
    }

    @Override
    public String getInfo() {
        return null;
    }

    @Override
    public void play(ArrayList<Hero> enemies, ArrayList<Hero> teammates) {

        if (this.isDead()) return;
        Hero nearestTeammate = nearestAlive(teammates);
        if(nearestTeammate == null) return;

        if ( (position.getDistance(nearestTeammate) < maxRangeHeal) && (nearestTeammate.health < nearestTeammate.maxHealth - healPoint)) {
            heal(nearestTeammate);
        }
    }
}
