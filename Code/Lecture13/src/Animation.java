/*
 * File: Animation.java
 * -----------------
 * A program that animates squares on the canvas.
 */

import acm.graphics.*;
import acm.program.*;
import java.awt.*;

public class Animation extends GraphicsProgram {
	public void run() {
		setBackground(Color.YELLOW);
		
		// animate three colored squares
		drawAnimatedSquare(20, 20, 100);
		drawAnimatedSquare(300, 70, 50);
		drawAnimatedSquare(10, 200, 200);
	}
	
	/* Draws a blue square at the given x/y position and with the given size.
	 * Also animates the square to the right edge of the screen and back.
	 */
	public void drawAnimatedSquare(int x, int y, int size) {
		GRect square = new GRect(x, y, size, size);
		square.setFilled(true);
		square.setFillColor(Color.BLUE);
		add(square);
		
		// move the square right until it hits the edge of the window
		while (square.getX() + square.getWidth() < getWidth()) {
			square.move(10, 0);
			pause(30);
		}
		
		// move the square left until it hits the edge of the window
		while (square.getX() > 0) {
			square.move(-10, 0);
			pause(30);
		}
	}
}
