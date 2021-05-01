package comp1110.ass2;

import java.util.ArrayList;
import java.util.Arrays;

public class Discard {
    public static final Tiles[] names = {Tiles.B, Tiles.G, Tiles.O, Tiles.P, Tiles.R};
    public ArrayList<Integer> TileCount = new ArrayList<>();
    public int nElements;
    public boolean isValid;
    public String gameStr;


    /**
     * Set the elements of the bag from its gamestate
     */
    public void setDiscard() {
        if (isValid) {
            for (int i = 0; i < gameStr.substring(1).length() - 2; i += 2) {
                TileCount.add(Integer.parseInt(gameStr.substring(1).substring(i, i + 2)));
            }
        }

    }

    /**
     * Check if the given gamestate is valid
     */
    public void isValid() {
        isValid = gameStr.substring(1).length() == 10;
    }

    /**
     * Count the number of elements in the given bag
     */
    public void setnElements() {
        int count = 0;
        for (Integer i : TileCount) {
            count += i;
        }
        nElements = count;
    }


}
