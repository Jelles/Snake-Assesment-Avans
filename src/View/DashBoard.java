package View;

import Model.DashBoardModel;
import javafx.scene.layout.HBox;

public class DashBoard extends HBox {

    private DashBoardModel dashBoardModel;

    public DashBoard(DashBoardModel dashBoardModel) {
        this.dashBoardModel = dashBoardModel;
    }
}
