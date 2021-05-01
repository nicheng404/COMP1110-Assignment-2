package comp1110.ass2;

import java.util.ArrayList;

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
        return "Discard " +
                isValid +
                " gameStr= " + gameStr;

    }


}
