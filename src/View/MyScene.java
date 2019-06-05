package View;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;

public class MyScene extends Scene {
    public MyScene(Parent root, int width, int height) {
        super(root, width, height);
    }

    public void setRootPane(Pane pane) {
        this.setRoot(pane);
    }
}
