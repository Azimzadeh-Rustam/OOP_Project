import java.util.ArrayList;
import java.util.Random;

public class Main {
    public static void main(String[] args) {

        int left = 0;
        int right = 9;

        heroesWhite = generateHeroes(0, left);
        heroesBlack = generateHeroes(3, right);

        System.out.println("\n********* Heroes White **********");
        heroesWhite.forEach(n->System.out.println(n.toString()));
        System.out.println("\n********* Heroes Black **********");
        heroesBlack.forEach(n->System.out.println(n.toString()));
        heroesBlack.forEach(n->n.printDistance(heroesWhite));
    }
    static ArrayList<Hero>heroesWhite = new ArrayList<>();
    static ArrayList<Hero>heroesBlack = new ArrayList<>();

    static ArrayList<Hero> generateHeroes(int amount, int x) {
        Random random = new Random();
        ArrayList<Hero> heroes = new ArrayList<>();

        for(int i = 0; i < 10; i++) {
            switch(random.nextInt(1,5) + amount) {
                case 1:
                    heroes.add(new Crossbower(getName(), x, i));
                    break;
                case 2:
                    heroes.add(new Monk(getName(), x, i));
                    break;
                case 3:
                    heroes.add(new Pikeman(getName(), x, i));
                    break;
                case 4:
                    heroes.add(new Peasant(getName(), x, i));
                    break;
                case 5:
                    heroes.add(new Rogue(getName(), x, i));
                    break;
                case 6:
                    heroes.add(new Sniper(getName(), x, i));
                    break;
                case 7:
                    heroes.add(new Wizard(getName(), x, i));
                    break;
            }
        }

        return heroes;
    }

    static String getName() {
        return NameOfHeroes.values()[new Random().nextInt(NameOfHeroes.values().length - 1)].name();
    }
}
