package comp1110.ass2;

public class Centre implements DraftingFunctions {
    public Tiles[] tiles;
    public Player tPlayer;

    public Centre(Tiles[] tiles) {
        this.tiles = tiles;
    }

    //@Override
    public Tiles[] getTiles() {
        return tiles;
    }

    //@Override
    public Player getNextTurn() {
        return tPlayer.nextPlayer;
    }


}
