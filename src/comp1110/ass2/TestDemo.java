package comp1110.ass2;

import java.util.Arrays;

import static comp1110.ass2.Factory.refillFactories;

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
        String[] input = new String[]{"BF0bcdd1bbbc2aaad3acde4abceCfB0000000000D1110100612", "A31Mb01d03e04e10c13d14d20a22b23c24e32a33b34e43S4d2FB10Ma00b01e10b12d14d20e21c30c41a44S2c23d3F"};
        SharedBoard sb = new SharedBoard(input[0]);
        Player[] players =Player.getPlayers(input[1]);

        int[] shareNum=sb.getNumberOfTiles();
        for(int i:shareNum){
            System.out.println(i);
        }

        System.out.println("-----------------");

        int[][] playerNumDemo = new int[Player.getNumberOfPlayer(input[1])][6];
        for(int i=0;i<Player.getNumberOfPlayer(input[1]);i++){
            playerNumDemo[i]=players[i].getNumberOfTiles();
        }

        int[] playerNum = new int[6];
        for (int i=0;i<6;i++){
            for (int j=0;j<Player.getNumberOfPlayer(input[1]);j++){
                playerNum[i]+=playerNumDemo[j][i];
            }
        }

        for(int i:playerNum){
            System.out.println(i);
        }

        int[] tilesNumInCenterArray = sb.facCentre.centre.getNumberOfTiles();
        int tilesNumInCenter = Arrays.stream(tilesNumInCenterArray).sum();
        System.out.println(tilesNumInCenter);

    }
}
