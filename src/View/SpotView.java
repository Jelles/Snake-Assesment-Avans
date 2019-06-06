package View;

import Model.Spot;
import javafx.scene.layout.StackPane;

public class SpotView extends StackPane {
    private final int SIZE = 40;
    private Spot spot;

    public SpotView(Spot spot) {
        this.setPrefSize(SIZE, SIZE);
    }
}
