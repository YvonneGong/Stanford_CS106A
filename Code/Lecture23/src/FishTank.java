/* File: FishTank.java
 * -------------------
 * This class represents a fishtank, which is a GCanvas
 * subclass that contains a number of fish that are
 * swimming around.  When you create one, first call
 * initialize() to initialize the graphics of the fishtank.
 * Then, call addFish() for each fish you want in the fishtank.
 * Finally, calling moveFish() in an animation loop will
 * make all the fish swim around in the tank.
 */

import acm.graphics.*;
import java.util.*;

public class FishTank extends GCanvas {
	private ArrayList<Fish> fish;
	
	public FishTank() {
		fish = new ArrayList<>();
	}
	
	/* This method adds our background image.
	 * Note that we can't do this in the constructor because
	 * we don't know the canvas size there!
	 */
	public void initialize() {
		GImage background = new GImage("res/background.jpg");
		background.setSize(getWidth(), getHeight());
		add(background);
	}
	
	// This method adds one new Fish to our list of Fish.
	public void addFish() {
		Fish newFish = new Fish(getWidth(), getHeight());
		fish.add(newFish);
		add(newFish.getImage());
	}
	
	// This method moves each fish by a small amount.
	public void moveFish() {
		for (Fish currentFish : fish) {
			currentFish.swim(getWidth(), getHeight());
		}
	}
}
