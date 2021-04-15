package comp1110.ass2.D2B;

import java.util.function.Predicate;

public class Factory implements DraftingFunctions {
    public Tiles[] tiles = new Tiles[4];
    public Player tPlayer;

    /**
     * Return all the tiles present in this factory
     *
     * @return Tiles[]
     */
    public Tiles[] getTiles() {
        return tiles;
    }

    /**
     * Return the player who makes the drafting move next
     *
     * @return Player
     */

    public Player getNextTurn() {
        return tPlayer.nextPlayer;
    }
}
