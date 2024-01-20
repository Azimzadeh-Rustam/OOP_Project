public class Crossbowman extends Archer{

    public Crossbowman(String name, int x, int y) {
        super(name,
                75,
                75,
                25,
                25,
                new int[]{10, 15},
                x,
                y,
                3,
                30,
                30,
                7);
    }

    @Override
    public String getInfo() {
        return "Crossbowman";
    }

    @Override
    public String toString() {
        return "Crossbowman" + super.toString();
    }
}
