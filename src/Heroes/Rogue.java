package Heroes;
import TypesOfHero.Melee;

public class Rogue extends Melee {
    public Rogue(String name, int x, int y) {
        super(name,
                100,
                100,
                50,
                50,
                new int[]{20, 30},
                x,
                y,
                2,
                2);
    }

    @Override
    public String getType() {
        return "Rogue";
    }

    @Override
    public String toString() {
        return "Rogue" + super.toString();
    }
}
