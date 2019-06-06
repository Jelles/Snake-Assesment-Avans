package View;

import Controller.Controller;
import Model.Game;
import javafx.scene.layout.BorderPane;

public class GameView extends BorderPane {
    private DrawPane drawPane;
    private DashBoard dashBoard;
    private Game game;

    public GameView(Game game, Controller controller) {
        this.game = game;
        drawPane = new DrawPane(game);
        dashBoard = new DashBoard(this.game.getDashBoardModel(), game, controller);
        game.setDrawPane(drawPane);
        setCenter(drawPane);
        setBottom(dashBoard);
    }
}
