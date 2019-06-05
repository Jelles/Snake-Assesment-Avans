package Controller;

import Model.DashBoardModel;
import Model.DrawModel;
import Model.Game;
import View.GameOverPane;
import View.GameView;
import View.MyScene;

public class Controller {
    private MyScene myScene;

    public Controller(MyScene myScene) {
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
        GameOverPane gameOverPane = new GameOverPane(new Game());
        myScene.setRootPane(gameOverPane);
    }
}
