package comp1110.ass2.D2B;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author Mukund Balaji Srinivas
 * <p>Each instance of this class consists of two parts</p>
 * <p>int Number referring to a particular factory and using number 0-8 </p>
 * <p> The input tileStr is a reprentation of each factory string starting with</p>
 * <p>[0-8] followed by [a-e]</p>
 * <p>Tiles[4] the tiles in each factory</p>
 */

public class Factory {
    public ArrayList<Tiles> tiles = new ArrayList<>();
    public int Number;
    public boolean isValid;
    public String tileStr;

    Factory(String tileStr){
        this.tileStr=tileStr;
    }
    /**
     * @author Mukund Balaji Srinivas
     * Set the address of each factory
     */
    public void setFacNumber() {
        String AddR = tileStr.substring(0, 1);
        this.Number = Integer.parseInt(AddR);
    }

    /**
     * @author Mukund Balaji Srinivas
     * Takes a string and splits it into all the tiles
     */
    public void setFacTiles() {
        for (int i = 0; i < tileStr.substring(1).length(); i++)
            for (Tiles Tile : Tiles.values())
                if (tileStr.substring(1).charAt(i) == Tile.symbol)
                    tiles.add(Tile);

    }

    /**
     * @author Mukund Balaji Srinivas
     * Check if a substring is ordered
     * @return true if ordered , false otherwise
     */
    public boolean isOrdered() {
        char[] nString = tileStr.substring(1).toCharArray();
        Arrays.sort(nString);
        String t = "";
        for (char c : nString)
            t += c;
        return (t.compareTo(tileStr.substring(1))) == 0;
    }


    /**
     * Set the validity of a given factory
     */
    public void setIsValid() {
        setFacTiles();
        setFacNumber();
        isValid = tiles.size() == 4 && Number <=8 & isOrdered();
    }

    @Override
    public String toString() {
        return "Validity: " + isValid;
    }
}
