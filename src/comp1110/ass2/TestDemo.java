package comp1110.ass2;

public class TestDemo {

    public static String[] nextRound(String[] gameState) {
        // FIXME TASK 8
        SharedBoard sharedBoard = new SharedBoard(gameState[0]);
        StringBuilder nextShareState = new StringBuilder();
        // if center/fac not empty
        if (!sharedBoard.facIsEmpty()||!sharedBoard.centIsEmpty()){
            return gameState;
        }

        // center/ fac both are empty.
        int numOfPlayer = Player.getNumberOfPlayer(gameState[1]);
        StringBuilder newPlayerStates = new StringBuilder();
        Player[] players = new Player[numOfPlayer];
        String[] playerStrings = Player.getEachPlayerStateString(gameState[1]);
        // create Player[]
        for (int i =0;i<numOfPlayer;i++){
            players[i]=new Player(playerStrings[i]);
        }

        for (Player p: players){
            //set next player (set turn) / add Fp into center
            if (p.floor.firstPlayerIsInFloor()){
                sharedBoard.nextPlayer=p.playerName.name;
                sharedBoard.facCentre.centre.tiles.add(Tiles.FP);
            }
            //set score
            p.score+=p.floor.loseMarks();
            //empty floor to discard
            sharedBoard.bagDiscard.discard.acceptTiles(p.floor.emptyFloorToDiscard());
            newPlayerStates.append(p.toString());
        }

        sharedBoard.toString();
        String[] result = new String[2];
        result[0]=sharedBoard.toString();
        result[1]=newPlayerStates.toString();



        return result;
    }
    public static void main(String[] args) {
        String[] a = nextRound(new String[]{"AFCB0712090708D0000000000", "A36Mb01d03e04e10a11c13d14d20a22b23c24e32a33b34d42e43S0a11b22e33c3FeeeB25Ma00b01e10a11b12d14d20e21c24c30b40c41a44S0c11c22a33d4Faaadddf"});

        System.out.println(a[0]);
        System.out.println(a[1]);
    }
}
