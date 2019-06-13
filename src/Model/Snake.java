package Model;

import Controller.Controller;

import java.util.ArrayList;

public class Snake {
	private int xPos;
	private int yPos;
	private int startLength;
	private Direction direction;
	private ArrayList<BodyPart> bodyParts;
	private Controller controller;

	public Snake(int xPos, int yPos, int startLength, Controller controller) {
		this.controller = controller;
		this.direction = Direction.RIGHT;
		this.startLength = startLength;
		this.xPos = xPos;
		this.yPos = yPos;
		this.bodyParts = new ArrayList<BodyPart>();
		makeStartBody();
	}

	/**
	 * Generates the start state of the snake body
	 */
	private void makeStartBody() {
		int bodyPartxPos = xPos;
		for (int i = 0; i < startLength; i++) {
			bodyParts.add(new BodyPart(bodyPartxPos - 1, yPos, direction));
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

	public Direction getDirection() {
		return this.direction;
	}

	public void setDirection(Direction direction) {
		this.direction = direction;
	}

	/**
	 * Checks if the snake hit the wall
	 */
	private void wallCollapse() {
		if (yPos == 15 || xPos == -1 || xPos == 19 || yPos == -1)
			controller.viewEndGame();
	}

	/**
	 * Checks if the snake hit itself
	 */
	private void bodyCollapse() {
		try {
			for (BodyPart bodyPart : bodyParts)
				if (xPos == bodyPart.getxPos() && yPos == bodyPart.getyPos())
					controller.viewEndGame();
		} catch (Exception e) {
		}

	}

	/**
	 * Checks if an obstacle (Spot) is hit and runs the action for that obstacle
	 * (Spot)
	 */
	private void obstacleCollapse() {
		for (Spot obstacle : controller.getGame().getObstacles())
			if (xPos == obstacle.getxPos() && yPos == obstacle.getyPos())
				obstacle.action();
	}

	/**
	 * Moves all bodyparts to the next position
	 */
	private void moveBodyParts() {
		for (int i = bodyParts.size() - 1; i >= 0; i--) {
			if (i == 0) {
				bodyParts.get(i).setxPos(xPos);
				bodyParts.get(i).setyPos(yPos);
				bodyParts.get(i).setDirection(direction);
			} else {
				bodyParts.get(i).setyPos(bodyParts.get(i - 1).getyPos());
				bodyParts.get(i).setxPos(bodyParts.get(i - 1).getxPos());
				bodyParts.get(i).setDirection(bodyParts.get(i - 1).getDirection());
			}
		}
	}

	/**
	 * Adds a bodypart to the snake on the right position
	 */
	public void grow() {
		int xPos = bodyParts.get(bodyParts.size() - 1).getxPos();
		int yPos = bodyParts.get(bodyParts.size() - 1).getyPos();
		BodyPart bodyPart = new BodyPart(xPos, yPos, direction);
		bodyParts.add(bodyPart);
	}

	/**
	 * Checks all the collapses and moves after those collapse checks
	 */
	private void moveChecks() {
		wallCollapse();
		bodyCollapse();
		obstacleCollapse();
		moveBodyParts();
	}

	public void moveLeft() {
		moveChecks();
		xPos--;
	}

	public void moveRight() {
		moveChecks();
		xPos++;
	}

	public void moveUp() {
		moveChecks();
		yPos--;
	}

	public void moveDown() {
		moveChecks();
		yPos++;
	}

	public void removeBodyPart(int i) {
		bodyParts.remove(i);
	}
}
