package Main;
import TypesOfHero.Hero;
import java.util.ArrayList;

public interface Game {
    void play(ArrayList<Hero> enemies, ArrayList<Hero> teammates);
    String getType();
}
