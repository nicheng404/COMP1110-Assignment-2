package comp1110.ass2;

import java.util.Arrays;

/**
 * @author Mukund Balaji Srinivas
 * This class reads the text from the shared state and finds delimiters to split them into
 * [Turn][Factory][Center][Bag][Discard]
 */
public abstract class ReadSharedState {
    public String SharedState;
    public int[] DelAddr = new int[4];
    static final char[] chString = new char[]{'F', 'C', 'B', 'D'};
    public boolean isValidDelimiter;


    public ReadSharedState(String inString) {
        this.SharedState = setSharedState(inString);
    }

    /**
     * @author Mukund Balaji Srinivas
     * Check if all the delimiters are present and there is only one Occurrence of each them.
     */
    public void setValidDelimiters() {
        String tString = SharedState;
        boolean[] retVal = new boolean[4];
        Arrays.fill(retVal, false);
        final boolean[] chVal = new boolean[]{true, true, true, true};
        for (int i = 0; i < chString.length; i++) {
            if (tString.indexOf(chString[i]) == tString.lastIndexOf(chString[i]) && (tString.indexOf(chString[i]) != -1))
                retVal[i] = true;
        }
        isValidDelimiter = Arrays.equals(retVal, chVal);
    }

    /**
     * @author Mukund Balaji Srinivas
     * Set all the delimiters of the starting all strings
     */
    public void setDelAddr() {
        String tString = this.SharedState;
        setValidDelimiters();
        if (isValidDelimiter) {
            for (int i = 0; i < chString.length; i++) {
                DelAddr[i] = tString.indexOf(chString[i]);
            }
        } else
            Arrays.fill(DelAddr, -1);
    }

    /**
     * Set the sharedState that can be used to get all the shared state variables
     * @param inString The value that needs to be checked for the presence of [Turn]
     * @return Return the version of the string that has to be used as an Input
     */
    public String setSharedState(String inString) {
        String retVal ;
        if (inString.charAt(0) >= 'A' && inString.charAt(0) <= 'D')
            retVal = inString.substring(1);
        else
            retVal = inString;
        return retVal;
    }

    /**
     * @return Get all the
     * @author Mukund Balaji Srinivas
     * get addresses of Delimiters for finding all the delimiters in this string
     */
    public int[] getDelAddr() {
        return DelAddr;
    }


}