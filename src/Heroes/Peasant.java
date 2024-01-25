package Heroes;
import TypesOfHero.Citizen;

public class Peasant extends Citizen {
    public Peasant(String name, int x, int y) {
        super(name,
                100,
                100,
                0,
                0,
                new int[]{0, 0},
                x,
                y,
                0,
                false);
    }

    @Override
    public String getType() {
        return "Peasant";
    }

    @Override
    public String toString() {
        return "Peasant" + super.toString();
    }
}
