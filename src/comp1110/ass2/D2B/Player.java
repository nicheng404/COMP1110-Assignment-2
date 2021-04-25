package comp1110.ass2.D2B;

public class Player {

    public static final String[] Names = {"A", "B", "C", "D"};
    public Player nextPlayer;
    public String pName;
    public boolean isFirstPlayer;
    public boolean isTurn;

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



    public static String[] getEachPlayerStateString (String totalPlayerState){
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
     * check get the number of players with the given String playerState
     * @param totalPlayerState
     * @return
     */
    public static int getNUmberOfPlayer(String totalPlayerState) {
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
        String[] string1Array = newString.split("-");
        //key result

        for (String playerString : string1Array) {
            numberOfPlayer++;
        }
        return numberOfPlayer;
    }


}
