/*
 * File: MyWhackAMole.java
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

public class MyWhackAMole extends GraphicsProgram {
	
	// Points the user needs to get to win
	private static final int MAX_SCORE = 10;
	
	// Pause in between adding moles
	private static final double PAUSE_TIME = 500;

	
}
