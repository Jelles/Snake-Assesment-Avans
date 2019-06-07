package Model;

import Controller.Controller;
import javafx.concurrent.Task;

public class Game implements Runnable {
    private Snake snake;
    private boolean pause;
    private Controller controller;

    public Game(Controller controller) {
        this.controller = controller;
        snake = new Snake(15, 10, controller);
        pause = true;
    }


    @Override
    public void run() {
        while (!pause) {
            switch (snake.getDirection()) {
                case UP:
                    this.moveUp();
                    break;
                case DOWN:
                    this.moveDown();
                    break;
                case LEFT:
                    this.moveLeft();
                    break;
                case RIGHT:
                    this.moveRight();
                    break;
                default:
                    this.moveRight();
                    break;
            }
            controller.draw();
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
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

    public void moveLeft() {
        controller.snakeMoveLeft();
    }

    public void moveUp() {
        controller.snakeMoveUp();
    }

    public void moveRight() {
        controller.snakeMoveRight();
    }

    public void moveDown() {
        controller.snakeMoveDown();
    }

    public boolean isPause() {
        return this.pause;
    }
}

