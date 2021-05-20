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
    public ArrayList<Board.Tile> mosaicTiles = new ArrayList<>();
    public ArrayList<Board.Tile> storageTiles = new ArrayList<>();
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
        Board.Tile TempTile;
        for (int i = 1; i <= 5; i++) {
            for (int j = 1; j <= 5; j++) {
                TempTile = new Board.Tile(i, SQUARE_SIZE * i, SQUARE_SIZE * j);
                mosaicTiles.add(TempTile);
            }
        }
        mosaicPane.getChildren().addAll(mosaicTiles);
        mosaicPane.setLayoutX(MARGIN_X + PLAY_AREA_X + GAP_BW);
        mosaicPane.setLayoutY(350);
    }

    //Set the Storage tiles in the L shape setup
    public void setStorage() {
        Board.Tile TempTile;
        for (int i = 1; i <= 5; i++) {
            for (int j = 1; j <= i; j++) {
                TempTile = new Board.Tile(i, SQUARE_SIZE * j, SQUARE_SIZE * i);
                storageTiles.add(TempTile);
            }
        }
        storagePane.getChildren().addAll(storageTiles);
        storagePane.setLayoutX(MARGIN_X);
        storagePane.setLayoutY(350);
    }


}