package Heroes;
import TypesOfHero.Melee;

public class Pikeman extends Melee {
    public Pikeman(String name, int x, int y) {
        super(name,
                100,
                100,
                20,
                20,
                new int[]{20, 30},
                x,
                y,
                2,
                2);
    }

    @Override
    public String getType() {
        return "Pikeman";
    }

    @Override
    public String toString() {
        return "Pikeman" + super.toString();
    }
}
