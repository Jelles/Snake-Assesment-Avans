package View;

import Model.Game;
import Model.Snake;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.util.Duration;

public class DrawPane extends StackPane {
    private final int rows = 15;
    private final int columns = 19;
    private Canvas canvas;
    private TilePane background;
    private Game game;
    private Snake snake;

    public DrawPane(Game game) {
        this.game = game;
        this.canvas = new Canvas(760, 600);
        this.background = new TilePane();
        this.setBackground(new Background(new BackgroundFill(Color.BLUE, null, null)));
        this.setPrefSize(760, 600);
        this.addBackground();
        this.getChildren().addAll(background, canvas);
        this.snake = game.getSnake();
        draw();
    }

    public void draw() {
        GraphicsContext g = this.canvas.getGraphicsContext2D();
        g.clearRect(0, 0, 760, 600);
        drawHead(g, snake.getxPos(), snake.getyPos());
    }

    private void addBackground() {
        Pane[][] background = new Pane[rows][columns];
        boolean firstCheck = false;
        boolean secondCheck = false;
        Color darkGray = Color.rgb(30, 30, 30);
        Color lightGray = Color.rgb(50, 50, 50);
        for (Pane[] backgroundPanes : background) {
            for (Pane backgroundPane : backgroundPanes) {
                backgroundPane = new Pane();
                backgroundPane.setMinSize(40, 40);
                if (firstCheck) {
                    if (secondCheck) {
                        backgroundPane.setBackground(new Background(new BackgroundFill(darkGray, null, null)));
                    } else {
                        backgroundPane.setBackground(new Background(new BackgroundFill(lightGray, null, null)));
                    }
                } else {
                    if (secondCheck) {
                        backgroundPane.setBackground(new Background(new BackgroundFill(darkGray, null, null)));
                    } else {
                        backgroundPane.setBackground(new Background(new BackgroundFill(Color.BLACK, null, null)));
                    }
                }
                this.background.getChildren().add(backgroundPane);
                secondCheck ^= true;
            }
            firstCheck ^= true;
        }
    }

    private void doMove() {
        Timeline timeline = new Timeline(
                new KeyFrame(Duration.millis(30), event -> {

                }));
    }


    private void drawHead(GraphicsContext g, int xPos, int yPos) {
        g.setFill(Color.RED);
        g.fillOval(xPos * 40, yPos * 40, 40, 40);
    }
}
