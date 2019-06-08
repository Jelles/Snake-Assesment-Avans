package Controller;

import Model.Game;
import Model.Spot;
import View.GameOverScene;
import View.GameScene;
import javafx.application.Platform;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

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

    /**
     * Stops all the threads and swaps to the gameOverScene
     */
    public void viewEndGame() {
        game.pause();
        game.getDashBoardTimer().stop();
        GameOverScene gameOverScene = new GameOverScene(this);
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                stage.setScene(gameOverScene);
                stage.show();
            }
        });
    }

    /**
     * Starts the game
     */
    public void startGame() {
        game.start();
        game.getDashBoardTimer().start();

        new Thread(game).start();
        new Thread(growSnake()).start();
        new Thread(addObjects()).start();
    }

    /**
     * Pauses the game
     */
    public void pauseGame() {
        game.pause();
        game.getDashBoardTimer().pause();
    }

    /**
     * exits the application
     */
    public void exitApplication() {
        System.exit(0);
    }

    /**
     * Makes a runnable to constantly make the snake grow
     *
     * @return Runnable that grows the snake consistently
     */
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
                    game.getSnake().grow();
                }
            }
        };
    }

    /**
     * Makes a runnable to constantly add random objects (Spot) on the canvas
     *
     * @return Runnable that adds objects (Spot) on the canvas consistently
     */
    public Runnable addObjects() {
        return new Runnable() {
            @Override
            public void run() {
                while (!game.isPause()) {
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    game.addRandomObstacle();
                }

            }
        };
    }

    public void draw() {
        gameScene.draw();
    }

    /**
     * Runs the action of the bear spot
     *
     * Action:
     * The snakes length is cut in half and rounded down if the length of the snake gets below 7 you crash
     *
     * @param spot the spot that the snake collided with so it can be removed from the canvas
     */
    public void bearSpot(Spot spot) {
        int snakeSize = game.getSnake().getBodyParts().size();
        double newSize = Double.valueOf(snakeSize / 2).intValue();
        if (newSize < 7) {
            viewEndGame();
        }
        double index = snakeSize - newSize;
        for (double i = index; i < snakeSize; i++) game.getSnake().removeBodyPart((int) index);
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                game.removeObstacle(spot);
            }
        });
    }

    /**
     * Runs the action of the spot
     *
     * Action:
     * Snake crashes
     */
    public void fireSpot() {
        viewEndGame();
    }

    /**
     * Runs the action of the spot
     *
     * Action:
     * the snake grows 5 times
     *
     * @param spot the spot that the snake collided with so it can be removed from the canvas
     */
    public void mouseSpot(Spot spot) {
        for (int i = 0; i < 5; i++) getGame().getSnake().grow();
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                game.removeObstacle(spot);
            }
        });
    }

    public Game getGame() {
        return this.game;
    }

}
