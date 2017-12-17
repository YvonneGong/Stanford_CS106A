/*
 * File: Fish.java
 * ---------------
 * A class representing a single fish in an aquarium.  A fish
 * consists of a GImage for itself, as well as its goal x/y
 * where it is swimming to within the tank.  Each call
 * to swim() makes the fish move by a small amount towards its goal.
 * The fish will swim towards its goal until it reaches it, at
 * which point it will randomly select a new goal location. 
 * 
 *  The fish's image will always be updated to face the direction
 *  of its current goal.
 */

import acm.graphics.*;
import acm.util.*;

public class Fish {
	
	// How much a fish moves each "swim"
	private static final int MOVE_AMOUNT = 5;
	
	// Instance variables
	private GImage image;
	private double goalX;
	private double goalY;
	
	public Fish(int maxX, int maxY) {
		image = new GImage("res/blueFishRight.png");

		// Randomize initial location
		double x = RandomGenerator.getInstance().nextDouble(0, maxX - image.getWidth());
		double y = RandomGenerator.getInstance().nextDouble(0, maxY - image.getHeight());
		image.setLocation(x, y);
		
		pickNewGoal(maxX, maxY);
	}
	
	/*
	 * This method picks a new random goal point within the given x/y bounds. 
	 * It also updates the fish image to face the new goal location.
	 */
	private void pickNewGoal(int maxX, int maxY) {
		goalX = RandomGenerator.getInstance().nextDouble(0, maxX - image.getWidth());
		goalY = RandomGenerator.getInstance().nextDouble(0, maxY - image.getHeight());
		
		if (image.getX() > goalX) {
			image.setImage("res/blueFishLeft.png");
		} else {
			image.setImage("res/blueFishRight.png");
		}
	}
	
	// This method returns the image for this fish.
	public GImage getImage() {
		return image;
	}
	
	/*
	 * This method makes the fish swim a small amount towards its goal location.
	 * If it reaches its goal, the fish randomly chooses another goal location.
	 */
	public void swim(int maxX, int maxY) {
		swimTowardsGoal();
		
		if (image.getX() == goalX && image.getY() == goalY) {
			pickNewGoal(maxX, maxY);
		}
	}
	
	/*
	 * This method makes the fish swim a small amount in the correct direction
	 * towards its goal.
	 */
	private void swimTowardsGoal() {
		double dy = goalY - image.getY();
		double dx = goalX - image.getX();
		double dist = Math.sqrt(dx * dx + dy * dy);
		if(dist > MOVE_AMOUNT) {
			// move MOVE_AMT pixels towards the goal
			double moveX = MOVE_AMOUNT / dist * dx;
			double moveY = MOVE_AMOUNT / dist * dy;
			image.move(moveX, moveY);
		} else {
			image.setLocation(goalX, goalY);
		}
	}
}
