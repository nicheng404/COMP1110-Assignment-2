package comp1110.ass2.gui;

import comp1110.ass2.Tiles;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Viewer extends Application {

    private static final int VIEWER_WIDTH = 1200;
    private static final int VIEWER_HEIGHT = 700;


    static class DTile extends playerTile {
        public StorageMosaic stoMos;
        double mouseX, mouseY;

        DTile(Tiles t) {
            super(t);
            stoMos = new StorageMosaic();
            setOnMouseClicked(event -> {
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
                double getmouseX = stoMos.retX(mouseX);
                double getmouseY = stoMos.retY(mouseY);
                setLayoutX(getmouseX);
                setLayoutY(getmouseY);
                event.consume();
            });
        }
        public StorageMosaic getStoMos(){
            return stoMos;
        }


    }

    @Override
    public void start(Stage stage) throws Exception {
        DTile d = new DTile(Tiles.O);
        Group group = new Group();
        group.getChildren().add(d);
        group.getChildren().add(d.getStoMos());
        Scene scene = new Scene(group,VIEWER_WIDTH,VIEWER_HEIGHT);
        scene.setFill(Color.BEIGE);
        stage.setScene(scene);
        stage.show();
    }
}


