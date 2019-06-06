package Controller;

import View.GameScene;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main extends Application {
    private Scene rootScene;
    private Stage stage;


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        this.stage = stage;
        stage.setResizable(false);
        stage.setTitle("PROG ASS Snake - Jelles Duin");
        buildGui(stage);
        stage.show();
    }

    private void buildGui(Stage stage) {
        rootScene = new GameScene(new Pane(), 760, 650);
        stage.setScene(rootScene);
    }

    public void switchStartScene() {

    }

    public void switchEndScene() {

    }
}
