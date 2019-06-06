package Controller;

import Model.DashBoardModel;
import Model.DrawModel;
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
        Game game = new Game();
        DashBoardModel dashBoardModel = new DashBoardModel();
        DrawModel drawModel = new DrawModel();
        game.setDrawModel(drawModel);
        game.setDashBoardModel(dashBoardModel);
        GameView gameView = new GameView(game);
        myScene.setRootPane(gameView);
    }

    public void viewEndGame() {
        // TODO: assigning right game
        GameOverScene gameOverPane = new GameOverScene(new Game());
        myScene.setRootPane(gameOverPane);
    }
}
