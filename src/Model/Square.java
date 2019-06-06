package Model;

public class Square {
    private int xPos;
    private int yPos;
    private DrawModel drawModel;

    public Square(int xPos, int yPos, DrawModel drawModel) {
        this.xPos = xPos;
        this.yPos = yPos;
        this.drawModel = drawModel;
    }

    public int getxPos() {
        return this.xPos;
    }

    public int getyPos() {
        return this.yPos;
    }
}
