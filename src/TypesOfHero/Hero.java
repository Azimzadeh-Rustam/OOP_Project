package TypesOfHero;
import Main.*;
import java.util.ArrayList;
import java.util.Objects;

public abstract class Hero implements Game {

    protected String name;
    protected int[] damage;
    protected Vector2D position;
    protected int maxHealth, health, maxArmor, armor, initiative;

    protected Hero(String name, int maxHealth, int health, int maxArmor, int armor, int[] damage, int x, int y, int initiative) {
        this.name = name;
        this.maxHealth = maxHealth;
        this.health = health;
        this.maxArmor = maxArmor;
        this.armor = armor;
        this.damage = damage;
        this.position = new Vector2D(x, y);
        this.initiative = initiative;
    }

    public String getName() {return name;}
    public int getMaxHealth() {return maxHealth;}
    public int getHealth() {return health;}
    public int getMaxArmor() {return maxArmor;}
    public int getArmor() {return armor;}
    public Vector2D getPosition() {return new Vector2D (position.getX(), position.getY());}
    public int getInitiative() {return initiative;}
    public boolean isDead() {
        return health == 0;
    }
    public String getType() {return null;};

    protected Vector2D nextPosition(Hero hero) {
        int step = 1;
        Vector2D deltas = position.getDeltas(hero);
        Vector2D nextPosition = new Vector2D(position.getX(), position.getY());

        int deltaX = deltas.getX();
        int deltaY = deltas.getY();

        if (deltaX < 0) {
            nextPosition.setX(nextPosition.getX() + step);
        }
        else if (deltaX > 0) {
            nextPosition.setX(nextPosition.getX() - step);
        }
        else if (deltaY < 0) {
            nextPosition.setY(nextPosition.getY() + step);
        }
        else if (deltaY > 0) {
            nextPosition.setY(nextPosition.getY() - step);
        }

        return nextPosition;
    }

    protected void moveToward(Hero hero, ArrayList<Hero> teammates) {
        Vector2D nextPosition = nextPosition(hero);
        boolean isStepFree = true;

        for (Hero teammate : teammates) {
            if (nextPosition.equals(teammate.position) && teammate.health > 0) {
                isStepFree = false;
                break;
            }
        }

        if (isStepFree) position = nextPosition;
    }

    protected Hero nearest(ArrayList<Hero> heroes, String status, String type) {
        Hero nearestHero = null;

        for (Hero hero : heroes) {
            boolean isAlive = hero.health > 0;
            boolean isWounded = hero.health < hero.maxHealth * 0.4;

            if (    Objects.equals(status, "alive") && isAlive ||
                    Objects.equals(status, "dead") && !isAlive ||
                    Objects.equals(status, "wounded") && isWounded ) {

                if (    Objects.equals(type, "any") ||
                        Objects.equals(type, hero.getType()) ) {

                    if (    nearestHero == null ||
                            position.getDistance(hero) < position.getDistance(nearestHero)) {
                        nearestHero = hero;
                    }
                }
            }
        }

        return nearestHero;
    }


    protected void receiveDamage(int damage) {
        if (damage < armor) {
            armor -= damage;
            return;
        }

        health -= (damage - armor);
        armor = 0;
        if (health < 0) health = 0;
    }

    protected void receiveHealing(int healPoint) {
        health += healPoint;
        if (health > maxHealth) health = maxHealth;
    }

    protected void attack(Hero enemy) {}

    public void play(ArrayList<Hero> enemies, ArrayList<Hero> teammates) {}

    @Override
    public String toString() {
        return "-" + name + " => Health: " + health + "/" + maxHealth + ", Armor: " + armor + "/" + maxArmor + ", Coords: (" + position.getX() + ", " + position.getY() + ")";
    }
}
