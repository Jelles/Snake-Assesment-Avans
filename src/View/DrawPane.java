package View;

import Model.DrawModel;
import javafx.scene.layout.TilePane;

public class DrawPane extends TilePane {
    private DrawModel drawModel;

    public DrawPane(DrawModel drawModel) {
        this.drawModel = drawModel;
    }
}
