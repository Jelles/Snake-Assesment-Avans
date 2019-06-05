package View;

import Model.DrawModel;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.TilePane;
import javafx.scene.paint.Color;

public class DrawPane extends TilePane {
    private DrawModel drawModel;

    public DrawPane(DrawModel drawModel) {
        this.drawModel = drawModel;
        this.setBackground(new Background(new BackgroundFill(Color.BLUE, null, null)));
        this.setPrefSize(this.drawModel.getWidth(), this.drawModel.getHeight());
    }
}
