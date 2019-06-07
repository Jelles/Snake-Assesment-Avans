package Model;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.util.Duration;

public class DashBoardTimer {
    private int milliseconds;
    private int seconds;
    private int minutes;
    private StringProperty timerText;
    private Timeline time;

    public DashBoardTimer() {
        milliseconds = 0;
        timerText = new SimpleStringProperty();
        time = new Timeline();
    }

    public void start() {
        KeyFrame frame = new KeyFrame(Duration.millis(1), event -> {
            milliseconds++;
            if (milliseconds > 1000) {
                milliseconds = 0;
                seconds++;
            }
            if (seconds > 60) {
                seconds = 0;
                minutes++;
            }
            if (seconds <= 9) {
                if (minutes <= 9) {
                    timerText.set("0" + minutes + ":0" + seconds + ":" + milliseconds);
                } else {
                    timerText.set(minutes + ":0" + seconds + ":0" + milliseconds);
                }
            } else {
                if (minutes <= 9) {
                    timerText.set("0" + minutes + ":" + seconds + ":" + milliseconds);

                } else {
                    timerText.set(minutes + ":" + seconds + ":" + milliseconds);
                }
            }
        });

        time.setCycleCount(Timeline.INDEFINITE);
        time.getKeyFrames().add(frame);
        if (time != null) {
            time.stop();
        }
        time.play();
    }

    public StringProperty getTimerTextProperty() {
        return timerText;
    }

    public void pause() {
        time.pause();
    }

    public void stop() {
        time.stop();
    }

    public String getTimeText() {
        return this.timerText.get();
    }
}
