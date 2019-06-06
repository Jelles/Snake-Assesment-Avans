package View;

import Model.DrawModel;
import Model.Spot;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.TilePane;
import javafx.scene.paint.Color;

public class DrawPane extends TilePane {
    private Spot[][] playField;
    private SpotView[][] playFieldView;
    private DrawModel drawModel;
    private int rows;
    private int columns;

    public DrawPane(DrawModel drawModel) {
        this.drawModel = drawModel;
        this.setBackground(new Background(new BackgroundFill(Color.BLUE, null, null)));
        this.setPrefSize(this.drawModel.getWidth(), this.drawModel.getHeight());
        this.rows = drawModel.getRows();
        this.columns = drawModel.getColumns();
        this.playField = drawModel.getPlayField();
        this.playFieldView = generatePlayFieldView();
    }

    private SpotView[][] generatePlayFieldView() {
        SpotView[][] playFieldView = new SpotView[rows][columns];
        for (Spot[] spots : playField) {
            for (Spot spot : spots) {
                SpotView spotView = new SpotView(spot);
                if (true) {
                    if (true) {

                    } else {

                    }
                } else {
                    if (true) {

                    } else {

                    }
                }

            }

        }
        return playFieldView;
    }


}
