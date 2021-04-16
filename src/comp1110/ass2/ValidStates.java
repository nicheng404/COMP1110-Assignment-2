package comp1110.ass2;

import java.util.ArrayList;
import java.util.function.Predicate;

public class ValidStates {
    public static boolean isValidNextPlayer(String in) {
        Predicate pred = x -> x.toString().charAt(0) >= 'A' && x.toString().charAt(0) <= 'D'
                || x.toString().charAt(0) == 'F';
        if (pred.test(in))
            return true;
        else
            return false;
    }

    public static ArrayList<String> splitToFactories(String in) {
        ArrayList<String> retArray = new ArrayList<>();
        if (isValidNextPlayer(in) && in.startsWith("F")) {
            for (int i = 1; !in.substring(i, i + 5).contains("C"); i += 5) {
                retArray.add(in.substring(i, i + 5));
            }
        } else if (isValidNextPlayer(in) && !in.startsWith("F")) {
            for (int i = 2; !in.substring(i, i + 6).contains("C"); i += 5) {
                retArray.add(in.substring(i, i + 6));
            }
        }
        return retArray;
    }

    public static boolean validFactories(String in) {
        ArrayList<String> splitToFac = splitToFactories(in);
        int fCounter = 0;
        for (String s : splitToFac) {
            if (s.charAt(0) >= '0' && s.charAt(0) <= '8') {
                for (char c : s.substring(1).toCharArray())
                    if (!(c >= 'a' && c <= 'e'))
                        fCounter++;
            }
        }
        return fCounter==0;
    }


    public static void main(String[] args) {
        String inP1 = "ThisShouldNotWork";
        String inP2 = "DisShouldWork";
        String inP3 = "F0cddf1bbbe2abde3cdee4bcceCfB1915161614D0000000000";
        System.out.println(isValidNextPlayer(inP1));
        System.out.println(isValidNextPlayer(inP2));
        System.out.println(inP1.substring(1));
        System.out.println(isValidNextPlayer(inP3));
        System.out.println();

    }
}
