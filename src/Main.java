import java.util.ArrayList;
import java.util.Random;

public class Main {
    public static void main(String[] args) {

        heroesWhite = generateHeroes(0);
        heroesBlack = generateHeroes(3);

        System.out.println("\n********* Heroes White **********");
        heroesWhite.forEach(n->System.out.println(n.toString()));
        System.out.println("\n********* Heroes Black **********");
        heroesBlack.forEach(n->System.out.println(n.toString()));
    }
    static ArrayList<Hero>heroesWhite = new ArrayList<>();
    static ArrayList<Hero>heroesBlack = new ArrayList<>();

    static ArrayList<Hero> generateHeroes(int amount) {
        Random random = new Random();
        ArrayList<Hero> heroes = new ArrayList<>();
        for(int i = 0; i < 10; i++) {
            switch(random.nextInt(1,5) + amount) {
                case 1:
                    heroes.add(new Crossbower(getName()));
                    break;
                case 2:
                    heroes.add(new Monk(getName()));
                    break;
                case 3:
                    heroes.add(new Pikeman(getName()));
                    break;
                case 4:
                    heroes.add(new Peasant(getName()));
                    break;
                case 5:
                    heroes.add(new Rogue(getName()));
                    break;
                case 6:
                    heroes.add(new Sniper(getName()));
                    break;
                case 7:
                    heroes.add(new Wizard(getName()));
                    break;
            }
        }

        return heroes;
    }

    static String getName() {
        return NameOfHeroes.values()[new Random().nextInt(NameOfHeroes.values().length - 1)].name();
    }
}
