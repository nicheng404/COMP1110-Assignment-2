package comp1110.ass2;

import java.util.ArrayList;
import java.util.Arrays;

public class Centre {
    public ArrayList<Tiles> tiles = new ArrayList<>();
    public boolean isValid;
    public String tileStr;

    public Centre(String tileStr) {
        this.tileStr = tileStr;
    }

    /**
     * @author Mukund Balaji Srinivas
     * Takes a string and splits it into all the tiles
     */
    public void setCentreTiles() {
        for (int i = 0; i < tileStr.substring(1).length(); i++) {
            for (Tiles Tile : Tiles.values()) {
                if (tileStr.substring(1).charAt(i) == Tile.symbol)
                    tiles.add(Tile);
            }
        }
    }


    /**
     * @return true if ordered , false otherwise
     * @author Mukund Balaji Srinivas
     * Check if a substring is ordered
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
     * Set the validity of a given Centre
     */
    public void setIsValid() {
        setCentreTiles();
        isValid = isOrdered();
    }


    @Override
    public String toString() {
        return "Centre{" +
                "isValid=" + isValid +
                '}';
    }
}
