package comp1110.ass2;

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
        super.setDelAddr();
        setFac();
        setCentre();
        setValid();
    }


    public void setFac() {
        int stF = getDelAddr()[0] + 1;
        int endF = getDelAddr()[1] + 1;
        String Facs = super.SharedState;
        ArrayList<Integer> FacAddr = new ArrayList<>();
        for (int c = stF; c < endF; c++) {
            if (Facs.charAt(c) >= '0' && Facs.charAt(c) <= '8') {
                FacAddr.add(c);
            }

        }
        FacAddr.add(endF);
        ArrayList<String> FacStrings = new ArrayList<>();
        for (int i = 0; i < FacAddr.size() - 1; i++) {
            FacStrings.add(super.SharedState.substring(FacAddr.get(i), FacAddr.get(i + 1)));
        }
        for (String s : FacStrings) {
            Factory f = new Factory(s);
            factories.add(f);
        }
    }

    public void setValid() {
        boolean[] refValFac = new boolean[factories.size()];
        boolean refValCentre = centre.isValid;
        for (int i = 0; i < factories.size(); i++) {
            refValFac[i] = factories.get(i).isValid;
        }
        boolean[] chkValFac = new boolean[factories.size()];
        Arrays.fill(chkValFac, true);
        isValid = Arrays.equals(chkValFac, refValFac) && refValCentre;

    }


    public void setCentre() {
        int stCentre = getDelAddr()[1] + 1;
        int endCentre = getDelAddr()[2] + 1;
        try {
            centre = new Centre(SharedState.substring(stCentre, endCentre));
            centre.setIsValid();
        } catch (Exception e) {
            isValid = false;

        }
    }

    @Override
    public String toString() {
        return "Validity " + isValid;
    }


    public static void main(String[] args) {
        String[] invalid_States = {
                "AF0aace1acdd2abce3bbee4cdeCB1617161714D0000000000", // factory contains 3 tiles
                "BF0aace1acdd2abce3bbeee4cdeeCB1617161714D0000000000", // factory contains > 4 tiles.
                "BF0aace1acdd2abce3bbee4ceddCB1617161714D0000000000", // tiles in factory not alphabetical
                "AF0aace1acdd2abce3bbee4cdeCB3117163714D0000000000", // greater than 20 tiles (one colour) in bag.
                "BF0aace1acdd2abce3bbee4cdeeCB161716171413D0000000000", // greater than 11 characters in bag string
                "AF0aace1acdd2abce3bbee4cdeeCB1617161714D00000000000", // greater than 11 characters in discard string
                "AFCaaabcfeB1108151109D0003010204", // tiles in centre not in alphabetical order.
                "AF0cdde1bbbe2abde3cdee4bcceCfB1915161614D0000000000" // Totally valid

        };
        SharedBoardFacCentre shBd = new SharedBoardFacCentre(invalid_States[7]);
        System.out.println(shBd);

    }

}
