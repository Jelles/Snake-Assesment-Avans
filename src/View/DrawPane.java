package View;

import Controller.Controller;
import Model.BodyPart;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

public class DrawPane extends StackPane {
    private final int rows = 15;
    private final int columns = 19;
    private Canvas canvas;
    private TilePane background;
    private Controller controller;

    public DrawPane(Controller controller) {
        this.controller = controller;
        this.canvas = new Canvas(760, 600);
        this.background = new TilePane();
        this.setBackground(new Background(new BackgroundFill(Color.BLUE, null, null)));
        this.setPrefSize(760, 600);
        this.addBackground();
        this.getChildren().addAll(background, canvas);
        draw();
    }

    public void draw() {
        GraphicsContext g = this.canvas.getGraphicsContext2D();
        g.clearRect(0, 0, 760, 600);
        drawHead(g, controller.getGame().getSnake().getxPos(), controller.getGame().getSnake().getyPos());
        for (BodyPart bodyPart : controller.getGame().getSnake().getBodyParts()) {
            drawBodyPart(g, bodyPart.getxPos(), bodyPart.getyPos());
        }
    }

    private void addBackground() {
        Pane[][] background = new Pane[rows][columns];
        boolean rowSwitch = false;
        boolean colorSwitch = false;
        Color darkGray = Color.rgb(30, 30, 30);
        Color lightGray = Color.rgb(50, 50, 50);
        for (Pane[] backgroundPanes : background) {
            for (Pane backgroundPane : backgroundPanes) {
                backgroundPane = new Pane();
                backgroundPane.setMinSize(40, 40);
                if (rowSwitch) {
                    if (colorSwitch) {
                        backgroundPane.setBackground(new Background(new BackgroundFill(darkGray, null, null)));
                    } else {
                        backgroundPane.setBackground(new Background(new BackgroundFill(lightGray, null, null)));
                    }
                } else {
                    if (colorSwitch) {
                        backgroundPane.setBackground(new Background(new BackgroundFill(darkGray, null, null)));
                    } else {
                        backgroundPane.setBackground(new Background(new BackgroundFill(Color.BLACK, null, null)));
                    }
                }
                this.background.getChildren().add(backgroundPane);
                colorSwitch ^= true;
            }
            rowSwitch ^= true;
        }
    }


    private void drawHead(GraphicsContext g, int xPos, int yPos) {
        g.setFill(Color.RED);
        g.fillOval(xPos * 40, yPos * 40, 40, 40);
    }

    private void drawBodyPart(GraphicsContext g, int xPos, int yPos) {
        g.setFill(Color.ORANGE);
        g.fillOval(xPos * 40, yPos * 40, 40, 40);
    }
}
