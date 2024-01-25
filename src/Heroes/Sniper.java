package Heroes;
import TypesOfHero.Archer;

public class Sniper extends Archer {
    public Sniper(String name, int x, int y) {
        super(name,
                75,
                75,
                10,
                10,
                new int[]{25, 35},
                x,
                y,
                3,
                7,
                7,
                15,
                10,
                2);
    }

    @Override
    public String getType() {
        return "Sniper";
    }

    @Override
    public String toString() {
        return "Sniper" + super.toString();
    }
}
