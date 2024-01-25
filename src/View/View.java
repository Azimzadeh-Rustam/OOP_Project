package View;
import Main.*;
import TypesOfHero.Hero;

import java.util.Collections;

public class View {
    private static int step = 0;
    private static int l = 0;
    private static final String top10 = formatDiv("a") + String.join("", Collections.nCopies(9, formatDiv("-b"))) + formatDiv("-c");
    private static final String midl10 = formatDiv("d") + String.join("", Collections.nCopies(9, formatDiv("-e"))) + formatDiv("-f");
    private static final String bottom10 = formatDiv("g") + String.join("", Collections.nCopies(9, formatDiv("-h"))) + formatDiv("-i");
    private static void tabSetter(int cnt, int max){
        int dif = max - cnt + 2;
        if (dif>0) System.out.printf("%" + dif + "s", ":\t"); else System.out.print(":\t");
    }
    private static String formatDiv(String str) {
        return str.replace('a', '\u250c')
                .replace('b', '\u252c')
                .replace('c', '\u2510')
                .replace('d', '\u251c')
                .replace('e', '\u253c')
                .replace('f', '\u2524')
                .replace('g', '\u2514')
                .replace('h', '\u2534')
                .replace('i', '\u2518')
                .replace('-', '\u2500');
    }
    private static String getChar(int x, int y){
        String out = "| ";
        for (Hero hero : Main.allSortedTeam) {
            if (hero.getPosition().getX() == x && hero.getPosition().getY() == y){
                if (hero.getHealth() == 0) {
                    out = "|" + (AnsiColors.ANSI_RED + hero.getType().charAt(0) + AnsiColors.ANSI_RESET);
                    break;
                }
                if (Main.teamGreen.contains(hero)) out = "|" + (AnsiColors.ANSI_GREEN + hero.getType().charAt(0) + AnsiColors.ANSI_RESET);
                if (Main.teamBlue.contains(hero)) out = "|" + (AnsiColors.ANSI_BLUE + hero.getType().charAt(0) + AnsiColors.ANSI_RESET);
                break;
            }
        }
        return out;
    }
    public static void view() {
        if (step == 0){
            System.out.print(AnsiColors.ANSI_RED + "FIGHT" + AnsiColors.ANSI_RESET);
        } else {
            System.out.print(AnsiColors.ANSI_RED + "Step:" + step + AnsiColors.ANSI_RESET);
        }
        step++;
        Main.allSortedTeam.forEach((v) -> l = Math.max(l, v.toString().length()));
        System.out.print("_".repeat(l*2));
        System.out.println();
        System.out.print(top10 + "    ");
        System.out.print("Blue team");
        //for (int i = 0; i < l[0]-9; i++)
        System.out.print(" ".repeat(l-9));
        System.out.println(":\tGreen team");
        for (int i = 1; i < 11; i++) {
            System.out.print(getChar(1, i));
        }
        System.out.print("|    ");
        System.out.print(Main.teamBlue.getFirst());
        tabSetter(Main.teamBlue.getFirst().toString().length(), l);
        System.out.println(Main.teamGreen.getFirst());
        System.out.println(midl10);

        for (int i = 2; i < 10; i++) {
            for (int j = 1; j < 11; j++) {
                System.out.print(getChar(i, j));
            }
            System.out.print("|    ");
            System.out.print(Main.teamBlue.get(i-1));
            tabSetter(Main.teamBlue.get(i-1).toString().length(), l);
            System.out.println(Main.teamGreen.get(i-1));
            System.out.println(midl10);
        }
        for (int j = 1; j < 11; j++) {
            System.out.print(getChar(10, j));
        }
        System.out.print("|    ");
        System.out.print(Main.teamBlue.get(9));
        tabSetter(Main.teamBlue.get(9).toString().length(), l);
        System.out.println(Main.teamGreen.get(9));
        System.out.println(bottom10);
    }
}
