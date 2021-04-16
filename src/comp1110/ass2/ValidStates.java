package comp1110.ass2;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
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
        boolean[] factoryTiles = new boolean[splitToFac.size()];
        Arrays.fill(factoryTiles, true);
        for (int i = 0; i < splitToFac.size(); i++) {
            if (splitToFac.get(i).charAt(0) >= '0' && splitToFac.get(i).charAt(0) <= '8') {
                for (char c : splitToFac.get(i).substring(1).toCharArray()) {
                    if (!(c >= 'a' && c <= 'e')) {
                        factoryTiles[i] = false;
                    }
                }
            }
            else
                factoryTiles[i]=false;
        }
        int s=0;
        for(boolean f:factoryTiles)
            if(!f)
                s++;
        return s==0;
    }


    public static void main(String[] args) {
        String inP1 = "ThisShouldNotWork";
        String inP2 = "DisShouldWork";
        String inP3 = "F0cddf1bbbe2abde3cdee4bcceCfB1915161614D0000000000";
        String inP4 = "AF0cdde1bbbe2abde3cdee4bcceCfB1915161614D0000000000";
        System.out.println(isValidNextPlayer(inP1));
        System.out.println(isValidNextPlayer(inP2));
        System.out.println(isValidNextPlayer(inP3));
        System.out.println(validFactories(inP3));


    }
}
