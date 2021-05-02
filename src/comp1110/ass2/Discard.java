package comp1110.ass2;

<<<<<<< HEAD
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
=======
import java.util.ArrayList;
>>>>>>> origin/developmentbranchqw

public class Discard {
    public static final Tiles[] names = {Tiles.B, Tiles.G, Tiles.O, Tiles.P, Tiles.R};
    public ArrayList<Integer> TileCount = new ArrayList<>();
    public int nElements;
    public boolean isValid;
    public String gameStr;

    Discard(String gameStr){
        this.gameStr=gameStr;
        setDiscard();
    }

    /**
     * Set the elements of the bag from its gamestate
     */
    public void setDiscard() {
        isValid = gameStr.length()==10;
        if (isValid) {
            for (int i = 0; i < gameStr.length() ; i += 2) {
                TileCount.add(Integer.parseInt(gameStr.substring(i, i + 2)));
            }
        }

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

    @Override
    public String toString() {
<<<<<<< HEAD
        StringBuilder retString= new StringBuilder();
        DecimalFormat formatter = new DecimalFormat("00");
        for(Integer i:TileCount)
            retString.append(formatter.format(i));
        retString.insert(0,"D");
        return retString.toString();
    }


    //-----------------------------------------old-------------------------------------------------//
    public Tiles[] dTiles;
    public static final char HEAD = 'D';
    public String discardString; // discard string in state0 without 'D'
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

    /**
     * Get string of discard from a given sharedState string.
     * @param sharedState A given sharedState string.
     * @return string of discard(without 'D').
     */
    public static String getDiscardString(String sharedState){
        int indexOfD = sharedState.indexOf('D');
        String result = sharedState.substring(indexOfD+1);
        return result;
    }



}
=======
        return "Discard " +
                isValid +
                " gameStr= " + gameStr;

    }


}
>>>>>>> origin/developmentbranchqw
