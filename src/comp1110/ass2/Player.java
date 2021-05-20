package comp1110.ass2;

import java.util.Random;

/**
 * @author Mukund Balaji Srinivas & Ke Ning
 **/
public class Player {
    public Names playerName;
    public int score;
    public Mosaic mosaic;
    public Storage storage;
    public Floor floor;


    public static final String[] Names = {"A", "B", "C", "D"};
    public Player nextPlayer;


    public Player(char c) {
        this.playerName = comp1110.ass2.Names.getNamesByChar(c);
        this.score = 0;
        this.mosaic = new Mosaic();
        this.storage = new Storage();
        this.floor = new Floor();
    }

    public Player(String singlePlayerState) {
        int indexOfM = singlePlayerState.indexOf("M");
        int indexOfS = singlePlayerState.indexOf("S");
        int indexOfF = singlePlayerState.indexOf("F");
        // name and score
        this.playerName = comp1110.ass2.Names.getNamesByString(singlePlayerState.substring(0, 1));
        this.score = Integer.parseInt(singlePlayerState.substring(1, indexOfM));
        // mosaic
        String givenMosaic = singlePlayerState.substring(indexOfM, indexOfS);
        this.mosaic = new Mosaic(givenMosaic);
        //storage
        String givenStorage = singlePlayerState.substring(indexOfS, indexOfF);
        this.storage = new Storage(givenStorage);
        //floor
        String givenFloor = singlePlayerState.substring(indexOfF);
        this.floor = new Floor(givenFloor);

    }

    public Names getName() {
        return playerName;
    }

    public int getScore() {
        return score;
    }

    public Mosaic getMosaic() {
        return mosaic;
    }

    public Storage getStorage() {
        return storage;
    }

    public Floor getFloor() {
        return floor;
    }


    /**
     * Set the next player, who should be playing after the present player
     *
     * @param nPlayer Player that has to be set as the next player
     */
    void setNextPlayer(Player nPlayer) {
        this.nextPlayer = nPlayer;
    }


    /**
     * Split the total combined state string of all players into a String[]. The members in String[]
     * are the state string for each player.
     *
     * @param totalPlayerState the total combined player state string for all players, state1
     * @return String[] playerStringArray. A String array with every player state string for each index
     * in alphabet order of player.
     */

    public static String[] getEachPlayerStateString(String totalPlayerState) {
        // get number of players -> extend for 4 players
        int numberOfPlayer = 0;
        int indexA = totalPlayerState.indexOf("A");
        int indexB = totalPlayerState.indexOf("B");
        int indexC = totalPlayerState.indexOf("C");
        int indexD = totalPlayerState.indexOf("D");
        int[] player = {indexA, indexB, indexC, indexD};
        StringBuilder sb = new StringBuilder(totalPlayerState);
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
        String[] playerStringArray = newString.split("-");
        //key result

        return playerStringArray;
    }

    /**
     * Get Player[] using total-player-state String.
     * @param totalPlayerState "A20Ma02a13b00e42S2a13e44a1FaabbeB30Mc01b11d21S0e12b2F"
     * @return Player[]
     */
    public static Player[] getPlayers(String totalPlayerState){
        String[] playerStringArray = getEachPlayerStateString(totalPlayerState);
        int playerNum = playerStringArray.length;
        Player[] result = new Player[playerNum];

        for (int i =0; i<playerNum;i++){
            result[i]=new Player(playerStringArray[i]);
        }

        return result;
    }


    /**
     * check get the number of players with the given combined total playerState string for all players.
     *
     * @param totalPlayerState the total combined player state string for all players, state1
     * @return int numberOfPlayer. return 999 if the number of player >=5.
     */
    public static int getNumberOfPlayer(String totalPlayerState) {
        // get number of players -> extend for 4 players
        int numberOfPlayer = 0;
        int indexA = totalPlayerState.indexOf("A");
        int indexB = totalPlayerState.indexOf("B");
        int indexC = totalPlayerState.indexOf("C");
        int indexD = totalPlayerState.indexOf("D");
        int indexE = totalPlayerState.indexOf("E");

        int[] player = {indexA, indexB, indexC, indexD};
        if (indexA == -1 && indexB == -1 && indexC == -1 && indexD == -1) {
            numberOfPlayer = 0;
        } else if (indexE != -1) {
            numberOfPlayer = 999;
        } else {
            StringBuilder sb = new StringBuilder(totalPlayerState);
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

            for (String playerString : string1Array) {
                numberOfPlayer++;
            }
        }
        return numberOfPlayer;
    }

    /**
     * get bonus points
     * @return
     */
    public int scoringBonusPoint(){
        Tiles[][] tiles = this.mosaic.getTiles();
        int result =0;
        int[] row = new int [5];
        int []col =new int [5];
        int set[] = new int [5];

        for (int i =0; i<5;i++){
            for(int j=0; j<5;j++){
                if (tiles[i][j]!=Tiles.E){
                    row[i]++;
                    col[j]++;
                    set[tiles[i][j].ordinal()]++;
                }
            }
        }

        for(int i = 0; i<5;i++){
            if(row[i]==5) {
                result += 2;
            }
        }
        for(int i =0;i<5;i++){
            if(col[i]==5){
                result += 7;
            }
        }
        for(int i =0;i<5;i++){
            if(set[i]==5){
                result += 10;
            }
        }
        return result;
    }



//--------------------------------------------old-------------------------------------------------------------------------//
    /**
     * @param intBagTiles
     * @return
     */
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

    public static char getRandomElement() {
        Random rand = new Random();
        String characters = "abcde";
        char randomChar = characters.charAt(rand.nextInt(characters.length()));
        return randomChar;
    }

    /*
    public static void main(String[] args) {
        String[] playerStringArray = getEachPlayerStateString("A20Ma02a13b00e42S2a13e44a1FaabbeB30Mc01b11d21S0e12b2F");
        int num = getNumberOfPlayer("A20Ma02a13b00e42S2a13e44a1FaabbeB30Mc01b11d21S0e12b2F");

        System.out.println(num);
        System.out.println(playerStringArray.length);
    }
    */


}
