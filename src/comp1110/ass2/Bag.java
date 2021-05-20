package comp1110.ass2;


import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Random;

/**
 * @author Ke Ning & Mukund Balaji Srinivas
 */

public class Bag {
    public static final Tiles[] names = {Tiles.B, Tiles.G, Tiles.O, Tiles.P, Tiles.R};
    public ArrayList<Integer> TileCount = new ArrayList<>();
    public int nElements;
    public boolean isValid;
    public String gameStr;

    Bag(String gameStr) {
        this.gameStr = gameStr;
        setBag();
    }

    /**
     * Given the gameState, draw a *random* tile from the bag.
     * If the bag is empty, refill the the bag with the discard pile and then draw a tile.
     * If the discard pile is also empty, return 'Z'.
     * @param gameState the current game state
     * @return the tile drawn from the bag, or 'Z' if the bag and discard pile are empty.
     */

    public static String getTilesFromBag(String[] gameState) {
        String[] subStrings = new String[2];
        String gs0 = gameState[0];
        String gs1 = gameState[1];

        //get substrings
        int index0F = gs0.indexOf("F", 1);
        int index0C = gs0.indexOf("C", index0F);
        int index0B = gs0.indexOf("B", index0C);
        int index0D = gs0.indexOf("D", index0B);
        return gs0.substring(index0B+1, index0D);
    }



    // return true if bag is empty.
    public static boolean checkBagIsEmpty(String[] sharedState) {
        String bagTiles = null;
        if (getTilesFromBag(sharedState).equals("B0000000000")) {
            return true;
        } else return false;
    }



    // return a random element from 'abcde'.
    public static char getRandomElement () {
        Random rand = new Random();
        String characters = "abcde";
        char randomChar = characters.charAt(rand.nextInt(characters.length()));
        return randomChar;
    }




    public Tiles getTilesFromBag() {
        Random rand = new Random();
        Tiles retTile;
        int getTile = rand.nextInt(nElements) % 3;
        while (TileCount.get(getTile) == 0) {
            getTile = rand.nextInt(nElements) % 3;
        }
        retTile = names[getTile];
        TileCount.set(getTile, TileCount.get(getTile) - 1);
        setnElements();
        return retTile;
    }

    /**
     * Set the number of elements in the  bag
     */
    public void setnElements() {
        int count = 0;
        for (Integer i : TileCount) {
            count += i;
        }
        nElements = count;
    }


    /**
     * Changed the function to return the nElements variable , so this becomes like a getter.
     *
     * @return true if number of elements in the bag is zero
     * @author Mukund Balaji Srinivas
     */
    public boolean checkBagIsEmpty() {
        return nElements == 0;
    }


    /**
     * Set the elements of the bag from its gamestate
     */
    public void setBag() {
        isValid = gameStr.length() == 10;
        if (isValid) {
            for (int i = 0; i < gameStr.length() ; i += 2) {
                TileCount.add(Integer.parseInt(gameStr.substring(i, i + 2)));
            }
        }
    }

    /**
     * get the number of tiles in bag as an array[]
     * @return
     */
    public int[] getNumberOfTiles(){
        int[] result=new int[6];
        for(int i=0;i<TileCount.size();i++){
            result[i]=TileCount.get(i);
        }
        return result;
    }

    @Override
    public String toString() {
        StringBuilder retString= new StringBuilder();
        DecimalFormat formatter = new DecimalFormat("00");
        for(Integer i:TileCount)
            retString.append(formatter.format(i));
        retString.insert(0,"B");
        return retString.toString();
    }

}