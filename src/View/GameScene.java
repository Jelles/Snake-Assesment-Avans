package View;

import Controller.Controller;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;

public class GameScene extends Scene {
    private Controller controller;
    private DrawPane drawPane;
    private DashBoard dashBoard;
    private BorderPane rootPane;

    public GameScene(Parent root, int width, int height, Controller controller) {
        super(root, width, height);
        this.controller = controller;
        initButtons();
        rootPane = new BorderPane();
        drawPane = new DrawPane(controller);
        dashBoard = new DashBoard(controller);
        rootPane.setCenter(drawPane);
        rootPane.setBottom(dashBoard);
        setRoot(rootPane);
    }

    public void draw() {
        drawPane.draw();
    }


    private void initButtons() {
        this.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.LEFT || e.getCode() == KeyCode.A) controller.snakeDirectionLeft();
            if (e.getCode() == KeyCode.RIGHT || e.getCode() == KeyCode.D) controller.snakeDirectionRight();
            if (e.getCode() == KeyCode.UP || e.getCode() == KeyCode.W) controller.snakeDirectionUp();
            if (e.getCode() == KeyCode.DOWN || e.getCode() == KeyCode.S) controller.snakeDirectionDown();
        });
    }
}
