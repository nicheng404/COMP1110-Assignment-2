package comp1110.ass2.D2B;

import static comp1110.ass2.Azul.getRandomElement;

public class Player {

    public static final String[] Names = {"A", "B", "C", "D"};
    public Player nextPlayer;
    public String pName;
    public boolean isFirstPlayer;
    public boolean isTurn;
    public Mosaic playerMosaic;
    public Storage PlayerStorage;
    public Floor playerFloor;



    /**
     * Set the next player, who should be playing after the present player
     *
     * @param nPlayer Player that has to be set as the next player
     */
    void setNextPlayer(Player nPlayer) {
        this.nextPlayer = nPlayer;
    }

    /**
     * Get the name of this player
     *
     * @return The name of this player from "A-D"
     */
    public String getpName() {
        return this.pName;
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
     * check get the number of players with the given combined total playerState string for all players.
     *
     * @param totalPlayerState the total combined player state string for all players, state1
     * @return int numberOfPlayer. return 999 if the number of player >=5.
     */
    public static int getNUmberOfPlayer(String totalPlayerState) {
        // get number of players -> extend for 4 players
        int numberOfPlayer = 0;
        int indexA = totalPlayerState.indexOf("A");
        int indexB = totalPlayerState.indexOf("B");
        int indexC = totalPlayerState.indexOf("C");
        int indexD = totalPlayerState.indexOf("D");
        int indexE = totalPlayerState.indexOf("E");

        int[] player = {indexA, indexB, indexC, indexD};
        if (indexA == -1 && indexB == -1 && indexC == -1 && indexD == -1) {
            numberOfPlayer=0;
        } else if (indexE!=-1) {
            numberOfPlayer=999;
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
     *
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


}
