package Controller;

import Model.DashBoardModel;
import Model.Game;
import View.DashBoard;
import View.GameView;

public class Controller {


    public void viewGame() {
        Game game = new Game();
        DashBoardModel dashBoardModel = new DashBoardModel();
        game.setDashBoard(dashBoardModel);
        GameView gameView = new GameView(game);
    }
}
