package comp1110.ass2.gui;

import comp1110.ass2.Tiles;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
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
        }

        public StorageMosaic getStoMo() {
            return stoMo;
        }

    }

    @Override
    public void start(Stage stage) {
        DTile d = new DTile(Tiles.O);
        Group group = new Group();
        GroupFactories groupfacs = new GroupFactories(5);
        group.getChildren().add(d.getStoMo());
        group.getChildren().add(groupfacs);
        group.getChildren().add(d);
        Scene scene = new Scene(group, VIEWER_WIDTH, VIEWER_HEIGHT);
        scene.setFill(Color.BISQUE);
        stage.setScene(scene);
        stage.show();
    }
}


