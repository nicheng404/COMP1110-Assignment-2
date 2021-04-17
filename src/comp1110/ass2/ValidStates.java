package comp1110.ass2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.Predicate;

public class ValidStates {
    /**
     * Checks if the Turn element in the shared state is valid
     *
     * @param in
     * @return true if The first element is 'A' - 'D' or 'F' <p> false otherwise </p>
     */
    public static boolean isValidNextPlayer(String in) {
        Predicate pred = x -> x.toString().charAt(0) >= 'A' && x.toString().charAt(0) <= 'D'
                || x.toString().charAt(0) == 'F';
        return pred.test(in);
    }

    /**
     * returns the indices of the starting of every factory , as mentioned in the documentation.
     * <p>The last element of the returned ArrayList represent the index of 'C'</p>
     * <p>
     * each factory must begin with an integer from 0-8
     *
     * @param in
     * @return The Indices of the starting of factory as mentioned in [factory] <p>The last element in the array list
     * represents the index of 'C</p>
     */
    public static ArrayList<Integer> findFacAddr(String in) {
        Predicate pred = x -> x.toString().charAt(0) >= '0' && x.toString().charAt(0) <= '8';
        ArrayList<Integer> retVal = new ArrayList<>();
        String Subs = "";
        if (isValidNextPlayer(in) && !in.startsWith("F")) {
            for (int i = 2; in.charAt(i) != 'C'; i++) {
                if (pred.test(in.charAt(i))) {
                    retVal.add(i);
                }
            }
        } else if (isValidNextPlayer(in) && in.startsWith("F")) {
            for (int i = 1; in.charAt(i) != 'C'; i++) {
                if (pred.test(in.charAt(i))) {
                    retVal.add(i);
                }
            }
        }
        for (int i = 0; i < in.length(); i++)
            if (in.charAt(i) == 'C')
                retVal.add(i);

        return retVal;
    }

    /**
     * Check if the lengths of the [factory] elements are 4. <p>In other words, check if each of the factories have
     * exactly 4 elements</p>
     *
     * @param in
     * @return true if all the factories have exactly 4 tiles
     */
    public static boolean validFactoryLengths(String in) {
        ArrayList<Integer> FacAddr = findFacAddr(in);
        boolean[] factoryTiles = new boolean[FacAddr.size() - 1];
        Arrays.fill(factoryTiles, true);
        for (int i = 0; i < FacAddr.size() - 1; i++)
            if (FacAddr.get(i + 1) - FacAddr.get(i) - 1 != 4)
                factoryTiles[i] = false;
        int s = 0;
        for (boolean f : factoryTiles)
            if (!f)
                s++;
        return s == 0;
    }

    /**
     * get the factory tiles from the input, as mentioned in the documentation.
     * <p>The factory tiles are split into List of Arrays, each representing a factory.</p>
     * <p>The first element of each string represent the factory number</p>
     * <p>The next four elements represent the elements present in these factories</p>
     *
     * @param in The input that has to be split
     * @return <p> List of String representing [factory] if number of tiles in all factory = 4 </p> <p> Empty list if the number of in even one factory not 4 </p>
     */
    public static ArrayList<String> FactoryTiles(String in) {
        ArrayList<Integer> facAddr = findFacAddr(in);
        ArrayList<String> facString = new ArrayList<>();
        if (validFactoryLengths(in))
            for (int i = 0; i < facAddr.size() - 1; i++)
                facString.add(in.substring(facAddr.get(i), facAddr.get(i + 1)));
        return facString;
    }

    /**
     * Checks if the give string is sorted. Uses the String library to check if this string us sorted
     *
     * @param substring this nomenclature because this method will be used in another method
     * @return true of sorted and false otherwise
     */
    public static boolean isOrdered(String substring) {
        char[] nString = substring.toCharArray();
        Arrays.sort(nString);
        String t = "";
        for (char c : nString)
            t += c;
        return (t.compareTo(substring)) == 0;
    }

    public static boolean checkFactory(String in) {
        int s = 0;
        ArrayList<String> facElements = FactoryTiles(in);
        boolean[] checkEachFac = new boolean[facElements.size()];
        Arrays.fill(checkEachFac, false);
        boolean retVal = false;
        for (int i = 0; i < facElements.size(); i++)
            checkEachFac[i] = isOrdered(facElements.get(i).substring(1));
        for (boolean b : checkEachFac) {
            if (b)
                s++;
        }
        retVal = s == facElements.size();
    }

    public static void main(String[] args) {

        String inP4 = "AF0abbd1abbe2adde3aabe4bddeCfB1409161110D0003010204";
        String inP5 = "AF0aace1acdd2abce3bbee4cdeCB1617161714D0000000000";
        String inP6 = "cbde";
        System.out.println(isOrdered(inP6));

    }
}
