package Model;

import Controller.Controller;
import View.DrawPane;
import View.GameScene;
import javafx.concurrent.Task;
import javafx.scene.input.KeyCode;

public class Game extends Task<Void> {
    private DashBoardModel dashBoardModel;
    private Snake snake;
    private boolean pause;
    private DrawPane drawPane;
    private GameScene gameScene;

    public Game(Controller controller, GameScene gameScene) {
        this.gameScene = gameScene;
        snake = new Snake(5, 5, controller);
        pause = true;
        initButtons();
    }

    private void initButtons() {
        gameScene.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.LEFT || e.getCode() == KeyCode.A) {
                if (snake.getDirection() == Direction.RIGHT) {
                    return;
                }
                snake.setDirection(Direction.LEFT);
                System.out.println(snake.getDirection());
            }
            if (e.getCode() == KeyCode.RIGHT || e.getCode() == KeyCode.D) {
                if (snake.getDirection() == Direction.LEFT) {
                    return;
                }
                snake.setDirection(Direction.RIGHT);
                System.out.println(snake.getDirection());
            }
            if (e.getCode() == KeyCode.UP || e.getCode() == KeyCode.W) {
                if (snake.getDirection() == Direction.DOWN) {
                    return;
                }
                snake.setDirection(Direction.UP);
                System.out.println(snake.getDirection());
            }
            if (e.getCode() == KeyCode.DOWN || e.getCode() == KeyCode.S) {
                if (snake.getDirection() == Direction.UP) {
                    return;
                }
                snake.setDirection(Direction.DOWN);
                System.out.println(snake.getDirection());
            }
        });
    }

    @Override
    protected Void call() throws Exception {
        while (true) {
            Thread.sleep(100);
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
                drawPane.draw();
                Thread.sleep(100);
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
        snake.moveLeft();
    }

    public void moveUp() {
        snake.moveUp();
    }

    public void moveRight() {
        snake.moveRight();
    }

    public void moveDown() {
        snake.moveDown();
    }

    /**
     * Gets the dashboard model
     *
     * @return dashBoardModel DashBoardModel
     */
    public DashBoardModel getDashBoardModel() {
        return this.dashBoardModel;
    }

    /**
     * Sets the DashBoardModel to the given DashBoardModel
     *
     * @param dashBoardModel DashBoardModel
     */
    public void setDashBoardModel(DashBoardModel dashBoardModel) {
        this.dashBoardModel = dashBoardModel;
    }

    public void setDrawPane(DrawPane drawPane) {
        this.drawPane = drawPane;
    }
}

