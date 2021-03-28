package comp1110.ass2.D2B;

public class CommonArea {

    // the area including the Factories, Center, Bag, Discard
    // use the char to present the tiles.
    public static final char[] colors ={'b','g','o', 'p','r','f'}; // colors for tiles

    static char[] factories;
    // array of arrays (2D array)randomly with outer indexes // based on players. Shared by all players.

    static char[] centre = new char[101];
    // 1D array based on the factories with initially 0s. [0]=firstplayer.

    static char[] discharge = new char[100];
    // 1D array based on the rules initially 0s.

    static char[] bag= new char[100];
    // 1D array with 100 random tiles.

    static void setBag()
    {
    //Set the elements of the bag to be random
    }


    static void setFactories(int numberOfPlayers) {
        // Create the array of arrays (2D array)randomly with outer indexes based on players. //Shared by all players.
        // make sure the totally number of the tiles<=100 && the number of every tile is<=20
    }


    boolean numberOfTilesAs100(){
        // check the totally number of the tiles<=101 && check the number of every tile is<=20
        // one special tile, firstplayer!!!!!!
        return true;
    }



    //(method) static void selectTilesFromFactories () {}
    // select tiles from factories. Operates on factories[] and centre[]

    // (method) static void selectTilesFromCentre() {}
    // select tiles from the centre. Operate on centre[].


    static void operateDiscard() {
    }
    // operate on discard[]

    static void operateBag() {
    }
// operate on Bag
}