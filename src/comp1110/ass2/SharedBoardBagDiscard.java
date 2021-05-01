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
    }

    /**
     * Set the contents of bag
     */
    public void setBag() {
        int stBag = getDelAddr()[2] + 1;
        int eBag = getDelAddr()[3] + 1;
        bag = new Bag(super.SharedState.substring(stBag, eBag).substring(1));
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
        SharedBoardBagDiscard shBd=new SharedBoardBagDiscard(invalid_States[7]);
        System.out.println(shBd.bag);
    }

}
