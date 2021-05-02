package comp1110.ass2;

public class Score {

    public static final char HEAD = 'S';
    public int scoreNow;

    // check if there are tiles adjacent to the tile
    public static boolean checkForAdjacentTiles() {
        return false;
    }

    /**'
     * Get the current score of a certain player.
     *
     * @param singlePlayerState The playerState for that certain player.
     * @return His score.
     */
    public static int getScore (String singlePlayerState){
        int result =0;
        int index0M = singlePlayerState.indexOf("M");
        String scoreDemo1 = singlePlayerState.substring(0,index0M);
        String scoreDemo2 = scoreDemo1.substring(1);
        result = Integer.parseInt(scoreDemo2);
        return result;
    }



}