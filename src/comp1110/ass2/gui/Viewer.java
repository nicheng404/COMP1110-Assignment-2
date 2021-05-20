package comp1110.ass2.gui;

import comp1110.ass2.Tiles;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.robot.Robot;
import javafx.stage.Stage;


public class Viewer extends Application {

    private static final int VIEWER_WIDTH = 1200;
    private static final int VIEWER_HEIGHT = 700;
    private static final int MARGIN_X = 100;
    private static final int PLAY_AREA_X = 250;
    private static final int GAP_BW = 100;


    static class DTile extends playerTile {
        double mouseX, mouseY;
        public StorageMosaic stoMo;

        DTile(Tiles t) {
            super(t);
            stoMo = new StorageMosaic();

            setOnMousePressed(event -> {
                mouseX = event.getSceneX();
                mouseY = event.getSceneY();
            });
            setOnMouseDragged(event -> {
                toFront();
                double movementX = event.getSceneX() - mouseX;
                double movementY = event.getSceneY() - mouseY;
                setLayoutX(getLayoutX() + movementX);
                setLayoutY(getLayoutY() + movementY);
                mouseX = event.getSceneX();
                mouseY = event.getSceneY();
                event.consume();

            });
            setOnMouseReleased(event -> {
                double snapX, snapY;
                snapX = getStoMo().retX(getLayoutX());
                snapY = getStoMo().retY(getLayoutY());
                System.out.println(snapX);
                System.out.println(snapY);
            });
        }


        public StorageMosaic getStoMo() {
            return stoMo;
        }

        /**
         * Snap to grid
         */
        public void snapToGrid() {
            double snapX, snapY;
            if (OnBoard()) {
                snapX = getStoMo().retX(getLayoutX());
                snapY = getStoMo().retY(getLayoutY());

            }
        }


        public boolean OnBoard() {
            return getLayoutX() >= MARGIN_X + PLAY_AREA_X + GAP_BW && getX() < MARGIN_X + PLAY_AREA_X + GAP_BW + 250
                    && getY() >= 350 && getY() < 350 + 250;

        }

    }

    @Override
    public void start(Stage stage) {
        DTile d = new DTile(Tiles.O);
        Group group = new Group();
        group.getChildren().add(d.getStoMo());
        group.getChildren().add(d);
        Scene scene = new Scene(group, VIEWER_WIDTH, VIEWER_HEIGHT);
        scene.setFill(Color.BEIGE);
        stage.setScene(scene);
        stage.show();
    }
}


