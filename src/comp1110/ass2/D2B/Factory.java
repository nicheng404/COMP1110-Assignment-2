package comp1110.ass2.D2B;

/**
 * @author Mukund Balaji Srinivas
 * <p>Each instance of this class consists of two parts</p>
 * <p>int Number referring to a particular factory and using number 0-8 </p>
 * <p> The input tileStr is a reprentation of each factory string starting with</p>
 * <p>[0-8] followed by [a-e]</p>
 * <p>Tiles[4] the tiles in each factory</p>
 */

public class Factory {
    public Tiles[] tiles = new Tiles[4];
    public int Number;
    boolean isValid;

    /**
     * @param tileStr referring to each factory
     * @author Mukund Balaji Srinivas
     * Set the address of each factory
     */
    public void setFacNumber(String tileStr) {
        String AddR = tileStr.substring(0, 1);
        this.Number = Integer.parseInt(AddR);
    }

    /**
     * @param tileStr referring to each factory
     * @author Mukund Balaji Srinivas
     * Takes string and splits it into all the
     */
    public void setFacTiles(String tileStr) {
        for (int i = 0; i < tileStr.substring(1).length(); i++)
            for (Tiles Tile : Tiles.values())
                if (tileStr.charAt(i) == Tile.symbol)
                    tiles[i] = Tile;

    }


}
