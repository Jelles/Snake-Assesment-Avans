package Controller;

import View.GameScene;
import javafx.application.Application;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        GameScene scene = new GameScene(new Pane(), 760, 650);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.setTitle("PROG ASS Snake - Jelles Duin");
        stage.show();
    }
}
