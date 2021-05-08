package comp1110.ass2.gui;

import comp1110.ass2.*;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.StrokeType;
import javafx.stage.Stage;

import java.util.ArrayList;

//A Class that will Set the Board Gui Including Storage,Mosaic and factory
public class Board extends Application {
    private static final int BOARD_WIDTH = 1200;
    private static final int BOARD_HEIGHT = 700;

    class Tile extends Rectangle {
        public int colorVal;

        Tile(int colorVal, int x, int y) {
            setWidth(50);
            setHeight(50);
            setX(x);
            setY(y);
            setFill(Color.rgb(colorVal * 5, (colorVal * 5) + 50, (colorVal * 5) + 80));
            setStroke(Color.BLACK);
            setStrokeType(StrokeType.OUTSIDE);
        }

    }

    //Arrange the mosaic without Using TilePane. This is done because I wanna use the same method for making Storage tiles
    class arrangeMosaic extends Pane {
        public int nTiles;
        public ArrayList<Tile> tiles = new ArrayList<>();

        arrangeMosaic(int nTiles) {
            this.nTiles = nTiles;
            Tile TempTile;
            for (int i = 1; i <= (int) Math.sqrt(nTiles); i++) {
                for (int j = 1; j <= (int) Math.sqrt(nTiles); j++) {
                    TempTile = new Tile(i, 50 * i, 50 * j);
                    tiles.add(TempTile);
                }
            }
            this.getChildren().addAll(tiles);
        }
    }

    class arrangeStorage extends Pane {
        public static final int nRows = 5;
        public ArrayList<Tile> tiles = new ArrayList<>();

        arrangeStorage() {
            Tile TempTile;
            for (int i = 1; i <= nRows; i++) {
                for (int j = 1; j <= i; j++) {
                    TempTile = new Tile(i, 50 * j, 50 * i);
                    tiles.add(TempTile);
                }
            }
            this.getChildren().addAll(tiles);
        }
    }

    public void start(Stage stage) {
        arrangeMosaic mosTiles = new arrangeMosaic(25);
        arrangeStorage storageTiles = new arrangeStorage();
        Scene scene = new Scene(storageTiles, BOARD_WIDTH, BOARD_HEIGHT);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

}
