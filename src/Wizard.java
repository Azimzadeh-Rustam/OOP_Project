public class Wizard extends Hero {
    public Wizard(String name, int x, int y) {
        super(name,
                100,
                100,
                5,
                5,
                new int[]{20, 30},
                x,
                y);
        maxMana = 100;
        currentMana = maxMana;
    }

    int maxMana, currentMana;

    @Override
    public String toString() {
        return "Wizard" + super.toString();
    }
}
