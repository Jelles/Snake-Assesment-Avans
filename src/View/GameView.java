package View;

import Model.Game;
import javafx.scene.layout.BorderPane;

public class GameView extends BorderPane {
    private DrawPane drawPane;
    private DashBoard dashBoard;
    private Game game;

    public GameView(Game game) {
        this.game = game;
        drawPane = new DrawPane(this.game.getDrawModel(), game);
        dashBoard = new DashBoard(this.game.getDashBoardModel(), game);
        setCenter(drawPane);
        setBottom(dashBoard);
    }
}
