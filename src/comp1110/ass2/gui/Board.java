//Bring the various components of Board together
package comp1110.ass2.gui;

import comp1110.ass2.*;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.StrokeType;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.util.ArrayList;

//A Class that will Set the Board Gui Including Storage,Mosaic and factory
public class Board extends Pane {

    private static final String BASE_URI = "assets/";
    private static final int SQUARE_SIZE = 50;
    private static final int MARGIN_X = 100;
    private static final int MARGIN_Y = 50;

    static class Tile extends Rectangle {
        public int colorVal;

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

    //Arrange the mosaic without Using TilePane. This is done because I wanna use the same method for making Storage tiles



    static class playerTile extends ImageView {
        public Tiles tile;
        public Image Image;

        /**
         * This constructor takes the input as Tile and represents it in the game
         *
         * @param tile An object of the type Tiles that represents a tile
         * @author Mukund Balaji Srinivas
         */
        playerTile(Tiles tile) {
            setFitHeight(SQUARE_SIZE);
            setFitWidth(SQUARE_SIZE);
            this.tile = tile;
            setImg();
        }

        public void setImg() {
            StringBuilder tileName = new StringBuilder();
            FileInputStream fileURI = null;
            for (Tiles t : Tiles.values()) {
                if (tile.equals(t)) {
                    tileName.append(t.longName).append("-").append(t.encode)
                            .append("_tile.png");
                }
            }
            try {
                fileURI = new FileInputStream(BASE_URI + tileName.toString());
            } catch (Exception e) {
                System.out.println("This file does not exist");
            }
            Image = new Image(fileURI);
            setImage(Image);
        }
    }

    class DTile extends playerTile {
        int homeX, homeY;
        double mouseX, mouseY;

        public DTile(Tiles tile) {
            super(tile);
            homeX = MARGIN_X;
            homeY = MARGIN_Y;
            setOnMouseClicked(e -> {
                mouseX = e.getSceneX();
                mouseY = e.getSceneY();
            });
            setOnMouseDragged(e -> {
                toFront();
                double movementX = e.getSceneX() - mouseX;
                double movementY = e.getSceneY() - mouseY;
                setLayoutX(getLayoutX() + movementX);
                setLayoutY(getLayoutY() + movementY);
                mouseX = e.getSceneX();
                mouseY = e.getSceneY();
                e.consume();
            });
        }


    }


}

