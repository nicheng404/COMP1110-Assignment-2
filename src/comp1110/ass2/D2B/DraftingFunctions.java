package comp1110.ass2.D2B;

import java.util.function.Predicate;

/**
 * Since Drafting and Center have a lot of common functionality, making a common abstract object makes more sense.
 */
public interface DraftingFunctions  {
        /**
         * Return all the tiles present in the space
         * @return Tiles
         */
        Tiles[] getTiles();

        /**
         * Return all the tiles of the same colour
         * @return Tiles
         */
        Tiles[] getSameColour();

        /**
         * find the name of this player
         * @return  One from {A,B,C,D} , representing whose move it is.
         */
        String getNextTurn();


}
