import javax.print.DocFlavor;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        int left = 1;
        int right = 10;
        boolean whoWon;

        Scanner input = new Scanner(System.in);

        teamBlue = generateHeroes(0, left);
        teamGreen = generateHeroes(3, right);

        allSortedTeam.addAll(teamBlue);
        allSortedTeam.addAll(teamGreen);
        allSortedTeam.sort((o1, o2)->o2.getInitiative()-o1.getInitiative());

        while (true) {
            View.view();
            if (allDead(teamBlue)) {
                whoWon = true;
                break;
            }
            if (allDead(teamGreen)) {
                whoWon = false;
                break;
            }
            input.nextLine();
            for (Hero hero : allSortedTeam) {
                if (teamGreen.contains(hero)) {
                    hero.play(teamBlue, teamGreen);
                } else {
                    hero.play(teamGreen, teamBlue);
                }
            }
        }
        System.out.println((whoWon? "Green team" : "Blue team") + " won");
    }

    public static ArrayList<Hero> teamBlue = new ArrayList<>();
    public static ArrayList<Hero> teamGreen = new ArrayList<>();
    public static ArrayList<Hero> allSortedTeam = new ArrayList<>();

    static ArrayList<Hero> generateHeroes(int amount, int x) {
        Random random = new Random();
        ArrayList<Hero> heroes = new ArrayList<>();

        for (int i = 1; i < 11; i++) {
            switch(random.nextInt(1,5) + amount) {
                case 1:
                    heroes.add(new Crossbowman(getName(), x, i));
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

    static boolean allDead(ArrayList<Hero> team) {

        for (Hero hero : team) {
            if (hero.health > 0) return false;
        }

        return true;
    }

    static String getName() {
        return NameOfHeroes.values()[new Random().nextInt(NameOfHeroes.values().length - 1)].name();
    }
}
