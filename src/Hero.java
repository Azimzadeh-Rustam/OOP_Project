import java.util.ArrayList;

public abstract class Hero implements Game {

    protected String name;
    protected float maxHealth, health, maxArmor, armor;
    protected int[] damage;
    protected Vector2D position;

    protected int initiative;

    public Hero(String name, int maxHealth, int health, int maxArmor, int armor, int[] damage, int x, int y, int initiative) {
        this.name = name;
        this.maxHealth = maxHealth;
        this.health = health;
        this.maxArmor = maxArmor;
        this.armor = armor;
        this.damage = damage;
        this.position = new Vector2D(x, y);
        this.initiative = initiative;
    }

    public abstract String getType();
    public String getName() {return name;}
    public float getMaxHealth() {return maxHealth;}
    public float getHealth() {return health;}
    public float getMaxArmor() {return maxArmor;}
    public float getArmor() {return armor;}
    public int[] getPosition() {
        return new int[]{position.x, position.y};
    }
    public int getInitiative() {return initiative;}

    public boolean isDead() {
        return health == 0;
    }

    protected Vector2D nextPosition(Hero hero) {
        int step = 1;
        Vector2D deltas = position.getDeltas(hero);
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
        Hero currentHero, nearestHero = null;
        int teamSize = heroes.size();
        int i;
        boolean isAlive;
        boolean isWounded;

        for (i = 0; i < teamSize; i++) {
            currentHero = heroes.get(i);

            isAlive = currentHero.health > 0;
            isWounded = currentHero.health < currentHero.maxHealth * 0.4;

            if ( (status == "alive" && isAlive) || (status == "dead" && !isAlive) || (status == "wounded" && isWounded) ) {
                if (type == "any" || type == currentHero.getType()) {
                    nearestHero = currentHero;
                    break;
                }
            }
        }

        if (nearestHero != null) {
            for (int j = i + 1; j < teamSize; j++) {
                currentHero = heroes.get(j);

                isAlive = currentHero.health > 0;
                isWounded = currentHero.health < currentHero.maxHealth * 0.4;

                if ( (status == "alive" && isAlive) || (status == "dead" && !isAlive) || (status == "wounded" && isWounded) ) {
                    if (type == "any" || type == currentHero.getType()) {
                        if (position.getDistance(currentHero) < position.getDistance(nearestHero)) {
                            nearestHero = currentHero;
                        }
                    }
                }
            }
        }

        return nearestHero;
    }


    protected void receiveDamage(float damage) {
        if (damage < armor) {
            armor -= damage;
            return;
        }

        health -= (damage - armor);
        armor = 0;
        if (health < 0) health = 0;
    }

    protected void receiveHealing(float healPoint) {
        health += healPoint;
        if (health > maxHealth) health = maxHealth;
    }

    public void attack(Hero enemy) {}

    public void play(ArrayList<Hero> enemies, ArrayList<Hero> teammates) {}

    @Override
    public String toString() {
        return "-" + name + " => Health: " + health + "/" + maxHealth + ", Armor: " + armor + "/" + maxArmor + ", Coords: (" + position.x + ", " + position.y + ")";
    }
}
