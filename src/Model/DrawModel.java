package Model;

public class DrawModel {
    private final int width = 760;
    private final int height = 600;
    private final int rows = 15;
    private final int columns = 19;
    private Spot[][] playField;

    public DrawModel() {
        playField = new Spot[rows][columns];
        playField = generatePlayField();
    }

    private Spot[][] generatePlayField() {
        Spot[][] playField = new Spot[rows][columns];
        for (int x = 0; x < rows; x++) {
            System.out.println();
            for (int y = 0; y < columns; y++) {
                Spot spot = new Spot(x, y, this);
                playField[x][y] = spot;
                System.out.print(x + " " + y + " . ");
            }
        }
        return playField;
    }

    public Spot getSpot(int xPos, int yPos) {
        return playField[xPos][yPos];
    }

    public int getRows() {
        return this.rows;
    }

    public int getColumns() {
        return this.rows;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public Spot[][] getPlayField() {
        return this.playField;
    }
}
