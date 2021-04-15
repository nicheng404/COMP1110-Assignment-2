package comp1110.ass2.D2B;

public class PlayerBoard {
    public Tiles[][] storage;
    public Tiles[][] mosaic;
    public Tiles[][] mosaicVariant;
    public Tiles[] floor;
    public Player tPlayer;
    public
    /**
     * Set the Variants for the individual player boards;
     */
    void setMosaicConf() {
        Tiles[][] conf = new Tiles[5][5];

        this.mosaicVariant = conf;
    }
}
