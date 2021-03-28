package comp1110.ass2.D2B;

public class Player extends CommonArea {

    //public EndState es;

    char[] temporaryPlaceForTiles; // tiles after selecting
    static int numberOfPlayers; // number of players

    char[] floor; // size=7

    char[] storage; // 2D arrays for placing the tiles from ‘Char[] temporaryPlaceForTiles’.
    //White space as **** to set a square.
    char[] mosaic; // 2D arrays for placing the tiles from ‘Char[] temporaryPlaceForTiles’ and
    //Char[] storage

    int score; // the score for each player.

    static void selectTilesFromCentre() {
    }
    // select tiles from the centre. Operate on centre[].

    static void selectTilesFromFactories() {
    }
    // select tiles from factories. Operates on factories[] and centre[]

    void setStorage(char[] givenTemporaryPlaceForTiles, char[] givenStorage,
                    char[] givenMosaic, char[] givenFloor) {
        // set storage base on the temporaryPlaceForTiles and mosaic. Operate on the
        //Char[] givenTemporaryPlaceForTiles, Char[] givenStorage and Char[] floor. Output the //new floor, storages and temporaryPlaceForTiles.
    }

    void setMosaic(char[] givenStorage, char[] givenMosaic, int startScore) {
        // set the Mosaic based on the givenStorage. Operate on the Char[] givenStorage and
        // Char[] givenMosaic. Output the new storage and new Mosaic. Output the score based
        // on the rules.

        // invoke (method) getScores(int startScore);
    }

    int getScores(int startScore, char[] floor) {
        //check whether player gets scores for each time when player places tiles into Mosaic. //Output new score based on the rules and floor.
         return  1 ; // TO DO
    }
        void cleanBoard ( char[] givenStorage, char[] givenFloor, char[] givenMosaic){
            // clean the floor and storage after getting scores. Based on the rules, floor, storage and
            // mosaic. Operate on Char[] givenStorage and Char[] givenFloor. Output Char[] storage
            // and Char[] floor.
        }

        enum EndState {
            Win,
            Lose,
            Draw;
        }

    }

