package View;

import Model.DashBoardModel;
import Model.Game;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

public class DashBoard extends HBox {

    private DashBoardModel dashBoardModel;
    private Button pauseButton;
    private Button exitButton;
    private final int BUTTON_WIDTH = 80;
    private final int BUTTON_HEIGHT = 30;
    private Game game;

    public DashBoard(DashBoardModel dashBoardModel, Game game) {
        this.dashBoardModel = dashBoardModel;
        this.game = game;
        this.setBackground(new Background(new BackgroundFill(Color.GRAY, null, null)));
        this.setPrefSize(this.dashBoardModel.getWidth(), this.dashBoardModel.getHeight());
        this.setAlignment(Pos.CENTER);

        pauseButton = new Button("Pause");
        exitButton = new Button("Exit");

        pauseButton.setPrefSize(BUTTON_WIDTH, BUTTON_HEIGHT);
        exitButton.setPrefSize(BUTTON_WIDTH, BUTTON_HEIGHT);

        pauseButton.setOnAction(e -> {
            game.draw
        });

        BorderPane slidePadding = new BorderPane();
        BorderPane timerPadding = new BorderPane();
        BorderPane pausePadding = new BorderPane();
        BorderPane exitPadding = new BorderPane();

        Pane slidePane = new Pane();
        Pane timerPane = new Pane();

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
