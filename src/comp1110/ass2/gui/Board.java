package comp1110.ass2.gui;

import comp1110.ass2.*;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.StrokeType;

public class Board extends Pane {
    private static final int BOARD_WIDTH = 1200;
    private static final int BOARD_HEIGHT = 700;
    private Rectangle[][] board;
    private Tiles color;

    public Board() {
        board = new Rectangle[BOARD_WIDTH][BOARD_HEIGHT];

        for (int x = 0; x < BOARD_WIDTH; x++) {
            for (int y = 0; y < BOARD_HEIGHT; y++) {
                board[x][y] = new Rectangle();
                board[x][y].setWidth(50);
                board[x][y].setHeight(50);
                board[x][y].setStroke(Color.TRANSPARENT);
                board[x][y].setStrokeType(StrokeType.INSIDE);
                board[x][y].setStrokeWidth(1);
            }
        }
    }

   public Tiles getColor(){
        return color;
   }

    private Discard[][] discardTiles = new Discard[4][4];
    private Bag[][] bagTiles = new Bag[4][4];
    private Centre[][] centreTiles = new Centre[4][4];

    private Factory[][] factoryTiles = new Factory[1][9];



private void addTileToMosaic(String placement){
    GameTile tile = new GameTile(placement);

}

private void allTileToBag(String placement){

}

private void addTileToStorage(String placement){

}

private void updateTiles(GameTile tile) {
    Location location = tile.getLocation();
}







}
