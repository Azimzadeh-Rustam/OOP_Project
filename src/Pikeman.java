import java.util.ArrayList;

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
                2);
    }

    @Override
    public void play(ArrayList<Hero> enemies, ArrayList<Hero> teammates) {
        return;
    }

    @Override
    public String toString() {
        return "Pikeman" + super.toString();
    }
}
