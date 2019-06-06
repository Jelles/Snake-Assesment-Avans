package Model;

public class DrawModel {
    private final int width = 760;
    private final int height = 600;
    private final int rows = 15;
    private final int columns = 19;
    private Square[][] playField;

    public DrawModel() {
        playField = new Square[rows][columns];
        playField = generatePlayField();
    }

    private Square[][] generatePlayField() {
        Square[][] playField = new Square[rows][columns];
        for (int x = 0; x < rows; x++) {
            System.out.println();
            for (int y = 0; y < columns; y++) {
                Square spot = new Square(x, y, this);
                playField[x][y] = spot;
                System.out.print(x + " " + y + " . ");
            }
        }
        return playField;
    }

    public Square getSpot(int xPos, int yPos) {
        return playField[xPos][yPos];
    }

    public int getRows() {
        return this.rows;
    }

    public int getColumns() {
        return this.columns;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public Square[][] getPlayField() {
        return this.playField;
    }
}
