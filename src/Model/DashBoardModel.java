package Model;

public class DashBoardModel {
    private final int width = 760;
    private final int height = 50;
    private Game game;

    public DashBoardModel(Game game) {
        this.game = game;
    }

    /**
     * Gets the width of the dashboard
     *
     * @return int width
     */
    public int getWidth() {
        return width;
    }

    /**
     * Gets the height of the dashboard
     *
     * @return int height
     */
    public int getHeight() {
        return height;
    }
}
