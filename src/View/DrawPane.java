package View;

import Controller.Controller;
import Model.BodyPart;
import Model.Spot;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

import java.util.ArrayList;

public class DrawPane extends StackPane {
    private final int rows = 15;
    private final int columns = 19;
    private Canvas canvas;
    private TilePane background;
    private Controller controller;
    private ArrayList<Image> obstacleImages;

    public DrawPane(Controller controller) {
        this.obstacleImages = new ArrayList<Image>();
        this.controller = controller;
        this.canvas = new Canvas(760, 600);
        this.background = new TilePane();
        this.setBackground(new Background(new BackgroundFill(Color.BLUE, null, null)));
        this.setPrefSize(760, 600);
        this.addBackground();
        this.getChildren().addAll(background, canvas);
        initImages();
        draw();
    }

    /**
     * Sets the path and rezises the images and adds them to the arraylist
     */
    private void initImages() {
        Image fireImage = new Image(getClass().getResourceAsStream("/images/fire.png"), 40, 40, false, false);
        Image bearImage = new Image(getClass().getResourceAsStream("/images/bear.png"), 40, 40, false, false);
        Image mouseImage = new Image(getClass().getResourceAsStream("/images/mouse.png"), 40, 40, false, false);
        obstacleImages.add(fireImage);
        obstacleImages.add(bearImage);
        obstacleImages.add(mouseImage);
    }

    /**
     * Draws the game
     */
    public void draw() {
        GraphicsContext g = this.canvas.getGraphicsContext2D();
        g.clearRect(0, 0, 760, 600);
        drawHead(g, controller.getGame().getSnake().getxPos(), controller.getGame().getSnake().getyPos());
        for (BodyPart bodyPart : controller.getGame().getSnake().getBodyParts()) {
            drawBodyPart(g, bodyPart.getxPos(), bodyPart.getyPos());
        }
        for (Spot obstacle : controller.getGame().getObstacles()) {
            Image img = null;
            switch (obstacle.getType()) {
                case FIRE:
                    img = obstacleImages.get(0);
                    break;
                case BEAR:
                    img = obstacleImages.get(1);
                    break;
                case MOUSE:
                    img = obstacleImages.get(2);
                    break;
            }
            if (img != null) {
                g.drawImage(img, obstacle.getxPos() * 40, obstacle.getyPos() * 40);
            }
        }
    }

    /**
     * Adds the background
     */
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

    /**
     * Draws the snake head on the canvas
     *
     * @param g GraphicsContext
     * @param xPos snake xPosition
     * @param yPos snake yPosition
     */
    private void drawHead(GraphicsContext g, int xPos, int yPos) {
        g.setFill(Color.RED);
        g.fillOval(xPos * 40, yPos * 40, 40, 40);
    }

    /**
     * Draws the snake bodypart on the canvas
     *
     * @param g GraphicsContext
     * @param xPos bodypart xPosition
     * @param yPos bodypart yPosition
     */
    private void drawBodyPart(GraphicsContext g, int xPos, int yPos) {
        g.setFill(Color.ORANGE);
        g.fillOval(xPos * 40, yPos * 40, 40, 40);
    }
}
