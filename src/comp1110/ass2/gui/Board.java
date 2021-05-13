//Bring the various components of Board together
package comp1110.ass2.gui;

import comp1110.ass2.*;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.StrokeType;

import java.io.FileInputStream;
import java.util.ArrayList;

//A Class that will Set the Board Gui Including Storage,Mosaic and factory
public class Board extends Pane {

    private static final String BASE_URI = "assets/";
    private static final int TILE_HEIGHT = 50;
    private static final int TILE_WIDTH = 50;
    private static final int MARGIN_X = 50;
    private static final int MARGIN_Y = 50;

    //Graphical elements
    arrangeMosaic mosaic;
    arrangeStorage storage;

    static class Tile extends Rectangle {
        public int colorVal;
        /**
         * A tiles that  Inherits from Rectangle and sets the colour and position
         */
        Tile(int colorVal, int x, int y) {
            setWidth(TILE_WIDTH);
            setHeight(TILE_HEIGHT);
            setX(x);
            setY(y);
            setFill(Color.rgb(colorVal * 5, (colorVal * 5) + 50, (colorVal * 5) + 80));
            setStroke(Color.BLACK);
            setStrokeType(StrokeType.OUTSIDE);
        }

    }

    //Arrange the mosaic without Using TilePane. This is done because I wanna use the same method for making Storage tiles
    static class arrangeMosaic extends Pane {
        public int nTiles;
        public ArrayList<Tile> tiles = new ArrayList<>();

        arrangeMosaic(int nTiles) {
            this.nTiles = nTiles;
            Tile TempTile;
            for (int i = 1; i <= (int) Math.sqrt(nTiles); i++) {
                for (int j = 1; j <= (int) Math.sqrt(nTiles); j++) {
                    TempTile = new Tile(i, TILE_WIDTH * i, TILE_HEIGHT * j);
                    tiles.add(TempTile);
                }
            }
            this.getChildren().addAll(tiles);
        }
    }



    static class arrangeStorage extends Pane {
        public static final int nRows = 5;
        public ArrayList<Tile> tiles = new ArrayList<>();

        /**
         * A class for arranging tiles in the given pattern like the storage
         *
         * @author Mukund Balaji Srinivas
         */
        arrangeStorage() {
            Tile TempTile;
            for (int i = 1; i <= nRows; i++) {
                for (int j = 1; j <= i; j++) {
                    TempTile = new Tile(i, TILE_HEIGHT * j, TILE_WIDTH * i);
                    tiles.add(TempTile);
                }
            }
            this.getChildren().addAll(tiles);
        }

        /**
         * Get the x co-ordinates of the tile nearest to the corresponding mouse pointer
         *
         * @param mouseX The present x position of the mouse pointer
         * @return The getlayoutX value of the tile corresponding to the mouse pointer.
         */
        public double getXbounds(double mouseX) {
            double retVal = 0;
            try {
                for (int i = 0; i < tiles.size(); i++) {
                    if (tiles.get(i).getLayoutX() >= mouseX && tiles.get(i + 1).getLayoutX() < mouseX) {
                        retVal = tiles.get(i).getLayoutX();
                    }
                }
            } catch (Exception e) {
                retVal = tiles.get(tiles.size() - 1).getLayoutX();
            }
            return retVal;
        }
    }


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
            setFitHeight(TILE_HEIGHT);
            setFitWidth(TILE_WIDTH);
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
