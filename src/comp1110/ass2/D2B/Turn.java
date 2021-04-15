package comp1110.ass2.D2B;

public class Turn {
    public Factory f;
    public Player p;

    Turn(Player P) {
        this.p = p;
    }

    /**
     * does the player pick from factory
     *
     * @return true if the player picks from factory, false if he picks from centre
     */
    public boolean pickFromFactory() {
        return false;
    }

}
