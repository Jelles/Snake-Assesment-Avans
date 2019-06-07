package View;

import Controller.Controller;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class GameOverScene extends Scene {
    private Text gameOverText;
    private Text endTime;
    private VBox rootPane;
    private Controller controller;

    public GameOverScene(Controller controller) {
        super(new Pane(), 760, 650);
        this.controller = controller;
        rootPane = new VBox();
        rootPane.setBackground(new Background(new BackgroundFill(Color.rgb(198, 0, 42), null, null)));
        rootPane.setPrefSize(760, 650);
        gameOverText = new Text("Game Over");
        gameOverText.setFont(Font.font("Verdana", 40));
        endTime = new Text(controller.getGame().getDashBoardTimer().getTimeText());
        endTime.setFont(Font.font("Verdana", 44));
        endTime.setFill(Color.WHITE);
        BorderPane gameOverPaddingPane = new BorderPane();
        BorderPane endTimePaddingPane = new BorderPane();
        gameOverPaddingPane.setCenter(gameOverText);
        endTimePaddingPane.setCenter(endTime);
        rootPane.setAlignment(Pos.CENTER);
        rootPane.getChildren().addAll(gameOverPaddingPane, endTimePaddingPane);
        setRoot(rootPane);
    }
}
