package comp1110.ass2;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.IntPredicate;
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

        boolean[] allTrue = new boolean[FacAddr.size() - 1];
        Arrays.fill(allTrue, true);
        return Arrays.equals(allTrue, factoryTiles);
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

    /**
     * Check if the [factory] strings are ordered. A shared state is valid only if the string following the factory
     * number is sorted. <p>Furthermore, a state is valid only if the elements of each
     * factory have exactly a length of 4</p>
     * <p>eg 4aced is not valid but 4acde is valid</p>
     *
     * @param in Input string
     * @return true if all the factories have valid valid configurations.<p> false even if one of the factories has
     * an invalid configuration</p>
     */
    public static boolean checkFactory(String in) {
        ArrayList<String> facElements = FactoryTiles(in);
        boolean[] checkEachFac = new boolean[facElements.size()];
        boolean[] allTrue = new boolean[facElements.size()];
        Arrays.fill(checkEachFac, false);
        Arrays.fill(allTrue, true);
        boolean retVal;
        if (validFactoryLengths(in)) {
            for (int i = 0; i < facElements.size(); i++) {
                checkEachFac[i] = isOrdered(facElements.get(i).substring(1));
            }
            retVal = Arrays.equals(checkEachFac, allTrue);
        } else {
            retVal = false;
        }
        return retVal;

    }

    /**
     * Get the position of letter 'C' , the tiles after which indicate the centre tiles
     *
     * @param in input Input string
     * @return index of letter C
     */
    public static int getCentrePosition(String in) {
        int CentreP = 0;
        if (checkFactory(in))
            CentreP = findFacAddr(in).get(findFacAddr(in).size() - 1);
        return CentreP;
    }

    /**
     * Get all elements of the center tiles as strings
     *
     * @param in
     * @return valid tiles are encoded as is <p> invalid tiles are encoded as Z</p>
     */
    public static String getCenterTiles(String in) {
        String AllCentre = in.substring(getCentrePosition(in));
        String retString = "";
        for (int i = 1; AllCentre.charAt(i) != 'B' && AllCentre.charAt(0) == 'C'; i++) {
            if (AllCentre.charAt(i) >= 'a' && AllCentre.charAt(i) <= 'f')
                retString += AllCentre.charAt(i);
            else
                retString += "Z";
        }
        return retString;
    }

    /**
     * check if the  [centre] string is well formed as per the documentation. <p>The Centre string must not have
     * any elements other than encoded tiles.</p> Also, these tiles must be in Alphabetical order.
     *
     * @param in Input string
     * @return true if [centre] string is formed as per the documentation<p>false otherwise.</p>
     */
    public static boolean checkCentre(String in) {
        String CentreTiles = getCenterTiles(in);
        boolean retVal = false;
        if (!CentreTiles.contains("Z"))
            if (isOrdered(CentreTiles))
                retVal = true;
        return retVal;
    }

    /**
     * Determines the index of 'B' in [Bag] string.
     *
     * @param in Input
     * @return Index of 'B' , which represents the starting string of [Bag]
     */
    public static int getBagPosition(String in) {
        int bagPos = getCenterTiles(in).length() + getCentrePosition(in) + 1;
        return bagPos;
    }

    /**
     * Generic functions that elements as per the rules of encoding
     * and is followed by 5 two digit  Integers
     * <p>0th Element of the array represents the number of 'a' tiles, from 0 - 20.</p>
     * <p>1st Element of the array represents the number of 'b' tiles, from 0 - 20.</p>
     * <p>2nd Element of the array represents the number of 'c' tiles, from 0 - 20.</p>
     * <p>3re Element of the array represents the number of 'd' tiles, from 0 - 20.</p>
     * <p>4th Element of the array represents the number of 'e' tiles, from 0 - 20.</p>
     *
     * @param in         Input String
     * @param startIndex the index of B in [Bag] or D in [Discard]
     * @param predicate  condition for the termination of for loop <p>x -> x.toString().charAt(0) != '\0' in case of D</p>
     *                   <p>x -> x.toString().charAt(0) != 'D' in case of B</p>
     * @return An Array List of Integers
     */
    public static ArrayList<Integer> getItems(String in, int startIndex, Predicate predicate) {
        ArrayList<String> SretVal = new ArrayList<>();
        String BagElements = in.substring(startIndex);
        try {
            for (int i = 1; predicate.test(BagElements.charAt(i)); i += 2) {
                SretVal.add(BagElements.substring(i, i + 2));
            }
        } catch (StringIndexOutOfBoundsException e) {
            SretVal.add(null);
            SretVal.remove(SretVal.size() - 1);
        }

        ArrayList<Integer> retVal = new ArrayList<>();
        for (String s : SretVal)
            retVal.add(Integer.parseInt(s));
        return retVal;
    }

    /**
     * Checks if all the elements in [Bag] are less than 20. <p>Also checks for the length of the [Bag] String</p>
     *
     * @param in All the elements in the
     * @return true if all the elements in Bag are less than 20. <p>false otherwise</p>
     */
    public static boolean checkContents(String in, int startIndex, Predicate predicate) {
        IntPredicate pred = x -> x >= 0 && x <= 20;
        ArrayList<Integer> BagTiles = getItems(in, startIndex, predicate);
        boolean[] checkBagTiles = new boolean[BagTiles.size()];
        for (int i = 0; i < BagTiles.size(); i++)
            checkBagTiles[i] = pred.test(BagTiles.get(i));
        boolean[] allTrue = new boolean[BagTiles.size()];
        if (allTrue.length == 5) {
            Arrays.fill(allTrue, true);
            return Arrays.equals(checkBagTiles, allTrue);

        }
        return false;
    }

    /**
     * Determines the index of 'D' in [Discard]
     *
     * @param in
     * @return Index of D
     */
    public static int getDiscardPosition(String in) {
        int ind = 0;
        if (in.charAt(0) == 'F' && isValidNextPlayer(in)) {
            ind = in.indexOf('D');
        } else if (in.charAt(0) != 'F' && isValidNextPlayer(in)) {
            ind = in.substring(1).indexOf('D') + 1;
        }
        return ind;
    }

    /**
     * Checks if the length of Discard string is exactly 10
     *
     * @param in Input string
     * @return true if 10.
     */
    public static boolean checkDiscardLength(String in) {
        return in.substring(getDiscardPosition(in) + 1).length() == 10;
    }

    /**
     * Unifying methods for checking the contents of bag
     *
     * @param in
     * @return true if the Bag String is well formed
     */
    static boolean checkContentsBag(String in) {
        int sIndex = getBagPosition(in);
        Predicate pred = x -> x.toString().charAt(0) != 'D';
        return checkContents(in, sIndex, pred);
    }

    /**
     * Unifying methods for checking if the contents of Discard are well formed
     *
     * @param in
     * @return
     */
    static boolean checkContentsDiscard(String in) {
        int sIndex = getDiscardPosition(in);
        IntPredicate predicate = x -> x
        return checkContents(in, sIndex, predicate) && checkDiscardLength(in);
    }


    public static void main(String[] args) {
        String inP7 = "BF0aace1acdd2abce3bbee4cdeeCB1617161413D0000000000";//Valid
        String inP8 = "F0cdde1bbbe2abde3cdee4bcceCfB1915161614D0000000000";//Valid
        String inP9 = "AF0aace1acdd2abce3bbee4cdeeCB1617161714D00000000000";// greater than 11 characters in discard
        String inP10 = "BF0aace1acdd2abce3bbee4cdeeCB161716171413D0000000000";// 11 characters in bag string
        String inP11 = "A!0cdde1bbbe2abde3cdee4bcceCfB1915161614D0000000000";// Delimiters
        String inP12 = "AF0aace1acdd2abce3bbee4cdeCB1617161714D0000000000"; // Unordered therefore invalid
        String inP13 = "AFCB1006100707D0607040610"; // Valid;
        System.out.println(inP7.charAt(getDiscardPosition(inP7) + 1));


    }


}
