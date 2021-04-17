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
        int s = 0;
        ArrayList<String> facElements = FactoryTiles(in);
        boolean[] checkEachFac = new boolean[facElements.size()];
        Arrays.fill(checkEachFac, false);
        boolean retVal = false;
        if (validFactoryLengths(in)) {
            for (int i = 0; i < facElements.size(); i++)
                checkEachFac[i] = isOrdered(facElements.get(i).substring(1));
            for (boolean b : checkEachFac) {
                if (b)
                    s++;
            }
            retVal = s == facElements.size();
        }
        return retVal;
    }

    /**
     * Get the position of letter 'C' , the tiles after which indicate the centre tiles
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
     * @param in
     * @return valid tiles are encoded as is <p> invalid tiles are encoded as Z</p>
     */
    public static String getCenterTiles(String in) {
        String AllCentre = in.substring(getCentrePosition(in));
        String retString = "";
        for (int i = 1; AllCentre.charAt(i) != 'B' && AllCentre.charAt(0)=='C'; i++) {
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
     * @param in Input string
     * @return true if [centre] string is formed as per the documentation<p>false otherwise.</p>
     */
    public static boolean checkCentre(String in){
        String CentreTiles = getCenterTiles(in);
        boolean retVal=false;
        if(!CentreTiles.contains("Z"))
            if(isOrdered(CentreTiles))
                retVal=true;
        return retVal;
    }



    public static void main(String[] args) {

        String inP6 = "AFCB0712090708D0000000000"; // Valid Config
        String inP7 = "BF0ccce1aace2aade3abde4ccdeCfB0505040402D0609040610"; // Valid config
        String inP8 = "AF0aace1acdd2abce3bbee4cdeCB1617161714D0000000000";// Valid Config
        String inP9 = "AF0aace1acdd2abce3bbee4bcdeCaacdefB1617161714D0000000000"; // Valid Config
        String inP10 = "BF0aace1acdd2abce3bbeee4cdeeCB1617161714D0000000000"; // Invalid factory contains > 4 tiles.
        String inP11 = "BF0aace1acdd2abce3bbee4ceddCB1617161714D0000000000";
        String inP12 = "AFCaaabcfeB1108151109D0003010204";// Invalid tiles in factory not alphabetical
        System.out.println(checkFactory(inP9));
        System.out.println(checkFactory(inP10));
        System.out.println(checkFactory(inP11));
        System.out.println(getCentrePosition(inP9));
        System.out.println(checkCentre(inP12));


    }
}
