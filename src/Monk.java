import java.util.ArrayList;

public class Monk extends Hero {
    public Monk(String name, int x, int y) {
        super(name,
                50,
                50,
                0,
                0,
                new int[]{-10, -15},
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
        return "Monk" + super.toString();
    }
}
