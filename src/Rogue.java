import java.util.ArrayList;

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
                2);
    }

    @Override
    public void play(ArrayList<Hero> enemies, ArrayList<Hero> teammates) {
        return;
    }

    @Override
    public String toString() {
        return "Rogue" + super.toString();
    }
}
