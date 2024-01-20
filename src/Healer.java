import java.util.ArrayList;

public abstract class Healer extends Hero {

    protected float healPoint;

    public Healer(String name, int maxHealth, int health, int maxArmor, int armor, int[] damage, int x, int y, int initiative, float healPoint) {
        super(name, maxHealth, health, maxArmor, armor, damage, x, y, initiative);
        this.healPoint = healPoint;
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

        if (health == 0) return;
        Hero nearestTeammate = nearestAlive(teammates);
        if(nearestTeammate == null) return;

        if ( (position.getDistance(nearestTeammate) < 2) && (nearestTeammate.health < nearestTeammate.maxHealth - healPoint)) {
            heal(nearestTeammate);
        }
    }
}
