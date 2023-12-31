import java.util.ArrayList;

public class Crossbower extends Hero {
    private ArrayList<Hero> enemies;

    public Crossbower(String name, int x, int y, ArrayList<Hero> enemies) {
        super(name,
                75,
                75,
                2,
                2,
                new int[]{10, 15},
                x,
                y);
        this.maxArrows = 10;
        this.currentArrows = maxArrows;
        this.enemies = enemies;
    }

    int maxArrows, currentArrows;

    @Override
    public String toString() {
        return "Crossbower" + "-" + name + ", Health: " + currentHealth + "/" + maxHealth + ", Armor: " + currentArmor + "/" + maxArmor + ", Arrows: " + currentArrows + "/" + maxArrows;
    }

    public void attack() {
        Hero nerestEnemy = findNearestEnemy(enemies);
        nerestEnemy.getDamage(damage[1]);
    }
}
