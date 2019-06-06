package Model;

import Controller.Controller;

import java.util.ArrayList;

public class Snake {
    private int xPos;
    private int yPos;
    private Direction direction;
    private ArrayList<BodyPart> bodyParts;
    private Controller controller;
    private Game game;

    public Snake(int xPos, int yPos, Controller controller, Game game) {
        this.game = game;
        this.controller = controller;
        this.direction = Direction.RIGHT;
        this.xPos = xPos;
        this.yPos = yPos;
    }

    public int getxPos() {
        return this.xPos;
    }

    public int getyPos() {
        return this.yPos;
    }

    public void moveLeft() {
        if (xPos == 0) {
            controller.viewEndGame(game);
        }
        this.xPos--;
    }

    public void moveRight() {
        if (xPos == 18) {
            controller.viewEndGame(game);
        }
        this.xPos++;
    }

    public void moveUp() {
        if (yPos == 0) {
            controller.viewEndGame(game);
        }
        this.yPos--;
    }

    public void moveDown() {
        if (yPos == 14) {
            controller.viewEndGame(game);
        }
        this.yPos++;
    }

    public Direction getDirection() {
        return this.direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }
}
