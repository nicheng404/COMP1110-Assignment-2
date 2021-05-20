package comp1110.ass2.gui;

/**
 * @author Mukund Balaji Srinivas
 **/

import comp1110.ass2.Tiles;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.FileInputStream;

class playerTile extends ImageView {
    public Tiles tile;
    public Image Image;
    public static int SQUARE_SIZE = 50;
    public static String BASE_URI = "assets/";

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
