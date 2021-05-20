package comp1110.ass2.gui;

import javafx.scene.layout.Pane;

import java.util.ArrayList;

/**
 * @author Mukund Balaji Srinivas
 **/
class StorageMosaic extends Pane {
    private static final int SQUARE_SIZE = 50;
    private static final int MARGIN_X = 100;
    private static final int MARGIN_Y = 50;
    private static final int PLAY_AREA_X = 250;
    private static final int PLAY_AREA_Y = 250;
    private static final int GAP_BW = 100;
    public ArrayList<Tile> mosaicTiles = new ArrayList<>();
    public ArrayList<Tile> storageTiles = new ArrayList<>();
    public Pane mosaicPane = new Pane();
    public Pane storagePane = new Pane();

    //Constructor to add them to this pane
    StorageMosaic() {
        setMosaic();
        setStorage();
        this.getChildren().add(mosaicPane);
        this.getChildren().add(storagePane);
    }

    //Set the mosaic tiles in the square setup
    public void setMosaic() {
        Tile TempTile;
        for (int i = 1; i <= 5; i++) {
            for (int j = 1; j <= 5; j++) {
                TempTile = new Tile(i, SQUARE_SIZE * i, SQUARE_SIZE * j);
                mosaicTiles.add(TempTile);
            }
        }
        mosaicPane.getChildren().addAll(mosaicTiles);
        mosaicPane.setLayoutX(MARGIN_X + PLAY_AREA_X + GAP_BW);
        mosaicPane.setLayoutY(350);
    }

    //Set the Storage tiles in the L shape setup
    public void setStorage() {
        Tile TempTile;
        for (int i = 1; i <= 5; i++) {
            for (int j = 1; j <= i; j++) {
                TempTile = new Tile(i, SQUARE_SIZE * j, SQUARE_SIZE * i);
                storageTiles.add(TempTile);
            }
        }
        storagePane.getChildren().addAll(storageTiles);
        storagePane.setLayoutX(MARGIN_X);
        storagePane.setLayoutY(350);
    }

    /**
     * find the nearest grid value of the given mouse pointer
     * @param mouse_x The present value of the mouse pointer
     * @return The Layout x of the given mouse pointer
     */
    public double retX(double mouse_x) {
        double retVal = 0;
        for (int i = 0; i < mosaicTiles.size() - 1; i++) {
            if (mouse_x >= mosaicTiles.get(i).getLayoutX() && mouse_x < mosaicTiles.get(i + 1).getLayoutX()) {
                retVal = mosaicTiles.get(i).getLayoutX();
            }
        }
        return retVal;
    }
    /**
     * find the nearest grid value of the given mouse pointer
     * @param mouse_y The present value of the mouse pointer
     * @return The Layout x of the given mouse pointer
     */
    public double retY(double mouse_y) {
        double retVal = 0;
        for (int i = 0; i < mosaicTiles.size() - 1; i++) {
            if (mouse_y >= mosaicTiles.get(i).getLayoutY() && mouse_y < mosaicTiles.get(i + 1).getLayoutY()) {
                retVal = mosaicTiles.get(i).getLayoutY();
            }
        }
        return retVal;
    }


}