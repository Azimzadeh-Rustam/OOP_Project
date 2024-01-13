import java.util.ArrayList;
import java.util.Random;

public abstract class Archer extends Hero{

    protected int maxArrows, currentArrows;

    public Archer(String name, int maxHealth, int currentHealth, int maxArmor, int currentArmor, int[] damage, int x, int y) {
        super(name, maxHealth, currentHealth, maxArmor, currentArmor, damage, x, y);
    }

    public void attack(Hero enemy) {
        Random random = new Random();
        enemy.getDamage(random.nextInt(damage[1],damage[2]));
    }

    public void getArrows(int newArrows) {

    }

    @Override
    public String toString() {
        return "-" + name + "=> Health: " + currentHealth + "/" + maxHealth + ", Armor: " + currentArmor + "/" + maxArmor + "Arrows: " + currentArrows + "/" + maxArrows;
    }
}
