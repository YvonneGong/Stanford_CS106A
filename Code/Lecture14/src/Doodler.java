/*
 * File: Doodler.java
 * -----------------
 * This is a program that lets the user "doodle" by drawing
 * GRects along the path where the user clicks and drags the mouse.
 */

import acm.graphics.*;
import acm.program.*;
import acm.util.*;
import java.awt.*;
import java.awt.event.*;

public class Doodler extends GraphicsProgram {	
	
	private static final int SQUARE_SIZE = 10;
	
	// (Extra) if the user clicks the mouse, clear the screen.
	public void mouseClicked(MouseEvent event) {
		removeAll();
	}
	
	/* If the user presses and drags with the mouse, add a GRect at each drag location.
	 * This will make it look like the mouse is tracing a path of GRects.
	 */
	public void mouseDragged(MouseEvent event) {
	    double mouseX = event.getX();
	    double mouseY = event.getY();
	    double rectX = mouseX - SQUARE_SIZE / 2.0;
	    double rectY = mouseY - SQUARE_SIZE / 2.0;
	    GRect rect = new GRect(rectX, rectY, SQUARE_SIZE, SQUARE_SIZE);
	    rect.setFilled(true);
	    add(rect);
	}
}




