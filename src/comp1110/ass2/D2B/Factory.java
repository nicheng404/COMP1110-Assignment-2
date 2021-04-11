package comp1110.ass2.D2B;

public class Factory implements CommonAreaFunctions {
    public Tiles[] tiles;
    public Factory(Tiles[] tiles) {
        this.tiles = tiles;
    }

    public Tiles[] getTiles() {
        return tiles;
    }
}
