package comp1110.ass2.gui;

import comp1110.ass2.Azul;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.effect.DropShadow;
import javafx.stage.Stage;

import javafx.scene.control.Button;
import javafx.scene.image.ImageView;

public class Game extends Application {
    /* board layout */
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





    //creating the image object
    /**    try{
     Image image = this.drawImage("assets/drafting_c.png");
     displayImage(image);
     }catch (FileNotFoundException e) {
     e.printStackTrace();
     }
     }
     private Image drawImage(String imagePath) throws FileNotFoundException {
     InputStream stream = new FileInputStream(imagePath);
     Image image = new Image(stream);
     return image;
     }
     private void displayImage(Image image) throws FileNotFoundException {
     ImageView imageView = new ImageView();
     imageView.setImage(image);
     //Setting the image view parameters
     imageView.setX(10);
     imageView.setY(10);
     imageView.setFitWidth(100);
     imageView.setPreserveRatio(true);
     controls.getChildren().add(imageView);
     }*/

    Azul azul;

    private static DropShadow dropShadow;

    {
        dropShadow = new DropShadow();
        dropShadow.setOffsetX(2.0);
        dropShadow.setOffsetY(2.0);
   //     dropShadow.setColor(Tiles);

    }

    class gameTile extends ImageView{
        int tileID;

        gameTile(char tile) {
            if (tile>'f' || tile<'a'){
                throw new IllegalArgumentException("Bad tile: \" " + tile + "\"");
            }
            this.tileID = tile - 'a';
            setFitHeight(TILE_X);
            setFitWidth(TILE_Y);
            setEffect(dropShadow);
        }
    }









    @Override
    public void start(Stage stage) throws Exception {
        //  FIXME Task 12: Implement a basic playable Azul game in JavaFX that only allows tiles to be placed in valid places=



        //  FIXME Task 14: Implement a computer opponent so that a human can play your game against the computer.
        stage.setTitle("Azul");
        Group root = new Group();

        Scene scene = new Scene(root, BOARD_WIDTH, BOARD_HEIGHT);

        stage.setScene(scene);
        stage.show();
    }
}
