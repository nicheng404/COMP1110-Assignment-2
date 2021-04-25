package comp1110.ass2.D2B;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author Mukund Balaji Srinivas
 */
public class SharedBoardFacCentre extends ReadSharedState {
    public ArrayList<Factory> factories = new ArrayList<>();
    public Centre centre;
    public boolean isValid;

    public SharedBoardFacCentre(String inP) {
        super(inP);
        this.setDelAddr();
    }

    /**
     * @return ArrayList of indices representing the starting of each factory
     * @author Mukund Balaji Srinivas
     * The list of indices of starting of each factory i.e the index within the input string
     */
    public ArrayList<Integer> getAllNums() {
        ArrayList<Integer> numAddr = new ArrayList<>();
        int stFac = getDelAddr()[0] + 1;
        int eFac = getDelAddr()[1] + 1;
        for (int i = stFac; i < eFac; i++) {
            if ((super.SharedState.charAt(i) >= '0' && super.SharedState.charAt(i) <= '8'))
                numAddr.add(i);
        }
        numAddr.add(eFac);
        return numAddr;
    }

    /**
     * @return Array of strings that can be input to generate factories
     * @author Mukund Balaji Srinivas
     * The number Get all the Factory strings
     */
    public ArrayList<String> getFacString() {
        ArrayList<Integer> numAddr = getAllNums();
        ArrayList<String> retVal = new ArrayList<>();
        for (int i = 0; i < getAllNums().size() - 1; i++) {
            retVal.add(super.SharedState.substring(numAddr.get(i), numAddr.get(i + 1)));
        }
        return retVal;
    }


    /**
     * @author Mukund Balaji Srinivas
     * Set each factory string to factory
     */
    public void setFacs() {
        ArrayList<String> getFacStrings = getFacString();
        for (String s : getFacStrings) {
            Factory f = new Factory(s);
            f.setIsValid();
            factories.add(f);
        }
    }

    /**
     * A getter for factories
     *
     * @return factories
     * @author Mukund Balaji Srinivas
     */
    public ArrayList<Factory> getFacs() {
        setFacs();
        return factories;
    }

    /**
     * @return true if each element is valid, false otherwise
     * @author Mukund Balaji Srinivas
     * Check the validity of this factory <p>true if each and every element is valid</p>
     */
    public boolean validFac() {
        ArrayList<Factory> Facs = getFacs();
        boolean[] retVal = new boolean[Facs.size()];
        for (int f = 0; f < Facs.size(); f++) {
            if (!Facs.get(f).isValid)
                retVal[f] = false;
        }
        boolean[] checkVal = new boolean[Facs.size()];
        Arrays.fill(checkVal, true);
        return Arrays.equals(checkVal, retVal);
    }

    public void setCentre() {
        int stCentre = getDelAddr()[1] + 1;
        int endCentre = getDelAddr()[2] + 1;
        Centre c = new Centre(SharedState.substring(stCentre,endCentre));
        c.setIsValid();
    }

    public static void main(String[] args) {
        String[] invalid_States = {
                "AF0aace1acdd2abce3bbee4cdeCB1617161714D0000000000", // factory contains 3 tiles
                "BF0aace1acdd2abce3bbeee4cdeeCB1617161714D0000000000", // factory contains > 4 tiles.
                "BF0aace1acdd2abce3bbee4ceddCB1617161714D0000000000", // tiles in factory not alphabetical
                "AF0aace1acdd2abce3bbee4cdeCB3117163714D0000000000", // greater than 20 tiles (one colour) in bag.
                "BF0aace1acdd2abce3bbee4cdeeCB161716171413D0000000000", // greater than 11 characters in bag string
                "AF0aace1acdd2abce3bbee4cdeeCB1617161714D00000000000", // greater than 11 characters in discard string
                "AFCaaabcfeB1108151109D0003010204" // tiles in centre not in alphabetical order.

        };
        SharedBoardFacCentre shBd = new SharedBoardFacCentre(invalid_States[0]);
        for (Factory f : shBd.getFacs())
            System.out.println(f);
    }

}
