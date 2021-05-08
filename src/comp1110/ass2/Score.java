package comp1110.ass2;

public class Score {

    public static final char HEAD = 'S';
    public int inputScore;

    public Score (String singlePlayerState){
        this.inputScore=getScore(singlePlayerState);
    }


    /**'
     * Get the input current score from a singlePlayerState String.
     *
     * @param singlePlayerState The playerState for that certain player.
     *                          e.g."A20Ma02a13b00e42S2a13e44a1Faabbe"
     * @return His score. In this case, 20.
     */
    public static int getScore (String singlePlayerState){
        int result =0;
        int index0M = singlePlayerState.indexOf("M");
        String scoreDemo1 = singlePlayerState.substring(0,index0M);
        String scoreDemo2 = scoreDemo1.substring(1);
        result = Integer.parseInt(scoreDemo2);
        return result;
    }

    // check if there are tiles adjacent to the tile
    public static boolean checkForAdjacentTiles() {
        return false;
    }




    public static void main(String[] args) {
        int a =getScore("A20Ma02a13b00e42S2a13e44a1Faabbe");
        System.out.println(a);
    }



}