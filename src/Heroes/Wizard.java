package Heroes;
import TypesOfHero.Healer;

public class Wizard extends Healer {

    public Wizard(String name, int x, int y) {
        super(name,
                100,
                100,
                5,
                5,
                new int[]{20, 30},
                x,
                y,
                1,
                5,
                2,
                100,
                100,
                7);
    }

    @Override
    public String getType() {
        return "Wizard";
    }

    @Override
    public String toString() {
        return "Wizard" + super.toString();
    }
}
