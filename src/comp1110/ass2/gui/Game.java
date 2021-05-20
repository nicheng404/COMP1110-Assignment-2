package comp1110.ass2.gui;

import comp1110.ass2.Azul;
import comp1110.ass2.Storage;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

import javafx.scene.control.Button;

public class Game extends Application {
    /* board layout */
    Azul azul;
    private static final int BOARD_WIDTH = 1200;
    private static final int BOARD_HEIGHT = 700;
    private static final int TILE_X = 10;
    private static final int TILE_Y = 10;
    private static final String URI_BASE = "assets/";
    private final Group board = new Group();
    private final Group controls = new Group();
    private final Group root = new Group();
    private final Group gameTiles = new Group();
    Button button = new Button("Next Round");



    @Override
    public void start(Stage stage) throws Exception {
        //  FIXME Task 12: Implement a basic playable Azul game in JavaFX that only allows tiles to be placed in valid places=
        StorageMosaic StMos = new StorageMosaic();



        //  FIXME Task 14: Implement a computer opponent so that a human can play your game against the computer.
        stage.setTitle("Azul");
        Group root = new Group();

        Scene scene = new Scene(root, BOARD_WIDTH, BOARD_HEIGHT);

        stage.setScene(scene);
        stage.show();
    }
}
