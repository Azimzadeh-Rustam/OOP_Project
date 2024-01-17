import java.util.ArrayList;

public class Wizard extends Hero {

    int maxMana, currentMana;

    public Wizard(String name, int x, int y) {
        super(name,
                100,
                100,
                5,
                5,
                new int[]{20, 30},
                x,
                y,
                1);
        maxMana = 100;
        currentMana = maxMana;
    }

    @Override
    public void play(ArrayList<Hero> enemies, ArrayList<Hero> teammates) {
        return;
    }

    @Override
    public String toString() {
        return "Wizard" + super.toString();
    }
}
