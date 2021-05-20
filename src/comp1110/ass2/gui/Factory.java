package comp1110.ass2.gui;

import javafx.scene.layout.Pane;

import java.util.ArrayList;

/**
 * @author Mukund Balaji Srinivas
 **/
public class Factory extends Pane {
    public static int SQUARE_SIZE = 50;
    public static int MARGIN = 50;
    ArrayList<Tile> facs = new ArrayList<>();

    Factory() {
        Tile temp;
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                temp = new Tile(j, SQUARE_SIZE * i, SQUARE_SIZE * j);
                facs.add(temp);
            }
        }
        this.getChildren().addAll(facs);
    }
}
