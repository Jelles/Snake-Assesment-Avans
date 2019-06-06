package Model;

import java.util.ArrayList;

public class Snake {
    private int xPos;
    private int yPos;
    private ArrayList<BodyPart> bodyParts;

    public Snake(int xPos, int yPos) {
        this.xPos = xPos;
        this.yPos = yPos;
    }

    public int getxPos() {
        return this.xPos;
    }

    public int getyPos() {
        return this.yPos;
    }
}
