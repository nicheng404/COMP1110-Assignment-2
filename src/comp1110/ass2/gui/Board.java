package comp1110.ass2.gui;

import comp1110.ass2.*;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.StrokeType;
import javafx.stage.Stage;

public class Board extends Pane {
    private static final int BOARD_WIDTH = 1200;
    private static final int BOARD_HEIGHT = 700;

    class Tile extends Rectangle {
        public int colorVal;

        Tile(int colorVal, int x, int y) {
            setWidth(50);
            setHeight(50);
            setLayoutX(x);
            setLayoutY(y);
            setFill(Color.rgb(colorVal * 5, (colorVal * 5) + 50, (colorVal * 5) + 80));
            setStroke(Color.BLACK);
            setStrokeType(StrokeType.OUTSIDE);
        }

    }

    class arrangeMosaic extends TilePane {
        public int nTiles;
        public Tile[] tiles;

        arrangeMosaic(int nTiles) {
            this.nTiles = nTiles;
            this.tiles = new Tile[nTiles];
            for (int i = 0; i < nTiles; i++) {
                tiles[i] = new Tile(i, i + 5, i + 5);
                this.getChildren().add(tiles[i]);
            }
            this.setPrefColumns((int) Math.sqrt(nTiles));
        }
    }
    public void start(Stage stage){
        arrangeMosaic mosTiles = new arrangeMosaic(25);
        AnchorPane ap = new AnchorPane();
        ap.setLayoutX(100);
        ap.setLayoutY(100);
        ap.getChildren().add(mosTiles);
        Scene scene = new Scene(ap,BOARD_WIDTH,BOARD_HEIGHT);
        mosTiles.setPrefColumns(5);
        mosTiles.setPrefColumns(5);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

}
