package comp1110.ass2.D2B;

/**
 * This is an abstract representation of the Shared board components which are Factory,Center,Discard.
 * This class shall act as a common point for consolidating and recording the shared state information.
 * This will help encode the Task2 isSharedStateWellFormed because
 */
public abstract class SharedBoard {
    public int nPlayers;
    SharedBoard(int nPlayers) {
        this.nPlayers = nPlayers;
    }
    public Factory[] F = new Factory[2*nPlayers+1];
    public Centre centre;
    public Bag bag;
    public

}
