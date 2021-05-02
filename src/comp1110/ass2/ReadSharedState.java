package comp1110.ass2;

import java.util.Arrays;

/**
 * This class reads the text from the shared state and finds delimiters to split them into
 * [Turn][Factory][Center][Bag][Discard]
 */
public class ReadSharedState {
    public String SharedState;
    public int[] DelAddr = new int[4];
    static final char[] chString = new char[]{'F', 'C', 'B', 'D'};

    public ReadSharedState(String sharedState) {
        this.SharedState = sharedState;
    }

    /**
     * Check if all the delimiters are present and there is only one Occurrence of each them.
     *
     * @return true if all the delimiters are present and there is only one occurrence <p>else false
     */
    public boolean ValidDelimiters() {
        String tString = this.SharedState.substring(1);
        boolean[] retVal = new boolean[4];
        Arrays.fill(retVal, false);
        final boolean[] chVal = new boolean[]{true, true, true, true};
        for (int i = 0; i < chString.length; i++) {
            if (tString.indexOf(chString[i]) == tString.lastIndexOf(chString[i]) && (tString.indexOf(chString[i]) != -1))
                retVal[i] = true;
        }
        return Arrays.equals(retVal, chVal);
    }

    /**
     * Set all the delimiters of the starting all strings
     */
    public void setDelAddr() {
        String tString = this.SharedState.substring(1);
        if (this.ValidDelimiters()) {
            for (int i = 0; i < chString.length; i++) {
                DelAddr[i] = tString.indexOf(chString[i]);
            }
        } else
            Arrays.fill(DelAddr, -1);
    }

}