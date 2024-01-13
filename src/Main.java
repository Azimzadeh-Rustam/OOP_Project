import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;

public class Main {
    public static void main(String[] args) {

        int left = 0;
        int right = 9;

        teamWhite = generateHeroes(0, left);
        teamBlack = generateHeroes(3, right);

        sortedTeam.addAll(teamWhite);
        sortedTeam.addAll(teamBlack);
        sortedTeam.sort((o1, o2)->o2.getInitiative()-o1.getInitiative());

        System.out.println("\n********* Heroes White **********");
        teamWhite.forEach(n->System.out.println(n.toString()));
        System.out.println("\n********* Heroes Black **********");
        teamBlack.forEach(n->System.out.println(n.toString()));
        //heroesBlack.forEach(n->n.printDistance(heroesWhite));

        System.out.println("\n********* FIGHT **********");

        for (Hero hero : sortedTeam) {
            if (teamBlack.contains(hero)) {
                hero.step(teamWhite);
            } else {
                hero.step(teamWhite);
            }
        }

        System.out.println("\n********* Heroes White **********");
        teamWhite.forEach(n->System.out.println(n.toString()));
        System.out.println("\n********* Heroes Black **********");
        teamBlack.forEach(n->System.out.println(n.toString()));
    }
    static ArrayList<Hero>teamWhite = new ArrayList<>();
    static ArrayList<Hero>teamBlack = new ArrayList<>();
    static ArrayList<Hero> sortedTeam = new ArrayList<>();

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
