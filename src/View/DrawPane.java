package View;

import Model.DrawModel;
import Model.Game;
import Model.Snake;
import Model.Square;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.TilePane;
import javafx.scene.paint.Color;
import javafx.util.Duration;

public class DrawPane extends StackPane {
    private Square[][] playField;
    private SquareView[][] playFieldView;
    private DrawModel drawModel;
    private int rows;
    private int columns;
    private Canvas canvas;
    private TilePane playFieldPanes;
    private Game game;
    private Snake snake;

    public DrawPane(DrawModel drawModel, Game game) {
        this.drawModel = drawModel;
        this.game = game;
        this.setBackground(new Background(new BackgroundFill(Color.BLUE, null, null)));
        this.setPrefSize(this.drawModel.getWidth(), this.drawModel.getHeight());
        this.rows = drawModel.getRows();
        this.columns = drawModel.getColumns();
        this.playField = drawModel.getPlayField();
        this.playFieldView = generatePlayFieldView();
        this.playFieldPanes = new TilePane();
        this.canvas = new Canvas(drawModel.getWidth(), drawModel.getHeight());
        this.getChildren().addAll(playFieldPanes, canvas);
        this.snake = game.getSnake();
        this.showPlayFieldView();

        draw();
    }

    private void draw() {
        GraphicsContext g = this.canvas.getGraphicsContext2D();

        drawHead(g, snake.getxPos(), snake.getyPos());
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

    private void showPlayFieldView() {
        for (SquareView[] spotViews : playFieldView) {
            for (SquareView spotView : spotViews) {
                playFieldPanes.getChildren().add(spotView);
            }
        }
    }

    private SquareView[][] generatePlayFieldView() {
        SquareView[][] playFieldView = new SquareView[rows][columns];
        boolean firstCheck = false;
        boolean secondCheck = false;
        Color darkGray = Color.rgb(30, 30, 30);
        Color lightGray = Color.rgb(50, 50, 50);
        for (Square[] spots : playField) {
            for (Square spot : spots) {
                SquareView spotView = new SquareView(spot);
                if (firstCheck) {
                    if (secondCheck) {
                        spotView.setBackground(new Background(new BackgroundFill(darkGray, null, null)));
                    } else {
                        spotView.setBackground(new Background(new BackgroundFill(lightGray, null, null)));
                    }
                } else {
                    if (secondCheck) {
                        spotView.setBackground(new Background(new BackgroundFill(darkGray, null, null)));
                    } else {
                        spotView.setBackground(new Background(new BackgroundFill(Color.BLACK, null, null)));
                    }
                }
                secondCheck ^= true;
                playFieldView[spot.getxPos()][spot.getyPos()] = spotView;
            }
            firstCheck ^= true;
        }
        return playFieldView;
    }


}
