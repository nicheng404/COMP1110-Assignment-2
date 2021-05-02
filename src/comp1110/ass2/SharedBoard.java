package comp1110.ass2;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author Mukund Balaji Srinivas
 **/
public class SharedBoard {
    public SharedBoardBagDiscard bagDiscard;
    public SharedBoardFacCentre facCentre;
    public boolean isValid;


    SharedBoard(String inP) {
        this.bagDiscard = new SharedBoardBagDiscard(inP);
        this.facCentre = new SharedBoardFacCentre(inP);
        this.isValid = bagDiscard.isValid && facCentre.isValid;

    }

    public static class SharedBoardBagDiscard extends ReadSharedState {
        public boolean isValid;
        public Bag bag;
        public Discard discard;

        public SharedBoardBagDiscard(String inP) {
            super(inP);
            super.setDelAddr();
            setBagDiscard();
        }

        /**
         * Set the contents of bag
         */
        public void setBagDiscard() {
            try {
                int stBag = getDelAddr()[2];
                int eBag = getDelAddr()[3];
                int stDis = getDelAddr()[3];
                bag = new Bag(super.SharedState.substring(stBag, eBag).substring(1));
                discard = new Discard(super.SharedState.substring(stDis + 1));
                isValid = bag.isValid && discard.isValid;
            } catch (Exception e) {
                isValid = false;
            }
        }


        @Override
        public String toString() {
            String retString;
            retString = bag.toString() + discard.toString();
            return retString;
        }
    }


    public static class SharedBoardFacCentre extends ReadSharedState {
        public ArrayList<Factory> factories = new ArrayList<>();
        public Centre centre;
        public boolean isValid;

        public SharedBoardFacCentre(String inP) {
            super(inP);
            super.setDelAddr();
            setFacCentre();

        }

        /**
         * Set all the fields associated with a given factory
         * number and tiles
         */
        public void setFacCentre() {
            try {
                int stF = getDelAddr()[0];
                int endF = getDelAddr()[1];
                int stCentre = getDelAddr()[1];
                int endCentre = getDelAddr()[2];
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
                centre = new Centre(SharedState.substring(stCentre, endCentre));
                boolean[] refValFac = new boolean[factories.size()];
                boolean refValCentre = centre.isValid;
                for (int i = 0; i < factories.size(); i++) {
                    refValFac[i] = factories.get(i).isValid;
                }
                boolean[] chkValFac = new boolean[factories.size()];
                Arrays.fill(chkValFac, true);
                isValid = Arrays.equals(chkValFac, refValFac) && refValCentre;
            }
            catch (Exception e){
                isValid = false;
            }


        }


        @Override
        public String toString() {
            StringBuilder retString = new StringBuilder();
            for (Factory f : factories)
                retString.append(f.toString());
            retString.append(centre);
            retString.insert(0, "F");
            return retString.toString();
        }

    }


    /**
     * Get the validity of the shared State
     *
     * @return true if the shared state is well formed, else return false
     */
    public boolean getValidity() {
        return isValid;
    }

    /**
     * get a string that retpresents the sharedstate with delimiters
     *
     * @return Shared State [Factories][Centre][Bag][Discard]
     */
    public String toString() {
        String retString;
        retString = facCentre.toString() + bagDiscard.toString();
        return retString;
    }

}

