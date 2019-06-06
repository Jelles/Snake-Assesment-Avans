package View;

import Model.DrawModel;
import Model.Square;
import javafx.scene.canvas.Canvas;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.TilePane;
import javafx.scene.paint.Color;

public class DrawPane extends StackPane {
    private Square[][] playField;
    private SquareView[][] playFieldView;
    private DrawModel drawModel;
    private int rows;
    private int columns;
    private Canvas canvas;
    private TilePane playFieldPanes;

    public DrawPane(DrawModel drawModel) {
        this.drawModel = drawModel;
        this.setBackground(new Background(new BackgroundFill(Color.BLUE, null, null)));
        this.setPrefSize(this.drawModel.getWidth(), this.drawModel.getHeight());
        this.rows = drawModel.getRows();
        this.columns = drawModel.getColumns();
        this.playField = drawModel.getPlayField();
        this.playFieldView = generatePlayFieldView();
        this.playFieldPanes = new TilePane();
        this.canvas = new Canvas(drawModel.getWidth(), drawModel.getHeight());
        this.getChildren().addAll(playFieldPanes, canvas);
        this.showPlayFieldView();
    }

    private void showPlayFieldView() {
        for (SquareView[] spotViews : playFieldView) {
            for (SquareView spotView : spotViews) {
                playFieldPanes.getChildren().add(spotView);
            }
        }
    }

    private SquareView[][] generatePlayFieldView() {
        SquareView[][] playFieldView = new SquareView[rows][columns];
        boolean rowSwitch = false;
        boolean colorSwitch = false;
        Color darkGray = Color.rgb(30, 30, 30);
        Color lightGray = Color.rgb(50, 50, 50);
        for (Square[] spots : playField) {
            for (Square spot : spots) {
                SquareView spotView = new SquareView(spot);
                if (rowSwitch) {
                    if (colorSwitch) {
                        spotView.setBackground(new Background(new BackgroundFill(darkGray, null, null)));
                    } else {
                        spotView.setBackground(new Background(new BackgroundFill(lightGray, null, null)));
                    }
                } else {
                    if (rowSwitch) {
                        spotView.setBackground(new Background(new BackgroundFill(darkGray, null, null)));
                    } else {
                        spotView.setBackground(new Background(new BackgroundFill(Color.BLACK, null, null)));
                    }
                }
                colorSwitch ^= true;
                playFieldView[spot.getxPos()][spot.getyPos()] = spotView;
            }
            rowSwitch ^= true;
        }
        return playFieldView;
    }


}
