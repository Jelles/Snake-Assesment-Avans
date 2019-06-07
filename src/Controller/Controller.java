package Controller;

import Model.BodyPart;
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
        game.getDashBoardTimer().stop();
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
        game.getDashBoardTimer().start();
        new Thread(game).start();
        new Thread(growSnake()).start();
    }

    public void pauseGame() {
        game.pause();
        game.getDashBoardTimer().pause();
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


    public void draw() {
        gameScene.draw();
    }
}
