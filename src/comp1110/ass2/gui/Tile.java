package comp1110.ass2.gui;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.StrokeType;

class Tile extends Rectangle {
    public static final int SQUARE_SIZE = 50;

    /**
     * A tiles that  Inherits from Rectangle and sets the colour and position
     */
    Tile(int colorVal, int x, int y) {
        setWidth(SQUARE_SIZE);
        setHeight(SQUARE_SIZE);
        setX(x);
        setY(y);
        setFill(Color.rgb(colorVal * 5, (colorVal * 5) + 50, (colorVal * 5) + 80));
        setStroke(Color.BLACK);
        setStrokeType(StrokeType.OUTSIDE);
    }
}

