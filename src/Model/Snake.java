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

    private void wallCollapse() {
        if (yPos == 15 || xPos == -1) controller.viewEndGame();
        if (xPos == 19 || yPos == -1) controller.viewEndGame();
    }

    private void bodyCollapse() {
        for (BodyPart bodyPart : bodyParts)
            if (xPos == bodyPart.getxPos() && yPos == bodyPart.getyPos()) controller.viewEndGame();
    }

    private void moveBodyParts() {
        for (int i = bodyParts.size() - 1; i >= 0; i--) {
            if (i == 0) {
                bodyParts.get(i).setxPos(xPos);
                bodyParts.get(i).setyPos(yPos);
                bodyParts.get(i).setDirection(direction);
            } else {
                bodyParts.get(i).setyPos(bodyParts.get(i - 1).getyPos());
                bodyParts.get(i).setxPos(bodyParts.get(i - 1).getxPos());
                bodyParts.get(i).setDirection(bodyParts.get(i - 1).getDirection());
            }
        }
    }

    public void moveLeft() {
        wallCollapse();
        bodyCollapse();
        moveBodyParts();
        xPos--;
    }

    public void moveRight() {
        wallCollapse();
        bodyCollapse();
        moveBodyParts();
        xPos++;
    }

    public void moveUp() {
        wallCollapse();
        bodyCollapse();
        moveBodyParts();
        yPos--;
    }

    public void moveDown() {
        wallCollapse();
        bodyCollapse();
        moveBodyParts();
        yPos++;
    }
}
