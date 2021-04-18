package comp1110.ass2.D2B;

import java.util.Arrays;

public class Discard {
    public Tiles[] dTiles;

    /**
     * Get all the tiles in Discard
     *
     * @return dTiles
     */
    public Tiles[] getdTiles() {
        return dTiles;
    }


    /**
     * Push tiles to discard at the end of the array
     *
     * @param pushTiles
     */
    public void pushToDiscard(Tiles[] pushTiles) {
        Tiles[] newArr = Arrays.copyOf(dTiles, dTiles.length + pushTiles.length);
        int j = 0;
        for (int i = dTiles.length; i < newArr.length && j < pushTiles.length; i++) {
            newArr[i] = pushTiles[j];
            j++;
        }
    }

}
