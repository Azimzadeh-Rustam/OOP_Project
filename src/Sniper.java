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
                10,
                10,
                15);
    }

    @Override
    public String getInfo() {
        return "Sniper";
    }

    @Override
    public String toString() {
        return "Sniper" + super.toString();
    }
}
