/*
 * File: Stoplights.java
 * -----------------
 * A program that uses a decomposed method to draw one
 * or more "stoplight" graphics that each consist of a series of
 * red-yellow-green lights on a gray background.
 */

import acm.program.*;
import acm.graphics.*;
import java.awt.*;

public class Stoplights extends GraphicsProgram {
	public void run() {
		addStoplight(50, 50, 100);
	}
	
	/* This method adds a stoplight that contains a RED-YELLOW-GREEN
	 * "light" sequence represented by 3 colored GOvals,
	 *  with the given x/y coordinates and width.
	 */
	private void addStoplight(int x, int y, int width) {
		// Add the gray background rectangle
		GRect background = new GRect(x, y, width, 3*width);
		background.setFilled(true);
		background.setFillColor(Color.gray);
		add(background);
		
		// Add the 3 "lights"
		addColoredCircle(x, y, width, Color.RED);
		addColoredCircle(x, y + width, width, Color.YELLOW);
		addColoredCircle(x, y + 2*width, width, Color.GREEN);
	}
	
	/* Adds a filled, colored circle to the canvas with
	 * the given coordinates, diameter and fill color.
	 */
	private void addColoredCircle(int x, int y, int diameter, Color fillColor) {
		GOval circle = new GOval(x, y, diameter, diameter);
		circle.setFilled(true);
		circle.setColor(fillColor);
		add(circle);
	}
}
