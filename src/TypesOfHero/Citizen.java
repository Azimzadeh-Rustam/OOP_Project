package TypesOfHero;

public class Citizen extends Hero {

    protected boolean isBusy;

    public Citizen(String name, int maxHealth, int health, int maxArmor, int armor, int[] damage, int x, int y, int initiative, boolean isBusy) {
        super(name, maxHealth, health, maxArmor, armor, damage, x, y, initiative);
        this.isBusy = isBusy;
    }

    public void giveArrows (Archer hero) {
        hero.receiveArrows(3);
    }

    public boolean isBusy() {return isBusy;}
    public void setStatus(boolean status) {isBusy = status;}

    @Override
    public String getType() { return null;}

    @Override
    public String toString() {
        return super.toString() + ", Busy: " + (isBusy? "yes" : "no");
    }
}
