/*
 * File: MouseTracker.java
 * -----------------
 * This is a program displays a GRect that follows
 * the mouse around the screen.
 * 
 * This program requires an instance variable to store the GRect so
 * its location can be changed in the mouseMoved method. 
 */

import acm.program.*;
import acm.graphics.*;
import java.awt.*;
import java.awt.event.*;

public class MouseTracker extends GraphicsProgram {
	
	// Private instance variable - accessible in run *and* in mouseMoved
	// It lives outside of any method, so it gets created only once.
	private GRect rect;
	
	public void run() {
		rect = new GRect(0, 0, 50, 50);
		rect.setFilled(true);
		rect.setColor(Color.BLUE);
		add(rect);
	}
	
	// Step 1: define the mouse method for the event you want to act on
	// Must match the prototype EXACTLY!
	public void mouseMoved(MouseEvent event) {

		// Step 2: get information about the event (here, mouse x and y)
		double mouseX = event.getX();
		double mouseY = event.getY();
		
		// Step 3: Do something in response to this event (move rect to be
		// centered at mouse location)
		double rectX = mouseX - rect.getWidth() / 2.0;
		double rectY = mouseY - rect.getHeight() / 2.0;
		rect.setLocation(rectX, rectY);
	}
}
