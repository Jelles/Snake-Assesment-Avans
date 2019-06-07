package Model;

public class BodyPart {
    private int xPos;
    private int yPos;
    private Direction direction;

    public BodyPart(int xPos, int yPos, Direction direction) {
        this.xPos = xPos;
        this.yPos = yPos;
        this.direction = direction;
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

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public Direction getDirection() {
        return this.direction;
    }
}
