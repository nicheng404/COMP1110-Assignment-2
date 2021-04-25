package comp1110.ass2.D2B;

/**
 * @author Mukund Balaji Srinivas
 * <p>Each instance of this class consists of two parts</p>
 * <p>int Number referring to a particular factory and using number 0-8 </p>
 * <p>Tiles[4] the tiles in each factory</p>
 */

public class Factory {
    public Tiles[] tiles = new Tiles[4];
    public int Number;

    /**
     * @author Mukund Balaji Srinivas
     * Set the address of each factory
     * @param inP referring to each factory
     */
    public void setFacNumber(String inP){
        String AddR=inP.
    }

    /**
     * @author Mukund Balaji Srinivas
     * Takes string and splits it into all the
     * @param tilesString
     */
    public void setFacTiles(String tilesString){
        for(int i=0;i<tilesString.substring(1).length();i++)
            for(Tiles Tile:Tiles.values())
                if(tilesString.charAt(i) == Tile.symbol)
                    tiles[i]=Tile;

    }



}
