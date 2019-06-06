package View;

import Model.Game;
import javafx.geometry.Pos;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class GameOverScene extends VBox {
    private Text gameOverText;
    private Text endTime;
    private Game game;

    public GameOverScene(Game game) {
        this.game = game;
        this.setBackground(new Background(new BackgroundFill(Color.rgb(198, 0, 42), null, null)));
        this.setPrefSize(760, 600);
        this.gameOverText = new Text("Game Over");
        this.gameOverText.setFont(Font.font("Verdana", 40));
        this.endTime = new Text("00:30.720");
        this.endTime.setFont(Font.font("Verdana", 44));
        this.endTime.setFill(Color.WHITE);
        BorderPane gameOverPaddingPane = new BorderPane();
        BorderPane endTimePaddingPane = new BorderPane();
        gameOverPaddingPane.setCenter(gameOverText);
        endTimePaddingPane.setCenter(endTime);
        this.setAlignment(Pos.CENTER);
        this.getChildren().addAll(gameOverPaddingPane, endTimePaddingPane);
    }
}
