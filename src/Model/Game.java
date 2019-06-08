package Model;

import Controller.Controller;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;

import java.util.ArrayList;
import java.util.Random;

public class Game implements Runnable {
    private Snake snake;
    private boolean pause;
    private Controller controller;
    private DoubleProperty slideValue;
    private DashBoardTimer dashBoardTimer;
    private int delay;
    private int delayCounter;
    private int slideCounter;
    private ArrayList<Spot> obstacles;

    public Game(Controller controller) {
        this.controller = controller;
        slideValue = new SimpleDoubleProperty(1);
        obstacles = new ArrayList<Spot>();
        snake = new Snake(15, 10, 4, controller);
        dashBoardTimer = new DashBoardTimer();
        pause = true;
        delay = 650;
        delayCounter = 0;
        slideCounter = 0;
        addRandomObstacle();
    }

    /**
     * Adds a random obstacle (Spot) on the canvas
     */
    public void addRandomObstacle() {
        Random rnd = new Random();
        int xPos = rnd.nextInt(19);
        int yPos = rnd.nextInt(15);
        Marker marker = Marker.randomMarker();
        if (isPossiblePosition(xPos, yPos)) obstacles.add(new Spot(xPos, yPos, marker, controller));
        else addRandomObstacle();
    }

    /**
     * Checks if the given position has a snake, bodypart or an object
     *
     * @param xPos
     * @param yPos
     *
     * @return
     */
    private boolean isPossiblePosition(int xPos, int yPos) {
        if (xPos == snake.getxPos() && yPos == snake.getyPos()) return false;
        for (Spot obstacle : obstacles)
            if (xPos == obstacle.getxPos() && yPos == obstacle.getyPos()) return false;
        for (BodyPart bodyPart : snake.getBodyParts())
            if (xPos == bodyPart.getxPos() && yPos == bodyPart.getyPos()) return false;
        return true;
    }

    public ArrayList<Spot> getObstacles() {
        return this.obstacles;
    }

    /**
     * Main game loop
     */
    @Override
    public void run() {
        while (!pause) {
            delayCounter++;
            switch (snake.getDirection()) {
                case UP:
                    snake.moveUp();
                    break;
                case DOWN:
                    snake.moveDown();
                    break;
                case LEFT:
                    snake.moveLeft();
                    break;
                case RIGHT:
                    snake.moveRight();
                    break;
            }
            controller.draw();
            if (!(delay <= 100)) {
                delay -= 125 / delayCounter;
                if (slideCounter == 4) {
                    slideValue.set(slideValue.get() + 1);
                    slideCounter = 0;
                }
                slideCounter++;
            }
            try {
                Thread.sleep(delay);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public DashBoardTimer getDashBoardTimer() {
        return dashBoardTimer;
    }

    public final DoubleProperty slideValueProperty() {
        return slideValue;
    }

    /**
     * Pauses the game
     */
    public void pause() {
        this.pause = true;
    }

    /**
     * Starts the game
     */
    public void start() {
        this.pause = false;
    }

    public Snake getSnake() {
        return this.snake;
    }

    public boolean isPause() {
        return this.pause;
    }

    public void removeObstacle(Spot spot) {
        obstacles.remove(spot);
    }
}

