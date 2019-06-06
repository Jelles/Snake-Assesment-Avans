package Controller;

import Model.DashBoardModel;
import Model.Game;
import View.GameOverScene;
import View.GameView;
import View.GameScene;

public class Controller {
    private GameScene myScene;

    public Controller(GameScene myScene) {
        this.myScene = myScene;
        viewGame();
    }

    public void viewGame() {
        Game game = new Game(this, myScene);
        DashBoardModel dashBoardModel = new DashBoardModel(game);
        game.setDashBoardModel(dashBoardModel);
        GameView gameView = new GameView(game, this);
        myScene.setRootPane(gameView);
        new Thread(game).start();
    }

    public void viewEndGame(Game game) {
        // TODO: assigning right game
        GameOverScene gameOverPane = new GameOverScene(game);
        myScene.setRootPane(gameOverPane);
    }
}
