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
        this.bodyParts = new ArrayList<BodyPart>();
        makeStartBody(xPos, yPos);
    }

    private void makeStartBody(int xPos, int yPos) {
        int bodyPartxPos = xPos;
        for (int i = 0; i < 10; i++) {
            bodyParts.add(new BodyPart(bodyPartxPos - 1, yPos));
            bodyPartxPos--;
        }
    }

    public int getxPos() {
        return this.xPos;
    }

    public int getyPos() {
        return this.yPos;
    }

    public ArrayList<BodyPart> getBodyParts() {
        return this.bodyParts;
    }

    private void moveBodyParts() {
        for (int i = bodyParts.size() - 1; i >= 0; i--) {
            if (i == 0) {
                bodyParts.get(i).setxPos(this.xPos);
                bodyParts.get(i).setyPos(this.yPos);
                return;
            }
            bodyParts.get(i).setyPos(bodyParts.get(i - 1).getyPos());
            bodyParts.get(i).setxPos(bodyParts.get(i - 1).getxPos());
        }
    }

    private void bodyCollapse() {
        for (BodyPart bodyPart : bodyParts) {
            if (xPos == bodyPart.getxPos() && yPos == bodyPart.getyPos()) {
                controller.viewEndGame(game);
            }
        }
    }


    public void moveLeft() {
        if (xPos == 0) {
            controller.viewEndGame(game);
        }
        bodyCollapse();
        moveBodyParts();
        this.xPos--;
    }

    public void moveRight() {
        if (xPos == 18) {
            controller.viewEndGame(game);
        }
        bodyCollapse();
        moveBodyParts();
        this.xPos++;
    }

    public void moveUp() {
        if (yPos == 0) {
            controller.viewEndGame(game);
        }
        bodyCollapse();
        moveBodyParts();
        this.yPos--;
    }

    public void moveDown() {
        if (yPos == 14) {
            controller.viewEndGame(game);
        }
        bodyCollapse();
        moveBodyParts();
        this.yPos++;
    }

    public Direction getDirection() {
        return this.direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }
}
