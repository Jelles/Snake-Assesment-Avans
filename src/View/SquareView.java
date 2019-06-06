package View;

import Model.Square;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;

public class SquareView extends StackPane {
    private final int SIZE = 40;
    private Square spot;

    public SquareView(Square spot) {
        this.spot = spot;
        this.setPrefSize(SIZE, SIZE);
        this.setBackground(new Background(new BackgroundFill(Color.BLACK, null, null)));
    }
}
