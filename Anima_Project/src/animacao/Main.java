package animacao;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Translate;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.WindowEvent;

public class Main extends Application {

    private static final String SOURCE = Main.class.getResource("Donkey-Kong-Country-Aquatic-Ambience.mp3").toExternalForm();
    private static final int SCENE_WIDTH = 800;
    private static final int SCENE_HEIGHT = 500;
    private static final int NUMBER_OF_FISHES_GENERATIONS = 4;
    private static final int NUM_BLADES = 350;
    private Group rootContent;
    private Group grassContent;
    private Group fishContent;

    @Override
    public void start(final Stage stage) {
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.sizeToScene();
        stage.setScene(new AppScene());
        
        //close application
        final Button close = new Button("X");
        close.setFont(Font.font("Arial", FontWeight.BOLD, 20));
        close.setStyle("-fx-background-color:transparent;-fx-text-fill:red;");
        close.setOpacity(0);
        close.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent arg0) {
                Platform.exit();
                System.exit(0);
            }
        });
        close.setTranslateY(stage.getScene().getHeight()-30);
        close.setTranslateX(-stage.getScene().getWidth()/2);
        rootContent.getChildren().add(close);
        
        //minimize application
        final Button minim = new Button("_");
        minim.setFont(Font.font("Arial", FontWeight.BOLD, 20));
        minim.setStyle("-fx-background-color:transparent;-fx-text-fill:red;");
        minim.setOpacity(0);
        minim.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent arg0) {
                stage.setIconified(true);
            }
        });
        minim.setTranslateY(stage.getScene().getHeight()-45);
        minim.setTranslateX(-stage.getScene().getWidth()/2+30);
        rootContent.getChildren().add(minim);
        
        stage.getScene().setOnMouseEntered(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent arg0) {
                close.setOpacity(1);
                minim.setOpacity(1);
            }
        });
        stage.getScene().setOnMouseExited(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent arg0) {
                close.setOpacity(0);
                minim.setOpacity(0);
            }
        });
        stage.show();
        
        // close application
        stage.setOnCloseRequest(new EventHandler<WindowEvent>() {

            @Override
            public void handle(WindowEvent t) {
                Platform.exit();
                System.exit(0);
            }
        });

        new Animator(new FishGenerator(fishContent, NUMBER_OF_FISHES_GENERATIONS), new PlantGenerator(grassContent, NUM_BLADES)).run();

        MediaPlayer sound = new MediaPlayer(new Media(SOURCE));
        sound.setCycleCount(MediaPlayer.INDEFINITE);
        sound.play();
    }

    public static void main(String[] args) {
        launch(args);
    }

    private class AppScene extends Scene {

        public AppScene() {
            super(rootContent = new Group(), SCENE_WIDTH, SCENE_HEIGHT, Color.TRANSPARENT);
            rootContent.setClip(new Rectangle(-SCENE_WIDTH/2, 0, SCENE_WIDTH, SCENE_HEIGHT)); //Scene shape and size

            Rectangle background = new Rectangle(-SCENE_WIDTH / 2, 0, SCENE_WIDTH, SCENE_HEIGHT);
            background.setFill(new LinearGradient(0, 0, 0, SCENE_HEIGHT, false, CycleMethod.NO_CYCLE, new Stop(0, Color.DARKBLUE), new Stop(0.5, Color.AQUA), new Stop(0.7, Color.AQUAMARINE),
                    new Stop(1., new Color(1, 1, 1, 0)))); //background color
            rootContent.getChildren().add(background);
            rootContent.getChildren().add(fishContent = new Group()); // tree layout
            rootContent.getChildren().add(grassContent = new Group()); // grass layout
            rootContent.getTransforms().addAll(new Translate(SCENE_WIDTH / 2, SCENE_HEIGHT), new Rotate(180));

        }
    }
}
