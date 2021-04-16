package comp1110.ass2.D2B;

/**
 * Since Drafting and Center have a lot of common functionality, making a common abstract object makes more sense.
 */
public interface DraftingFunctions {
    /**
     * Return all the tiles present in the space
     *
     * @return Tiles
     */
    Tiles[] getTiles();

    /**
     * Return the name of the player who plays next
     *
     * @return One from {A,B,C,D} for a 4 player game  , representing whose move it is.
     */
    Player getNextTurn();


}
