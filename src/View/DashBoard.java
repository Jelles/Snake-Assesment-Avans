package View;

import Model.DashBoardModel;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;

public class DashBoard extends HBox {

    private DashBoardModel dashBoardModel;

    public DashBoard(DashBoardModel dashBoardModel) {
        this.dashBoardModel = dashBoardModel;
        this.setBackground(new Background(new BackgroundFill(Color.GRAY, null, null)));
        this.setPrefSize(this.dashBoardModel.getWidth(), this.dashBoardModel.getHeight());
    }
}
