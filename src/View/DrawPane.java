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
        this.showPlayFieldView();
    }

    private void showPlayFieldView() {
        for (SpotView[] spotViews : playFieldView) {
            for (SpotView spotView : spotViews) {
                this.getChildren().add(spotView);
            }
        }
    }

    private SpotView[][] generatePlayFieldView() {
        SpotView[][] playFieldView = new SpotView[rows][columns];
        boolean firstCheck = false;
        boolean secondCheck = false;
        Color darkGray = Color.rgb(30, 30, 30);
        Color lightGray = Color.rgb(50, 50, 50);
        for (Spot[] spots : playField) {
            for (Spot spot : spots) {
                SpotView spotView = new SpotView(spot);
                if (firstCheck) {
                    if (secondCheck) {
                        spotView.setBackground(new Background(new BackgroundFill(darkGray, null, null)));
                    } else {
                        spotView.setBackground(new Background(new BackgroundFill(lightGray, null, null)));
                    }

                } else {
                    if (secondCheck) {
                        spotView.setBackground(new Background(new BackgroundFill(darkGray, null, null)));
                    } else {
                        spotView.setBackground(new Background(new BackgroundFill(Color.BLACK, null, null)));

                    }
                }
                secondCheck ^= true;
                playFieldView[spot.getxPos()][spot.getyPos()] = spotView;
            }
            firstCheck ^= true;
        }
        return playFieldView;
    }


}
