package comp1110.ass2.D2B;

import comp1110.ass2.Azul;

import java.util.function.Predicate;

public class Factory implements DraftingFunctions {
    public Tiles[] tiles = new Tiles[4];
    public Player tPlayer;

    /**
     * Return all the tiles present in this factory
     *
     * @return Tiles[]
     */
    public Tiles[] getTiles() {
        return tiles;
    }

    /**
     * Return the player who makes the drafting move next
     *
     * @return Player
     */

    public Player getNextTurn() {
        return tPlayer.nextPlayer;
    }

//---------------------------------------Ke Ning methods----------------------------------------------//

    /**
     * Get new factory string and new bag string after filling factory from bag (bag is adequate).
     * 2 strings are combined as a new String[].
     * String[0] = new factory string. String[1] = new bag string.
     *
     * @param newFactoryArray the factory char[] to be filled.
     * @param bagOfa number of a tile in bag before filling factory.
     * @param bagOfb number of b tile in bag before filling factory.
     * @param bagOfc number of c tile in bag before filling factory.
     * @param bagOfd number of d tile in bag before filling factory.
     * @param bagOfe number of e tile in bag before filling factory.
     * @return String[2]. new factory string and new bag string after filling factory from bag.
     *                    String[0] = new factory string. String[1] = new bag string.
     */


    public static String[] getNewFactoryBagArrayAfterFillingFactoryFromBag_Adequate(char[] newFactoryArray, int bagOfa,
                                                 int bagOfb, int bagOfc, int bagOfd, int bagOfe) {

        int[] numberOfTilesInBag = {bagOfa, bagOfb, bagOfc, bagOfd, bagOfe};

        for (int i = 0; i < newFactoryArray.length; i++) {
            if (i % 5 == 0) {
                newFactoryArray[i] = (char) ('0' + i / 5);
            } else {

                char tile = Azul.getReasonableRandomTile(numberOfTilesInBag);

                newFactoryArray[i] = tile;
                // check if a/b/c/d/e, operate on array
                switch (tile) {
                    case 'a':
                        numberOfTilesInBag[0]--;
                        break;
                    case 'b':
                        numberOfTilesInBag[1]--;
                        break;
                    case 'c':
                        numberOfTilesInBag[2]--;
                        break;
                    case 'd':
                        numberOfTilesInBag[3]--;
                        break;
                    case 'e':
                        numberOfTilesInBag[4]--;
                        break;
                }
            }
        }
        String[] result = new String[2];

        // get new factory string
        result[0] = String.valueOf(newFactoryArray);

        // get new bag string
        // 9-> 09
        String newBagStringDemo = "";
        for (int v : numberOfTilesInBag) {
            if (v < 10) {
                newBagStringDemo = newBagStringDemo + "0" + v;
            } else {
                newBagStringDemo = newBagStringDemo + v;
            }
        }
        result[1]=newBagStringDemo;


        return result;
    }

}
