import java.util.ArrayList;

public class Crossbower extends Archer{

    public Crossbower(String name, int x, int y) {
        super(name,
                75,
                75,
                2,
                2,
                new int[]{10, 15},
                x,
                y,
                3);
        this.maxArrows = this.currentArrows = 30;
        this.maxRangeDamage = 4;
    }

    @Override
    public String toString() {
        return "Crossbower" + super.toString();
    }
}
