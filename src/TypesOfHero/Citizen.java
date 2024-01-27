package TypesOfHero;
import java.util.ArrayList;

public class Citizen extends Hero {

    protected boolean isBusy;

    protected Citizen(String name, int maxHealth, int health, int maxArmor, int armor, int[] damage, int x, int y, int initiative, boolean isBusy) {
        super(name, maxHealth, health, maxArmor, armor, damage, x, y, initiative);
        this.isBusy = isBusy;
    }

    protected void giveArrows (Archer hero) {
        int newArrows = (int) ((hero.maxArrows - hero.arrows) * 0.6);
        hero.receiveArrows(newArrows);
    }

    public boolean getIsBusy() {return isBusy;}
    public void setIsBusy(boolean status) {isBusy = status;}

    public void bringArrows(Archer hero, ArrayList<Hero> teammates) {
        setIsBusy(true);
        if (position.getDistance(hero) < 2) {
            giveArrows(hero);
            setIsBusy(false);
        }
        else {
            hero.moveToward(hero, teammates);
        }
    }

    @Override
    public String toString() {
        return super.toString() + ", Busy: " + (isBusy? "yes" : "no");
    }
}
