package comp1110.ass2;

import java.util.ArrayList;
import java.util.Arrays;

public class Centre {
    public ArrayList<Tiles> tiles = new ArrayList<>();
    public boolean isValid;
    public String tileStr;

    public Centre(String tileStr) {
        this.tileStr = tileStr.substring(1);
        setCentreTiles();
    }

    /**
     * @author Mukund Balaji Srinivas
     * Takes a string and splits it into all the tiles
     */
    public void setCentreTiles() {
        try {
            for (int i = 0; i < tileStr.length(); i++) {
                for (Tiles Tile : Tiles.values()) {
                    if (tileStr.charAt(i) == Tile.symbol)
                        tiles.add(Tile);
                }
            }
            isValid = isOrdered();
        } catch (Exception e) {
            isValid = false;
        }

    }


    /**
     * @return true if ordered , false otherwise
     * @author Mukund Balaji Srinivas
     * Check if a substring is ordered
     */
    public boolean isOrdered() {
        char[] nString = tileStr.toCharArray();
        Arrays.sort(nString);
        StringBuilder t = new StringBuilder();
        for (char c : nString)
            t.append(c);
        return (t.toString().compareTo(tileStr)) == 0;
    }


    @Override
    public String toString() {
        StringBuilder retString = new StringBuilder();
        for (Tiles t : tiles) {
            retString.append(t.encode);
        }
        return retString.toString();
    }

    /**
     * get number of tiles in centre and return as an int[].
     * @return an int[]
     */
    public int[] getNumberOfTiles() {
        int[] result = new int[6];
        for (int i = 0; i < tiles.size(); i++) {
            switch (tiles.get(i).symbol) {
                case 'a':
                    result[0]++;
                    break;
                case 'b':
                    result[1]++;
                    break;
                case 'c':
                    result[2]++;
                    break;
                case 'd':
                    result[3]++;
                    break;
                case 'e':
                    result[4]++;
                    break;
                case 'f':
                    result[5]++;
                    break;
            }
        }
        return result;
    }

}
