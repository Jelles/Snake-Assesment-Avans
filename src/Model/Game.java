package Model;

import Controller.Controller;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;

import java.util.ArrayList;

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
    }

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

    public void pause() {
        this.pause = true;
    }

    public void start() {
        this.pause = false;
    }

    public Snake getSnake() {
        return this.snake;
    }

    public boolean isPause() {
        return this.pause;
    }
}

