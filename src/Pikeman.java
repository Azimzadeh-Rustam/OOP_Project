import java.util.ArrayList;

public class Pikeman extends Hero {
    public Pikeman(String name, int x, int y) {
        super(name,
                100,
                100,
                5,
                5,
                new int[]{20, 30},
                x,
                y,
                2);
    }

    @Override
    public void step(ArrayList<Hero> enemies) {
        return;
    }

    @Override
    public String toString() {
        return "Pikeman" + super.toString();
    }
}
