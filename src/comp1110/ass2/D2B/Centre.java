package comp1110.ass2.D2B;

import java.util.function.Predicate;

public  class Centre implements DraftingFunctions {
    public Tiles[] tiles;

    public Centre(Tiles[] tiles) {
        this.tiles = tiles;
    }

    @Override
    public Tiles[] getTiles() {
        return tiles;
    }

    @Override
    public Tiles[] getSameColour() {
        for(Tiles t:tiles)
        {

        }

    }
}
