package comp1110.ass2.gui;

import comp1110.ass2.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.StrokeType;

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
     class arrangeMosaic extends TilePane{

     }

}
