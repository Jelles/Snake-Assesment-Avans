package Model;

public class Game {
    private DashBoardModel dashBoardModel;
    private DrawModel drawModel;
    private Snake snake;

    public Game() {
        snake = new Snake(5, 5);
    }

    public Snake getSnake() {
        return this.snake;
    }

    /**
     * Gets the DrawModel model
     *
     * @return drawModel DrawModel
     */
    public DrawModel getDrawModel() {
        return this.drawModel;
    }

    /**
     * Gets the dashboard model
     *
     * @return dashBoardModel DashBoardModel
     */
    public DashBoardModel getDashBoardModel() {
        return this.dashBoardModel;
    }

    /**
     * Sets the DashBoardModel to the given DashBoardModel
     *
     * @param dashBoardModel DashBoardModel
     */
    public void setDashBoardModel(DashBoardModel dashBoardModel) {
        this.dashBoardModel = dashBoardModel;
    }

    /**
     * Sets the DrawModel to the given DrawModel
     *
     * @param drawModel DrawModel
     */
    public void setDrawModel(DrawModel drawModel) {
        this.drawModel = drawModel;
    }
}
