package comp1110.ass2.D2B;

public class Player {

    public static final String[] Names = {"A","B","C","D"};
    public Player nextPlayer;
    public String pName;
    public boolean isFirstPlayer;

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
     * @return The name of this player from "A-D"
     */
    public String getpName() {
        return this.pName;
    }

    /**
     * Get the next player f
     */


}
