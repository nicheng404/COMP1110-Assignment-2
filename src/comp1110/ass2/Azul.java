package comp1110.ass2;

import java.util.Random;

public class Azul {
    /**
     * Given a shared state string, determine if it is well-formed.
     * Note: you don't need to consider validity for this task.
     * A sharedState is well-formed if it satisfies the following conditions.
     * <p>
     * [turn][factories][centre][bag][discard]
     * where [turn][factories], [centre], [bag] and [discard] are replaced by the
     * corresponding small string as described below.
     * <p>
     * 0. [turn] The Turn substring is one character 'A'-'D' representing a
     * player, which indicates that it is this player's turn to make the next
     * drafting move. (In a two-player game, the turn substring can only take
     * the values 'A' or 'B').
     * <p>
     * 1. [factories] The factories substring begins with an 'F'
     * and is followed by a collection of *up to* 5 5-character factory strings
     * representing each factory.
     * Each factory string is defined in the following way:
     * 1st character is a sequential digit '0' to '4' - representing the
     * factory number.
     * 2nd - 5th characters are 'a' to 'e', alphabetically - representing
     * the tiles.
     * A factory may have between 0 and 4 tiles. If a factory has 0 tiles,
     * it does not appear in the factories string.
     * Factory strings are ordered by factory number.
     * For example: given the string "F1aabc2abbb4ddee": Factory 1 has tiles
     * 'aabc', Factory 2 has tiles 'abbb', Factory 4 has tiles 'ddee', and
     * Factories 0 and 4 are empty.
     * <p>
     * 2. [centre] The centre substring starts with a 'C'
     * This is followed by *up to* 15 characters.
     * Each character is 'a' to 'e', alphabetically - representing a tile
     * in the centre.
     * The centre string is sorted alphabetically.
     * For example: "Caaabcdde" The Centre contains three 'a' tiles, one 'b'
     * tile, one 'c' tile, two 'd' tile and one 'e' tile.
     * <p>
     * 3. [bag] The bag substring starts with a 'B'
     * and is followed by 5 2-character substrings
     * 1st substring represents the number of 'a' tiles, from 0 - 20.
     * 2nd substring represents the number of 'b' tiles, from 0 - 20.
     * 3rd substring represents the number of 'c' tiles, from 0 - 20.
     * 4th substring represents the number of 'd' tiles, from 0 - 20.
     * 5th substring represents the number of 'e' tiles, from 0 - 20.
     * <p>
     * For example: "B0005201020" The bag contains zero 'a' tiles, five 'b'
     * tiles, twenty 'c' tiles, ten 'd' tiles and twenty 'e' tiles.
     * 4. [discard] The discard substring starts with a 'D'
     * and is followed by 5 2-character substrings defined the same as the
     * bag substring.
     * For example: "D0005201020" The bag contains zero 'a' tiles, five 'b'
     * tiles, twenty 'c' tiles, ten 'd' tiles, and twenty 'e' tiles.
     *
     * @param sharedState the shared state - factories, bag and discard.
     * @return true if sharedState is well-formed, otherwise return false
     * TASK 2
     */
    public static boolean isSharedStateWellFormed(String sharedState) {
        SharedBoard ShBd = new SharedBoard(sharedState);
        return ShBd.getValidity();
    }

    /**
     * Given a playerState, determine if it is well-formed.
     * Note: you don't have to consider validity for this task.
     * A playerState is composed of individual playerStrings.
     * A playerState is well-formed if it satisfies the following conditions.
     * <p>
     * A playerString follows this pattern: [player][score][mosaic][storage][floor]
     * where [player], [score], [mosaic], [storage] and [floor] are replaced by
     * a corresponding substring as described below.
     * Each playerString is sorted by Player i.e. Player A appears before Player B.
     * <p>
     * 1. [player] The player substring is one character 'A' to 'D' -
     * representing the Player
     * <p>
     * 2. [score] The score substring is one or more digits between '0' and '9' -
     * representing the score
     * <p>
     * 3. [mosaic] The Mosaic substring begins with a 'M'
     * Which is followed by *up to* 25 3-character strings.
     * Each 3-character string is defined as follows:
     * 1st character is 'a' to 'e' - representing the tile colour.
     * 2nd character is '0' to '4' - representing the row.
     * 3rd character is '0' to '4' - representing the column.
     * The Mosaic substring is ordered first by row, then by column.
     * That is, "a01" comes before "a10".
     * <p>
     * 4. [storage] The Storage substring begins with an 'S'
     * and is followed by *up to* 5 3-character strings.
     * Each 3-character string is defined as follows:
     * 1st character is '0' to '4' - representing the row - each row number must only appear once.
     * 2nd character is 'a' to 'e' - representing the tile colour.
     * 3rd character is '0' to '5' - representing the number of tiles stored in that row.
     * Each 3-character string is ordered by row number.
     * <p>
     * 5. [floor] The Floor substring begins with an 'F'
     * and is followed by *up to* 7 characters in alphabetical order.
     * Each character is 'a' to 'f' - where 'f' represents the first player token.
     * There is only one first player token.
     * <p>
     * An entire playerState for 2 players might look like this:
     * "A20Ma02a13b00e42S2a13e44a1FaabbeB30Mc01b11d21S0e12b2F"
     * If we split player A's string into its substrings, we get:
     * [A][20][Ma02a13b00e42][S2a13e44a1][Faabbe].
     *
     * @param playerState the player state string
     * @return True if the playerState is well-formed,
     * false if the playerState is not well-formed
     * TASK 3
     */
    public static boolean isPlayerStateWellFormed(String playerState) {
        // FIXME Task 3
        // [player][score][mosaic][storage][floor]
        // [A][20][M a02 a13 b00 e42][S 2a1 3e4 4a1][F aabbe]


        int numberOfPlayer = Player.getNumberOfPlayer(playerState);
        String[] playerStringArray;
        playerStringArray = Player.getEachPlayerStateString(playerState);

        //key result
        int wellFormedPlayer = 0;
//____________________________________________________________________________________________________//
        for (String playerString : playerStringArray) {

            int indexM = playerString.indexOf("M");
            int indexS = playerString.indexOf("S");
            int indexF = playerString.indexOf("F");
            // check [player]&& M S F
            if ((playerString.charAt(0) == 'A' || playerString.charAt(0) == 'B'
                    || playerString.charAt(0) == 'C'
                    || playerString.charAt(0) == 'D')
                    && (indexM != -1) && (indexS != -1) && (indexF != -1)) {
                // check [score]
                // before that, get the substring before M and check value
                //int indexM = playerString.indexOf("M");
                String playerScore = playerString.substring(1, indexM);
                int value = Integer.parseInt(playerScore);
                if (value >= 0 && value <= 999) {

                    // check [mosaic]
                    // before that, get the substring before Storage
                    //int indexS = playerString.indexOf("S");
                    String playerMosaic = playerString.substring(indexM + 1, indexS);
                    if (Mosaic.mosaicTilesWellFormed(playerMosaic)) {

                        // check [storage]
                        //得到 storage的substring
                        //int indexF = playerString.indexOf("F");
                        String playerStorage = playerString.substring(indexS + 1, indexF);
                        if (Storage.storageTilesWellFormed(playerStorage)) {
                            // check [floor]
                            //得到 floor substring
                            String playerFloor = playerString.substring(indexF + 1);
                            //check criteria
                            if (Floor.floorTilesWellFormed(playerFloor)) {
                                wellFormedPlayer++;
                            }
                        }
                    }
                }
            }
        }

        if (numberOfPlayer == wellFormedPlayer) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Given the gameState, draw a *random* tile from the bag.
     * If the bag is empty, refill the the bag with the discard pile and then draw a tile.
     * If the discard pile is also empty, return 'Z'.
     *
     * @param gameState the current game state
     * @return the tile drawn from the bag, or 'Z' if the bag and discard pile are empty.
     * TASK 5
     */
    public static char drawTileFromBag(String[] gameState) {
        String[] draw = new String[2];
        String gs0 = gameState[0];
        String gs1 = gameState[1];
        //get substrings
        int index0F = gs0.indexOf("F", 1);
        int index0C = gs0.indexOf("C", index0F);
        int index0B = gs0.indexOf("B", index0C);
        int index0D = gs0.indexOf("D", index0B);
        //System.out.println(index0F);
        //System.out.println(index0C);
        //System.out.println(index0B);
        //System.out.println(index0D);

        String bag = gs0.substring(index0B + 1, index0D);
        String discard = gs0.substring(index0D + 1);
        // convert string bag / discard to int
        int bagValue = Integer.parseInt(bag);
        int discardValue = Integer.parseInt(discard);
        //check if bag is not empty
        if (bagValue != 0) {
            draw[0] = gs0;
            draw[1] = gs1;
            //return getRandomElement();
            //System.out.println("here");
            String newBag = bag;
            String newDiscard = discard;
            //System.out.println(newBag);
            //System.out.println(newDiscard);
            char y = getReasonableRandomTile(newBag);
            return y;
        }
        // if bag is empty && discard!=0
        else if (bagValue == 0 && discardValue != 0) {
            //draw from discard
            String newBag = discard;
            String newDiscard = "0000000000";

            char y = getReasonableRandomTile(newBag);
            return y;
        }
        // if bag is empty && discard=0 -> done
        else if (bagValue == 0 && discardValue == 0) {
            return 'Z';
        }
        return getRandomElement();
    }

    // to get an element of 'abcde' by random.
    public static char getRandomElement() {
        Random rand = new Random();
        String characters = "abcde";
        char randomChar = characters.charAt(rand.nextInt(characters.length()));
        return randomChar;
    }

    // to get a tile which exists inside the bag.
    public static char getReasonableRandomTile(String bagString) { // from string
        // a -> index 0&1 ->substring -> ==0?
        // do - while
        char wanted = '!';
        boolean bagHasNot = true;
        do {
            char x = getRandomElement();
            int index = 999;
            //get index of x
            switch (x) {
                case 'a':
                    index = 0;
                    break;
                case 'b':
                    index = 2;
                    break;
                case 'c':
                    index = 4;
                    break;
                case 'd':
                    index = 6;
                    break;
                case 'e':
                    index = 8;
                    break;
            }
            //check bag with x
            String bagStrOfX = bagString.substring(index, index + 2);
            int numberOfx = Integer.parseInt(bagStrOfX);
            if (numberOfx != 0) {
                bagHasNot = false;
                wanted = x;
            }
        } while (bagHasNot);
        // char x-> wanted
        return wanted;
    }

    public static char getReasonableRandomTile(int[] intBagTiles) { // from int[5]
        // do - while
        char wanted = '!';
        boolean bagHasNot = true;
        do {
            char x = getRandomElement();
            int index = 999;
            //get index of x
            switch (x) {
                case 'a':
                    index = 0;
                    break;
                case 'b':
                    index = 1;
                    break;
                case 'c':
                    index = 2;
                    break;
                case 'd':
                    index = 3;
                    break;
                case 'e':
                    index = 4;
                    break;
            }
            //check bag with x
            int numberOfx = intBagTiles[index];
            if (numberOfx != 0) {
                bagHasNot = false;
                wanted = x;
            }
        } while (bagHasNot);
        // char x-> wanted
        return wanted;
    }

    public static int getNUmberOfPlayer(String playerState) {
        // get number of players -> extend for 4 players
        int numberOfPlayer = 0;
        int indexA = playerState.indexOf("A");
        int indexB = playerState.indexOf("B");
        int indexC = playerState.indexOf("C");
        int indexD = playerState.indexOf("D");
        int[] player = {indexA, indexB, indexC, indexD};
        StringBuilder sb = new StringBuilder(playerState);
        int numberOfOperations = 0;
        for (int v : player) {
            //在sb中插入“-”,第一位不插，没有的不插
            if (v != -1 && v != 0) {
                sb.insert(v + numberOfOperations, "-");
                numberOfOperations++;
            }
        }
        String newString = sb.toString();
        //split 新string-> String[]。array包含每个playerString
        String[] string1Array = newString.split("-");
        //key result
        int wellFormedPlayer = 0;
        for (String playerString : string1Array) {
            numberOfPlayer++;
        }
        return numberOfPlayer;
    }

    /**
     * Given a state, refill the factories with tiles.
     * If the factories are not all empty, return the given state.
     *
     * @param gameState the state of the game.
     * @return the updated state after the factories have been filled or
     * the given state if not all factories are empty.
     * TASK 6
     */
    public static String[] refillFactories(String[] gameState) {
        // FIXME Task 6

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

    /**
     * Given a gameState for a completed game,
     * return bonus points for rows, columns, and sets.
     *
     * @param gameState a completed game state
     * @param player    the player for whom the score is to be returned
     * @return the number of bonus points awarded to this player for rows,
     * columns, and sets
     * TASK 7
     */
    public static int getBonusPoints(String[] gameState, char player) {
        // FIXME Task 7
        return -1;
    }

    /**
     * Given a valid gameState prepare for the next round.
     * 1. Empty the floor area for each player and adjust their score accordingly (see the README).
     * 2. Refill the factories from the bag.
     * * If the bag is empty, refill the bag from the discard pile and then
     * (continue to) refill the factories.
     * * If the bag and discard pile do not contain enough tiles to fill all
     * the factories, fill as many as possible.
     * * If the factories and centre contain tiles other than the first player
     * token, return the current state.
     *
     * @param gameState the game state
     * @return the state for the next round.
     * TASK 8
     */
    public static String[] nextRound(String[] gameState) {
        // FIXME TASK 8
        SharedBoard sharedBoard = new SharedBoard(gameState[0]);
        // if center/fac not empty
        if (!sharedBoard.facIsEmpty()||!sharedBoard.centIsEmpty()){
            return gameState;
        }

        // center/ fac both are empty.
        int numOfPlayer = Player.getNumberOfPlayer(gameState[1]);
        Player[] players = new Player[numOfPlayer];
        String[] playerStrings = Player.getEachPlayerStateString(gameState[1]);
        // create Player[]
        for (int i =0;i<numOfPlayer;i++){
            players[i]=new Player(playerStrings[i]);
        }

        for (Player p: players){
            Floor pFloor = p.getFloor();
            //set next player (set turn)
            if (pFloor.firstPlayerIsInFloor()){

            }

        }




        return null;
    }

    /**
     * Given an entire game State, determine whether the state is valid.
     * A game state is valid if it satisfies the following conditions.
     * <p>
     * [General]
     * 1. The game state is well-formed.
     * 2. There are no more than 20 of each colour of tile across all player
     * areas, factories, bag and discard
     * 3. Exactly one first player token 'f' must be present across all player
     * boards and the centre.
     * <p>
     * [Mosaic]
     * 1. No two tiles occupy the same location on a single player's mosaic.
     * 2. Each row contains only 1 of each colour of tile.
     * 3. Each column contains only 1 of each colour of tile.
     * [Storage]
     * 1. The maximum number of tiles stored in a row must not exceed (row_number + 1).
     * 2. The colour of tile stored in a row must not be the same as a colour
     * already found in the corresponding row of the mosaic.
     * <p>
     * [Floor]
     * 1. There are no more than 7 tiles on a single player's floor.
     * [Centre]
     * 1. The number of tiles in the centre is no greater than 3 * the number of empty factories.
     * [Factories]
     * 1. At most one factory has less than 4, but greater than 0 tiles.
     * Any factories with factory number greater than this factory must contain 0 tiles.
     *
     * @param gameState array of strings representing the game state.
     *                  state[0] = sharedState
     *                  state[1] = playerStates
     * @return true if the state is valid, false if it is invalid.
     * TASK 9
     */
    public static boolean isStateValid(String[] gameState) {
        // FIXME Task 9
        return false;
    }

    /**
     * Given a valid gameState and a move, determine whether the move is valid.
     * A Drafting move is a 4-character String.
     * A Drafting move is valid if it satisfies the following conditions:
     * <p>
     * 1. The specified factory/centre contains at least one tile of the specified colour.
     * 2. The storage row the tile is being placed in does not already contain a different colour.
     * 3. The corresponding mosaic row does not already contain a tile of that colour.
     * Note that the tile may be placed on the floor.
     * </p>
     * <p>
     * A Tiling move is a 3-character String.
     * A Tiling move is valid if it satisfies the following conditions:
     * 1. The specified row in the Storage area is full.
     * 2. The specified column does not already contain a tile of the same colour.
     * 3. The specified location in the mosaic is empty.
     * 4. If the specified column is 'F', no valid move exists from the
     * specified row into the mosaic.
     * </p>
     *
     * @param gameState the game state.
     * @param move      A string representing a move.
     * @return true if the move is valid, false if it is invalid.
     * TASK 10
     */
    public static boolean isMoveValid(String[] gameState, String move) {
        // FIXME Task 10
        return false;
    }

    /**
     * Given a gameState and a move, apply the move to the gameState.
     * If the move is a Tiling move, you must also update the player's score.
     * If the move is a Tiling move, you must also empty the remaining tiles
     * into the discard.
     * If the move is a Drafting move, you must also move any remaining tiles
     * from the specified factory into the centre.
     * If the move is a Drafting move and you must put tiles onto the floor,
     * any tiles that cannot fit on the floor are placed in the discard with
     * the following exception:
     * If the first player tile would be placed into the discard, it is instead
     * swapped with the last tile in the floor, when the floor is sorted
     * alphabetically.
     *
     * @param gameState the game state.
     * @param move      A string representing a move.
     * @return the updated gameState after the move has been applied.
     * TASK 11
     */
    public static String[] applyMove(String[] gameState, String move) {
        // FIXME Task 11
        return null;
    }

    /**
     * Given a valid game state, return a valid move.
     *
     * @param gameState the game state
     * @return a move for the current game state.
     * TASK 13
     */
    public static String generateAction(String[] gameState) {
        // FIXME Task 13
        return null;
        // FIXME Task 15 Implement a "smart" generateAction()
    }
}
