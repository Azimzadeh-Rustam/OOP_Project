import java.util.ArrayList;

public abstract class Healer extends Hero {

    protected int healPoint, maxRangeHeal, mana, maxMana, manaRecovery;

    public Healer(String name, int maxHealth, int health, int maxArmor, int armor, int[] damage, int x, int y, int initiative, int healPoint, int maxRangeHeal, int mana, int maxMana, int manaRecovery) {
        super(name, maxHealth, health, maxArmor, armor, damage, x, y, initiative);
        this.healPoint = healPoint;
        this.maxRangeHeal = maxRangeHeal;
        this.mana = mana;
        this.maxMana = maxMana;
        this.manaRecovery = manaRecovery;
    }

    protected void regenerateMana() {
        mana += manaRecovery;
        if(mana > maxMana) mana = maxMana;
    }

    protected boolean canHeal(Hero teammate) {
        double distance = position.getDistance(teammate);
        return (distance < maxRangeHeal) && (teammate.health < teammate.maxHealth - healPoint);
    }

    protected void heal (Hero teammate) {
        teammate.receiveHealing(healPoint);
        mana -= healPoint;
    }

    protected boolean isAllMeleeDead(ArrayList<Hero> teammates) {

        String infantryType = this.getType() == "Monk" ? "Pikeman" : "Rogue";
        boolean isAnyInfantry = false;

        for (Hero teammate : teammates) {
            if (teammate.getType() == infantryType) {
                isAnyInfantry = true;

                if (teammate.health > 0) {
                    return false;
                }
            }
        }
        return isAnyInfantry;
    }

    protected void resurrect(Hero teammate) {
        teammate.receiveHealing(teammate.maxHealth);
        mana -= (int) teammate.maxHealth;
    }

    protected void helpNearestDeadMelee(ArrayList<Hero> teammates) {

        String infantryType = this.getType() == "Monk" ? "Pikeman" : "Rogue";

        Hero nearestDeadInfantryman = nearest(teammates, "dead", infantryType);

        double distanceToNearestDeadInfantryman = position.getDistance(nearestDeadInfantryman);

        if (distanceToNearestDeadInfantryman < maxRangeHeal) {
            if (mana >= nearestDeadInfantryman.maxHealth) {
                resurrect(nearestDeadInfantryman);
                return;
            }
            return;
        }

        Vector2D nextPosition = nextPosition(nearestDeadInfantryman);
        boolean stepIsFree = true;
        for (Hero teammate : teammates) {
            if (nextPosition.equals(teammate.position)) {
                stepIsFree = false;
                break;
            }
        }
        if (stepIsFree) position = nextPosition;
    }

    @Override
    public String getType() {
        return null;
    }

    @Override
    public void play(ArrayList<Hero> enemies, ArrayList<Hero> teammates) {

        if (this.isDead()) return;

        if (isAllMeleeDead(teammates)) {
            helpNearestDeadMelee(teammates);
            regenerateMana();
            return;
        }

        Hero nearestAliveTeammate = nearest(teammates, "alive", "any");

        if (canHeal(nearestAliveTeammate)) {
            if (mana >= healPoint) {
                heal(nearestAliveTeammate);
            }            
            regenerateMana();
            return;
        }

        Vector2D nextPosition = nextPosition(nearestAliveTeammate);
        boolean stepIsFree = true;
        for (Hero teammate : teammates) {
            if (nextPosition.equals(teammate.position)) stepIsFree = false;
        }
        if (stepIsFree) position = nextPosition;

        regenerateMana();
    }

    @Override
    public String toString() {
        return super.toString() + ", Mana: " + mana + "/" + maxMana;
    }
}
