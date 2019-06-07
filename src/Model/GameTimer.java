package Model;

import javafx.concurrent.Task;
import javafx.scene.control.Label;

public class GameTimer extends Task<Void> {

    private Game game;
    private Label playTimeLabel;

    public GameTimer(Game game, Label playTimeLabel) {
        this.game = game;
        this.playTimeLabel = playTimeLabel;
    }


    @Override
    protected Void call() throws Exception {
        int minuten = 0;
        int seconden = 0;
        int milliseconds = 0;
        while (!game.isPause()) {
            String timerText = minuten + ":" + seconden + "." + milliseconds;
            seconden += 0.001;
            if (milliseconds > 1000) {
                milliseconds = 0;
                seconden++;
            }
            if (seconden > 60) {
                seconden = 0;
                minuten++;
            }

            Thread.sleep(1);
            milliseconds++;
            playTimeLabel.setText(timerText);

        }
        return null;
    }
}

