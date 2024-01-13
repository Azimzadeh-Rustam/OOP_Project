import java.util.ArrayList;

public class Sniper extends Archer {
    public Sniper(String name, int x, int y) {
        super(name,
                75,
                75,
                5,
                5,
                new int[]{25, 35},
                x,
                y,
                3);
        this.maxArrows = this.currentArrows = 10;
    }

    @Override
    public String toString() {
        return "Sniper" + super.toString();
    }
}
