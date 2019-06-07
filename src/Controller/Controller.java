package Controller;

import Model.BodyPart;
import Model.Direction;
import Model.Game;
import Model.Snake;
import View.GameOverScene;
import View.GameScene;
import javafx.application.Platform;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.util.ArrayList;

public class Controller {
    private GameScene gameScene;
    private Game game;
    private Stage stage;
    private Thread growThread;

    public Controller(Stage stage) {
        growSnake();
        this.stage = stage;
        game = new Game(this);
        gameScene = new GameScene(new Pane(), 760, 650, this);
        stage.setScene(gameScene);
        stage.setResizable(false);
        stage.setTitle("PROG ASS Snake - Jelles Duin");
        stage.show();
    }

    public void viewEndGame() {
        game.pause();
        GameOverScene gameOverPane = new GameOverScene(this);
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                stage.setScene(gameOverPane);
                stage.show();
            }
        });
    }

    public void startGame() {
        game.start();
        new Thread(game).start();
        new Thread(growSnake()).start();
    }

    public void pauseGame() {
        game.pause();
    }

    public void exitApplication() {
        System.exit(0);
    }

    public Game getGame() {
        return this.game;
    }

    public Runnable growSnake() {
        return new Runnable() {
            @Override
            public void run() {
                while (!game.isPause()) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    ArrayList<BodyPart> bodyParts = game.getSnake().getBodyParts();
                    Snake snake = game.getSnake();
                    int xPos = bodyParts.get(bodyParts.size() - 1).getxPos();
                    int yPos = bodyParts.get(bodyParts.size() - 1).getyPos();
                    switch (snake.getDirection()) {
                        case UP:
                            yPos--;
                        case LEFT:
                            xPos--;
                        case RIGHT:
                            xPos++;
                        case DOWN:
                            yPos++;
                    }
                    BodyPart bodyPart = new BodyPart(xPos, yPos, snake.getDirection());
                    snake.addBodyPart(bodyPart);
                }
            }
        };
    }

    private void moveBodyParts() {
        ArrayList<BodyPart> bodyParts = game.getSnake().getBodyParts();
        for (int i = bodyParts.size() - 1; i >= 0; i--) {
            if (i == 0) {
                bodyParts.get(i).setxPos(game.getSnake().getxPos());
                bodyParts.get(i).setyPos(game.getSnake().getyPos());
                bodyParts.get(i).setDirection(game.getSnake().getDirection());
            } else {
                bodyParts.get(i).setyPos(bodyParts.get(i - 1).getyPos());
                bodyParts.get(i).setxPos(bodyParts.get(i - 1).getxPos());
                bodyParts.get(i).setDirection(bodyParts.get(i - 1).getDirection());
            }
        }
    }

    private void bodyCollapse() {
        ArrayList<BodyPart> bodyParts = game.getSnake().getBodyParts();
        for (BodyPart bodyPart : bodyParts) {
            if (game.getSnake().getxPos() == bodyPart.getxPos() && game.getSnake().getyPos() == bodyPart.getyPos()) {
                viewEndGame();
            }
        }
    }

    private void wallCollapse() {
        Snake snake = game.getSnake();
        if (snake.getxPos() == 0) {
            viewEndGame();
        }
        if (snake.getyPos() == 14) {
            viewEndGame();
        }
        if (snake.getxPos() == 18) {
            viewEndGame();
        }
        if (snake.getyPos() == 0) {
            viewEndGame();
        }
    }

    public void snakeMoveLeft() {
        Snake snake = game.getSnake();
        wallCollapse();
        bodyCollapse();
        moveBodyParts();
        snake.setxPos(snake.getxPos() - 1);
    }

    public void snakeMoveRight() {
        Snake snake = game.getSnake();
        wallCollapse();
        bodyCollapse();
        moveBodyParts();
        snake.setxPos(snake.getxPos() + 1);
    }

    public void snakeMoveUp() {
        Snake snake = game.getSnake();
        wallCollapse();
        bodyCollapse();
        moveBodyParts();
        snake.setyPos(snake.getyPos() - 1);
    }

    public void snakeMoveDown() {
        Snake snake = game.getSnake();
        wallCollapse();
        bodyCollapse();
        moveBodyParts();
        snake.setyPos(snake.getyPos() + 1);
    }

    public void snakeDirectionUp() {
        if (game.getSnake().getDirection() == Direction.DOWN) {
            return;
        }
        game.getSnake().setDirection(Direction.UP);
    }

    public void snakeDirectionDown() {
        if (game.getSnake().getDirection() == Direction.UP) {
            return;
        }
        game.getSnake().setDirection(Direction.DOWN);
    }

    public void snakeDirectionLeft() {
        if (game.getSnake().getDirection() == Direction.RIGHT) {
            return;
        }
        game.getSnake().setDirection(Direction.LEFT);
    }

    public void snakeDirectionRight() {
        if (game.getSnake().getDirection() == Direction.LEFT) {
            return;
        }
        game.getSnake().setDirection(Direction.RIGHT);
    }

    public void draw() {
        gameScene.draw();
    }
}
