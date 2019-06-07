package Model;

import Controller.Controller;

import java.util.ArrayList;

public class Snake {
    private int xPos;
    private int yPos;
    private int startLength;
    private Direction direction;
    private ArrayList<BodyPart> bodyParts;
    private Controller controller;

    public Snake(int xPos, int yPos, int startLength, Controller controller) {
        this.controller = controller;
        this.direction = Direction.RIGHT;
        this.startLength = startLength;
        this.xPos = xPos;
        this.yPos = yPos;
        this.bodyParts = new ArrayList<BodyPart>();
        makeStartBody();
    }

    private void makeStartBody() {
        int bodyPartxPos = xPos;
        for (int i = 0; i < startLength; i++) {
            bodyParts.add(new BodyPart(bodyPartxPos - 1, yPos, direction));
            bodyPartxPos--;
        }
    }

    public int getxPos() {
        return this.xPos;
    }

    public int getyPos() {
        return this.yPos;
    }

    public void setxPos(int xPos) {
        this.xPos = xPos;
    }

    public void setyPos(int yPos) {
        this.yPos = yPos;
    }

    public ArrayList<BodyPart> getBodyParts() {
        return this.bodyParts;
    }

    public Direction getDirection() {
        return this.direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public void addBodyPart(BodyPart bodyPart) {
        this.bodyParts.add(bodyPart);
    }
}
