package Model;

public class Spot {
    private int xPos;
    private int yPos;
    private DrawModel drawModel;

    public Spot(int xPos, int yPos, DrawModel drawModel) {
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
