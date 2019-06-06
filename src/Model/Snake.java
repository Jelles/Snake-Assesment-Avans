package Model;

import Controller.Controller;

import java.util.ArrayList;

public class Snake {
    private int xPos;
    private int yPos;
    private Direction direction;
    private ArrayList<BodyPart> bodyParts;
    private Controller controller;

    public Snake(int xPos, int yPos, Controller controller) {
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
        this.xPos--;
    }

    public void moveRight() {
        System.out.println(xPos);
        if (xPos == 18) {
            controller.viewEndGame();
        }
        this.xPos++;
    }

    public void moveUp() {
        this.yPos--;
    }

    public void moveDown() {
        this.yPos++;
    }

    public Direction getDirection() {
        return this.direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }
}
