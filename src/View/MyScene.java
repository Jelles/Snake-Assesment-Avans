package View;

import Controller.Controller;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;

public class MyScene extends Scene {
    private Controller controller;

    public MyScene(Parent root, int width, int height) {
        super(root, width, height);
        Controller controller = new Controller(this);
        this.controller = controller;
    }

    public Controller getController() {
        return this.controller;
    }

    public void setRootPane(Pane pane) {
        this.setRoot(pane);
    }
}
