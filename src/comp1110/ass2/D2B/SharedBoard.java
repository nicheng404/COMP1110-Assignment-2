package comp1110.ass2.D2B;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author Mukund Balaji Srinivas
 */
public class SharedBoard extends ReadSharedState {
    public ArrayList<Factory> factories;

    public SharedBoard(String inP) {
        super(inP);
        this.setDelAddr();
    }

    /**
     * @author Mukund Balaji Srinivas
     * The list of indices of starting of each factory i.e the index within the input string
     * @return
     */
    public ArrayList<Integer> getAllNums() {
        ArrayList<Integer> numAddr = new ArrayList<>();
        int stFac = getDelAddr()[0] + 1;
        int eFac = getDelAddr()[1] + 1;
        for (int i = stFac; i < eFac; i++) {
            if (super.SharedState.charAt(i) >= '0' && super.SharedState.charAt(i) <= '8')
                numAddr.add(i);
        }
        return numAddr;
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
    SharedBoard shBd=new SharedBoard(invalid_States[0]);
        for(Integer i:shBd.getAllNums())
            System.out.println(i);
    }

}
