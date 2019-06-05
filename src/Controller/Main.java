package Controller;

import View.GameView;
import View.MyScene;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        MyScene scene = new MyScene(new Pane(), 760, 600);
        GameView gameView = new GameView();
        scene.setRoot(gameView);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.setTitle("PROG ASS Snake - Jelles Duin");
        stage.show();
    }
}
