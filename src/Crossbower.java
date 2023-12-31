import java.util.ArrayList;

public class Crossbower extends Hero {
    public Crossbower(String name, int x, int y) {
        super(name,
                75,
                75,
                2,
                2,
                new int[]{10, 15},
                x,
                y);
        maxArrows = 10;
        currentArrows = maxArrows;
    }

    int maxArrows, currentArrows;

    @Override
    public String toString() {
        return "Crossbower" + "-" + name + ", Health: " + currentHealth + "/" + maxHealth + ", Armor: " + currentArmor + "/" + maxArmor + ", Arrows: " + currentArrows + "/" + maxArrows;
    }
}
