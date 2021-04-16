package comp1110.ass2;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.Predicate;

public class ValidStates {
    /**
     * Checks if the Turn element in the shared state is valid
     * @param in
     * @return true if The first element is 'A' - 'D' or 'F' <p> false otherwise </p>
     */
    public static boolean isValidNextPlayer(String in) {
        Predicate pred = x -> x.toString().charAt(0) >= 'A' && x.toString().charAt(0) <= 'D'
                || x.toString().charAt(0) == 'F';
        if (pred.test(in))
            return true;
        else
            return false;
    }

    /**
     * Split the factory tiles into their constituent factories for use further use
     * @param in
     * @return Return the String Array representing the contents of each factory tile
     */
    public static ArrayList<String> splitToFactories(String in) {
        ArrayList<String> retArray = new ArrayList<>();
        if (isValidNextPlayer(in) && in.startsWith("F")) {
            for (int i = 1; !in.substring(i, i + 5).contains("C"); i += 5) {
                retArray.add(in.substring(i, i + 5));
            }
        } else if (isValidNextPlayer(in) && !in.startsWith("F")) {
            for (int i = 2; !in.substring(i, i + 5).contains("C"); i += 5) {
                retArray.add(in.substring(i, i + 5));
            }
        }
        return retArray;
    }

    /**
     * Check if the representation of the factory tiles is valid
     * @param in
     * @return true if all factory representations are valid,<p> false when atleast one is invalid</p>
     */
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
            } else
                factoryTiles[i] = false;
        }
        int s = 0;
        for (boolean f : factoryTiles)
            if (!f)
                s++;
        return s == 0;
    }

    /**
     * Get the index of 'C'
     * @param in
     * @return the index of 'C' in the Shared string
     */
    public static int getCenterIdentifier(String in) {
        int nFac = splitToFactories(in).size();
        boolean isFirstTurn = in.charAt(0) == ('F');
        if (isFirstTurn)
            return (nFac * 5) + 1;
        else
            return (nFac * 5) + 2;
    }

    /**
     * Get all the elemets of the center tiles as strings
     * @param in
     * @return valid tiles are encoded as is <p> invalid tiles are encoded as Z</p>
     */
    public static String getCenterTiles(String in) {
        String AllBag = in.substring(getCenterIdentifier(in));
        String retString = new String();
        for (int i = 1; AllBag.charAt(i) != 'B'; i++) {
            if (AllBag.charAt(i) >= 'a' && AllBag.charAt(i) <= 'f')
                retString += AllBag.charAt(i);
            else
                retString += "Z";
        }
        return retString;
    }
    public static int getBagIdentifier(String in){
         = getCenterIdentifier(in) + getCenterTiles(in).length();
    }

    public static void main(String[] args) {

        String inP4 = "AF1bbbe2abde3cdee4bcceCgfB1915161614D0000000000";
        System.out.println(validFactories(inP4));
        System.out.println(getCenterIdentifier(inP4));
        System.out.println(getCenterTiles(inP4));
    }
}
