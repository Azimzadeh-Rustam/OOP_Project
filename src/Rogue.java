public class Rogue extends Hero {
    public Rogue(String name, int x, int y) {
        super(name,
                100,
                100,
                50,
                50,
                new int[]{20, 30},
                x,
                y);
    }

    @Override
    public String toString() {
        return "Rogue" + super.toString();
    }
}
