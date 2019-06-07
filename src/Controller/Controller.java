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

    public Controller(Stage stage) {
        this.stage = stage;
        game = new Game(this);
        gameScene = new GameScene(new Pane(), 760, 650, this);
        stage.setScene(gameScene);
        stage.setResizable(false);
        stage.setTitle("PROG ASS Snake - Jelles Duin");
        stage.show();
        viewGame();
    }

    public void viewGame() {
        new Thread(game).start();
    }

    public void viewEndGame() {
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

    private void moveBodyParts() {
        ArrayList<BodyPart> bodyParts = game.getSnake().getBodyParts();
        for (int i = bodyParts.size() - 1; i >= 0; i--) {
            if (i == 0) {
                int xPos = game.getSnake().getxPos();
                int yPos = game.getSnake().getxPos();

                bodyParts.get(i).setxPos(game.getSnake().getxPos());
                bodyParts.get(i).setyPos(game.getSnake().getxPos());
                return;
            }
            bodyParts.get(i).setyPos(bodyParts.get(i - 1).getyPos());
            bodyParts.get(i).setxPos(bodyParts.get(i - 1).getxPos());
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

    public void snakeMoveLeft() {
        Snake snake = game.getSnake();
        if (snake.getxPos() == 0) {
            viewEndGame();
        }
        bodyCollapse();
        moveBodyParts();
        snake.setxPos(snake.getxPos() - 1);
    }

    public void snakeMoveRight() {
        Snake snake = game.getSnake();
        if (snake.getxPos() == 18) {
            viewEndGame();
        }
        bodyCollapse();
        moveBodyParts();
        snake.setxPos(snake.getxPos() + 1);
    }

    public void snakeMoveUp() {
        Snake snake = game.getSnake();
        if (snake.getyPos() == 0) {
            viewEndGame();
        }
        bodyCollapse();
        moveBodyParts();
        snake.setyPos(snake.getyPos() - 1);
    }

    public void snakeMoveDown() {
        Snake snake = game.getSnake();
        if (snake.getyPos() == 14) {
            viewEndGame();
        }
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
