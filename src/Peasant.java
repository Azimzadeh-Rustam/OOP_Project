public class Peasant extends Hero {
    public Peasant(String name, int x, int y) {
        super(name,
                100,
                100,
                0,
                0,
                new int[]{0, 0},
                x,
                y);
    }

    @Override
    public String toString() {
        return "Peasant" + super.toString();
    }
}
