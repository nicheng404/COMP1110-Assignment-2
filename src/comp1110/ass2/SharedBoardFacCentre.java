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

    /**
     * Set all the fields associalted with a given factory
     * number and tiles
     */
    public void setFac() {
        int stF = getDelAddr()[0] ;
        int endF = getDelAddr()[1] ;
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

    /**
     * Set the validity of the [factory][centre]
     */
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
        int stCentre = getDelAddr()[1] ;
        int endCentre = getDelAddr()[2] ;
        try {
            centre = new Centre(SharedState.substring(stCentre, endCentre));
        } catch (Exception e) {
            isValid = false;

        }
    }


    @Override
    public String toString() {
        return "Validity " + isValid;
    }


}
