package View;

import Controller.Controller;
import Model.Direction;
import Model.Snake;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;

public class GameScene extends Scene {
	private Controller controller;
	private DrawPane drawPane;
	private DashBoard dashBoard;
	private BorderPane rootPane;

	public GameScene(Parent root, int width, int height, Controller controller) {
		super(root, width, height);
		this.controller = controller;
		initButtons();
		rootPane = new BorderPane();
		drawPane = new DrawPane(controller);
		dashBoard = new DashBoard(controller);
		rootPane.setCenter(drawPane);
		rootPane.setBottom(dashBoard);
		setRoot(rootPane);
	}

	public void draw() {
		drawPane.draw();
	}

	/**
	 * Sets the keypress events to move the snake around
	 */
	private void initButtons() {
		this.setOnKeyReleased(new EventHandler<KeyEvent>() {
			Snake snake = controller.getGame().getSnake();

			@Override
			public void handle(KeyEvent event) {
				switch (event.getCode()) {
				case UP:
					snake.setDirection(Direction.UP);
					break;
				case LEFT:
					snake.setDirection(Direction.LEFT);
					break;
				case DOWN:
					snake.setDirection(Direction.DOWN);
					break;
				case RIGHT:
					snake.setDirection(Direction.RIGHT);
					break;
				default:
					break;

				}
			}
		});
	}
}
