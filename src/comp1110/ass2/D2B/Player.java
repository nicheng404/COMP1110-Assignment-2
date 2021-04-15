package comp1110.ass2.D2B;

public class Player {

    public Player nextPlayer;
    private static int nPlayers;

    /**
     * Set the next player, who should be playing after the present player
     *
     * @param nPlayer Player that has to be set as the next player
     */
    void setNextPlayer(Player nPlayer) {
        this.nextPlayer = nPlayer;
    }

}
