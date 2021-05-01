package comp1110.ass2;

/**
 * @author Mukund Balaji Srinivas
 **/
public class SharedBoardBagDiscard extends ReadSharedState {
    public boolean isValid;
    public Bag bag;
    public Discard discard;

    public SharedBoardBagDiscard(String inP) {
        super(inP);
        super.setDelAddr();
        setBag();
        setDiscard();
    }

    /**
     * Set the contents of bag
     */
    public void setBag() {
        int stBag = getDelAddr()[2];
        int eBag = getDelAddr()[3];
        bag = new Bag(super.SharedState.substring(stBag, eBag).substring(1));
    }

    /**
     * Set the contents of Discard
     */
    public void setDiscard() {
        int stDis = getDelAddr()[3];
        discard = new Discard(super.SharedState.substring(stDis + 1));
    }


}
