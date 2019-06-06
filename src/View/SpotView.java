package View;

import Model.Spot;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;

public class SpotView extends StackPane {
    private final int SIZE = 40;
    private Spot spot;

    public SpotView(Spot spot) {
        this.setPrefSize(SIZE, SIZE);
        this.setBackground(new Background(new BackgroundFill(Color.BLACK, null, null)));
    }
}
