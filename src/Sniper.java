public class Sniper extends Archer {
    public Sniper(String name, int x, int y) {
        super(name,
                75,
                75,
                5,
                5,
                new int[]{20, 30},
                x,
                y);
        this.maxArrows = this.currentArrows = 30;
    }

    @Override
    public String toString() {
        return "Sniper" + super.toString();
    }
}
