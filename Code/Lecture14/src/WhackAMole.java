/*
 * File: WhackAMole.java
 * -----------------
 * This program plays the game Whack-A-Mole.  Every 1/2 second, a mole appears
 * somewhere random on the screen.  If the user clicks a mole, the mole disappears
 * and the user's score, displayed in the upper-left corner in a GLabel, increases by 1.
 * The game plays until the user gets 10 points.
 *
 * This program requires instance variables to store the score label and number so they
 * can be changed in the mouseClicked method.
 */
import acm.graphics.*;
import acm.program.*;
import acm.util.*;
import java.awt.*;
import java.awt.event.*;

public class WhackAMole extends GraphicsProgram {
	
	// Points the user needs to get to win
	private static final int MAX_SCORE = 10;

	// Pause in between adding moles
	private static final double PAUSE_TIME = 500;

	private int score;
	private GLabel scoreLabel;
	
	public void run() {
		score = 0;
		addScoreLabel();
		
		// Continuously add a new mole image in a random location every 0.5 seconds
		// until the user gets MAX_SCORE points
		while (score < MAX_SCORE) {
			GImage mole = new GImage("res/mole.png");
			double x = RandomGenerator.getInstance().nextDouble(0, getWidth() - mole.getWidth());
			double y = RandomGenerator.getInstance().nextDouble(0, getHeight() - mole.getHeight());
			mole.setLocation(x, y);
			add (mole);

			pause (PAUSE_TIME);
		}
	}
	
	// Initializes our score label as a new GLabel displaying 0 in the upper-left corner
	private void addScoreLabel() {
		scoreLabel = new GLabel("Score: " + score);
		scoreLabel.setFont("Monospaced-Bold-20");
		add(scoreLabel, 0, scoreLabel.getHeight());
	}

	/*
	 * When the mouse is clicked, if there is a mole, remove it and increment the score.
	 * Otherwise, do nothing.
	 */
	public void mouseClicked(MouseEvent event) { 
		double mouseX = event.getX();
		double mouseY = event.getY();
		
		GObject mole = getElementAt(mouseX, mouseY);
		
		// If there is no mole here, then mole will be null.  remove(null) will crash!
		if (mole != null) {
			remove(mole);
			score++;
			scoreLabel.setText("Score: " + score);
		}
	}
}
