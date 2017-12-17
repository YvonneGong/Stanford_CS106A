/*
 * File: DribbleCastle.java
 * -----------------
 * A program that simulates building a dribble castle, which is
 * made by dropping sand from the top one dribble at a time.
 */

import acm.program.*;
import acm.graphics.*;
import acm.util.*;
import java.awt.*;
import java.awt.event.*;

public class DribbleCastle extends GraphicsProgram {
	
	/* Number of dribbles to drop */
	private static final int N_DRIBBLES = 200;
	
	/* The delay between frames. */
	private static final double PAUSE_TIME = 1;
	
	/* How fast the dribbles fall. */
	private static final double Y_VELOCITY = 5;
	
	/* The color of a dribble. */
	private static final Color SAND_COLOR = Color.ORANGE;
	
	/* The diameter of a dribble. */
	private static final int DRIBBLE_DIAMETER = 20;

	
	public void run() {
		for(int i = 0; i < N_DRIBBLES; i++) {
			dropOneDribble();
		}
	}
	
	/*
	 * Simulates dropping one dribble until it hits another, or hits the
	 * bottom of the screen.
	 */
	private void dropOneDribble() {
		GOval dribble = makeDribble();
		add(dribble);
		
		/* Move the dribble until it hits something. */
		while (!hasHitBottom(dribble) && !hasHitSomethingElse(dribble)) {
			dribble.move(0, Y_VELOCITY);
			pause(PAUSE_TIME);
		}
	}
	
	/*
	 * Given a dribble, returns whether that dribble has hit the
	 * bottom of the screen.
	 */
	private boolean hasHitBottom(GOval dribble) {
		double bottomY = dribble.getY() + dribble.getHeight();
		return bottomY >= getHeight();
	}
	
	/*
	 * Creates and returns a new dribble with a random
	 * on-screen X and a Y of 0.
	 */
	private GOval makeDribble() {
		int randomX = RandomGenerator.getInstance().nextInt(0, getWidth() - DRIBBLE_DIAMETER);
		GOval newDribble = new GOval(randomX, 0, DRIBBLE_DIAMETER, DRIBBLE_DIAMETER);
		newDribble.setFilled(true);
		newDribble.setColor(SAND_COLOR);
		return newDribble;
	}
	
	/*
	 * Given a dribble, returns whether that dribble has collided
	 * with any other objects on screen.
	 */
	private boolean hasHitSomethingElse(GOval dribble) {
		double checkX = dribble.getX() + dribble.getWidth() / 2.0;
		double checkY = dribble.getY() + dribble.getHeight();
		GObject hit = getElementAt(checkX, checkY);
		return hit != null;
	}
}