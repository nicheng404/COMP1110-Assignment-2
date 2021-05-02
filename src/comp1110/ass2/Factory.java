package comp1110.ass2;

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

    /**
     * Given a state, refill the factories with tiles.
     * If the factories are not all empty, return the given state.
     *
     * @param gameState the state of the game.
     * @return the updated state after the factories have been filled or
     * the given state if not all factories are empty.
     *
     */

    public static String[] refillFactories(String[] gameState) {

        String[] result = new String[2];
        String string0 = gameState[0];
        String string1 = gameState[1];

        // get string0 substrings
        int index0F = string0.indexOf("F", 1);
        int index0C = string0.indexOf("C", index0F);
        int index0B = string0.indexOf("B", index0C);
        int index0D = string0.indexOf("D", index0B);

        //String factories = string0.substring(index0F + 1, index0C);
        //String center = string0.substring(index0C + 1, index0B);
        String bag = string0.substring(index0B + 1, index0D);
        String discard = string0.substring(index0D + 1);


        // string bag -> int
        int bagOfa = Integer.parseInt(bag.substring(0, 2));
        int bagOfb = Integer.parseInt(bag.substring(2, 4));
        int bagOfc = Integer.parseInt(bag.substring(4, 6));
        int bagOfd = Integer.parseInt(bag.substring(6, 8));
        int bagOfe = Integer.parseInt(bag.substring(8));
        int tileInBag = bagOfa + bagOfb + bagOfc + bagOfd + bagOfe;

        //string discard -> int
        int discardOfa = Integer.parseInt(discard.substring(0, 2));
        int discardOfb = Integer.parseInt(discard.substring(2, 4));
        int discardOfc = Integer.parseInt(discard.substring(4, 6));
        int discardOfd = Integer.parseInt(discard.substring(6, 8));
        int discardOfe = Integer.parseInt(discard.substring(8));
        int tileInDiscard = discardOfa + discardOfb + discardOfc + discardOfd + discardOfe;


        // get number of players -> extend for 4 players
        int numberOfPlayer = Azul.getNUmberOfPlayer(string1);

        // number of factories = 2*number of player+1;
        int numberOfFactories = 2 * numberOfPlayer + 1;

//__________________________________________________________________________________________________________________//


        int numberOfTileInFactory = numberOfFactories * 4;
        //string0->StringBuilder stb0
        StringBuilder stb0 = new StringBuilder(string0);

        boolean shootBack = false;

        // check factory/center not empty && C中不能只有f
        if (index0C - index0F != 1) {
            shootBack = true;
        } else {
            if (index0B - index0C > 2) {
                shootBack = true;
            } else if (index0B - index0C == 2) {
                char checkf = string0.substring(index0C + 1, index0B).charAt(0);
                if (checkf != 'f') {
                    shootBack = true;
                }
            }
        }


        // factory/center not empty && C中不能只有f
        if (shootBack) {
            result[0] = string0;
            result[1] = string1;
            return result;
        }
        //factory/centre empty
        else {
            // predefine factoryarry here with int and 'p'
            char[] factoryArray = new char[5 * numberOfFactories];


            // fill the factoryarray
            //bag adequate
            if (tileInBag >= numberOfTileInFactory) {


                String[] newFactoryBagArray = Factory.getNewFactoryBagArrayAfterFillingFactoryFromBag_Adequate
                        (factoryArray, bagOfa, bagOfb, bagOfc, bagOfd, bagOfe);

                // get new factory string
                String newFactoryString = newFactoryBagArray[0];

                // get new discard string
                //String newDiscardString = "" + (discardOfa * 100000000 + discardOfb * 1000000 + discardOfc * 10000 + discardOfd * 100 + discardOfe);
                String newDiscardString = discard;

                // get new bag string
                String newBagString = newFactoryBagArray[1];

                //get centre
                String center = string0.substring(index0C + 1, index0B);
                // get new string of string0
                String newString0 = string0.charAt(0) + "F" + newFactoryString + "C" + center + "B" + newBagString + "D" + newDiscardString;

                result[0] = newString0;
                result[1] = string1;
            }

            //bag inadequate,fill bag first
            else if (tileInBag < numberOfTileInFactory) {

                //bag空 先fill bag
                if (tileInBag == 0) {

                    // bag=0, fill the bag
                    bagOfa = bagOfa + discardOfa;
                    bagOfb = bagOfb + discardOfb;
                    bagOfc = bagOfc + discardOfc;
                    bagOfd = bagOfd + discardOfd;
                    bagOfe = bagOfe + discardOfe;

                    discardOfa = 0;
                    discardOfb = 0;
                    discardOfc = 0;
                    discardOfd = 0;
                    discardOfe = 0;

                    String[] newFactoryBagArray = Factory.getNewFactoryBagArrayAfterFillingFactoryFromBag_Adequate
                            (factoryArray, bagOfa, bagOfb, bagOfc, bagOfd, bagOfe);


                    // get new factory string
                    String newFactoryString = newFactoryBagArray[0];

                    // get new discard string
                    //String newDiscardString = "" + (discardOfa * 100000000 + discardOfb * 1000000 + discardOfc * 10000 + discardOfd * 100 + discardOfe);
                    String newDiscardString = "0000000000";

                    // get new bag string
                    String newBagString = newFactoryBagArray[1];

                    //get centre
                    String center = string0.substring(index0C + 1, index0B);
                    // get new string of string0
                    String newString0 = string0.charAt(0) + "F" + newFactoryString + "C" + center + "B" + newBagString + "D" + newDiscardString;

                    result[0] = newString0;
                    result[1] = string1;
                }


                //bag不空 先用完bag里面的
                if (tileInBag > 0) {

                    // number of int
                    int numberOfInt = tileInBag / 4 + 1;

                    int[] numberOfTilesInBag = {bagOfa, bagOfb, bagOfc, bagOfd, bagOfe};
                    int count = 0;

                    for (int i = 0; i < numberOfInt + tileInBag; i++) {
                        if (i % 5 == 0) {
                            factoryArray[i] = (char) ('0' + i / 5);
                            count++;
                        } else {

                            char tile = Azul.getReasonableRandomTile(numberOfTilesInBag);

                            factoryArray[i] = tile;
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

                            count++;
                        }
                    }

                    // bag=0, fill the bag
                    bagOfa = bagOfa + discardOfa;
                    bagOfb = bagOfb + discardOfb;
                    bagOfc = bagOfc + discardOfc;
                    bagOfd = bagOfd + discardOfd;
                    bagOfe = bagOfe + discardOfe;

                    discardOfa = 0;
                    discardOfb = 0;
                    discardOfc = 0;
                    discardOfd = 0;
                    discardOfe = 0;

                    int[] numberOfTilesInBagNew = {bagOfa, bagOfb, bagOfc, bagOfd, bagOfe};

                    for (int i = count; i < factoryArray.length; i++) {
                        if (i % 5 == 0) {
                            factoryArray[i] = (char) ('0' + i / 5);
                        } else {

                            char tile = Azul.getReasonableRandomTile(numberOfTilesInBagNew);

                            factoryArray[i] = tile;
                            // check if a/b/c/d/e, operate on array
                            switch (tile) {
                                case 'a':
                                    numberOfTilesInBagNew[0]--;
                                    break;
                                case 'b':
                                    numberOfTilesInBagNew[1]--;
                                    break;
                                case 'c':
                                    numberOfTilesInBagNew[2]--;
                                    break;
                                case 'd':
                                    numberOfTilesInBagNew[3]--;
                                    break;
                                case 'e':
                                    numberOfTilesInBagNew[4]--;
                                    break;
                            }
                        }
                    }

                    // char[] factoryarray -> string
                    String newFactoryString = String.valueOf(factoryArray);

                    // get new discard string
                    //String newDiscardString = "" + (discardOfa * 100000000 + discardOfb * 1000000 + discardOfc * 10000 + discardOfd * 100 + discardOfe);
                    String newDiscardString = "0000000000";

                    // get new bag string
                    // 9-> 09
                    String newBagString = "";
                    for (int v : numberOfTilesInBagNew) {
                        if (v < 10) {
                            newBagString = newBagString + "0" + v;
                        } else {
                            newBagString = newBagString + v;
                        }
                    }

                    //get centre
                    String center = string0.substring(index0C + 1, index0B);
                    // get new string of string0
                    String newString0 = string0.charAt(0) + "F" + newFactoryString + "C" + center + "B" + newBagString + "D" + newDiscardString;

                    result[0] = newString0;
                    result[1] = string1;
                }
            }
        }
        return result;
    }

}
