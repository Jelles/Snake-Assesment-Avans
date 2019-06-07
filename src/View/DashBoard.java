package View;

import Controller.Controller;
import Model.DashBoardModel;
import Model.Game;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class DashBoard extends HBox {

    private DashBoardModel dashBoardModel;
    private ToggleButton pauseButton;
    private Button exitButton;
    private final int BUTTON_WIDTH = 80;
    private final int BUTTON_HEIGHT = 30;
    private Game game;
    private Controller controller;

    public DashBoard(DashBoardModel dashBoardModel, Game game, Controller controller) {
        this.controller = controller;
        this.dashBoardModel = dashBoardModel;
        this.game = game;
        this.setBackground(new Background(new BackgroundFill(Color.GRAY, null, null)));
        this.setPrefSize(this.dashBoardModel.getWidth(), this.dashBoardModel.getHeight());
        this.setAlignment(Pos.CENTER);

        pauseButton = new ToggleButton("Start");
        exitButton = new Button("Exit");

        pauseButton.setPrefSize(BUTTON_WIDTH, BUTTON_HEIGHT);
        exitButton.setPrefSize(BUTTON_WIDTH, BUTTON_HEIGHT);

        exitButton.setOnAction(e -> {
            controller.exitApplication();
        });

        pauseButton.setOnAction(e -> {
            if (pauseButton.isSelected()) {
                pauseButton.setText("Pause");
                controller.startGame(game);
            } else {
                pauseButton.setText("Start");
                controller.pauseGame(game);
            }
        });

        BorderPane slidePadding = new BorderPane();
        BorderPane timerPadding = new BorderPane();
        BorderPane pausePadding = new BorderPane();
        BorderPane exitPadding = new BorderPane();

        Label playTimeLabel = new Label();
        playTimeLabel.setText("00:00.000");
        playTimeLabel.setFont(Font.font("Verdana", 20));
        playTimeLabel.setPadding(new Insets(8));

        Slider speedSlider = new Slider(1, 12, 5);
        speedSlider.setPrefSize(190, 40);
        speedSlider.setPadding(new Insets(0, 0, 20, 10));
        speedSlider.setShowTickLabels(true);
        speedSlider.setShowTickMarks(true);
        speedSlider.setSnapToTicks(true);
        speedSlider.setMajorTickUnit(1);
        speedSlider.setMinorTickCount(0);
        speedSlider.setOpacity(100);
        speedSlider.setDisable(true);

        Pane slidePane = new Pane();
        Pane timerPane = new Pane();
        timerPane.getChildren().add(playTimeLabel);
        slidePane.getChildren().add(speedSlider);

        slidePane.setPrefSize(200, 40);
        timerPane.setPrefSize(120, 40);

        slidePane.setBackground(new Background(new BackgroundFill(Color.LIGHTGRAY, null, null)));
        timerPane.setBackground(new Background(new BackgroundFill(Color.LIGHTGRAY, null, null)));

        slidePadding.setPadding(new Insets(5));
        timerPadding.setPadding(new Insets(5));
        pausePadding.setPadding(new Insets(5));
        exitPadding.setPadding(new Insets(5));

        timerPadding.setCenter(timerPane);
        slidePadding.setCenter(slidePane);
        pausePadding.setCenter(pauseButton);
        exitPadding.setCenter(exitButton);
        this.getChildren().addAll(pausePadding, exitPadding, slidePadding, timerPadding);
    }
}
