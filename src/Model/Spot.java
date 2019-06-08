package Model;

import Controller.Controller;

public class Spot {
    private int xPos;
    private int yPos;
    private Marker type;
    private Controller controller;

    public Spot(int xPos, int yPos, Marker type, Controller controller) {
        this.controller = controller;
        this.xPos = xPos;
        this.yPos = yPos;
        this.type = type;
    }

    public Marker getType() {
        return type;
    }

    public int getxPos() {
        return this.xPos;
    }

    public int getyPos() {
        return this.yPos;
    }

    /**
     * Runs the right action for the obstacle (Spot)
     */
    public void action() {
        switch (type) {
            case FIRE:
                controller.fireSpot();
                break;
            case BEAR:
                controller.bearSpot(this);
                break;
            case MOUSE:
                controller.mouseSpot(this);
                break;
        }
    }
}
