/*
 * File: ClickForDaisies.java
 * -----------------
 * This is a program that adds a picture of Daisy (the dog)
 * to the screen where the user clicks the mouse.
 */

import acm.program.*;
import acm.graphics.*;
import java.awt.*;
import java.awt.event.*; // for Java events

public class ClickForDaisies extends GraphicsProgram {

	// Step 1: define the mouse method for the event you want to act on
	// Must match the prototype EXACTLY!
	public void mouseClicked(MouseEvent event) {
		
		// Step 2: get information about the event (here, mouse x and y)
		double mouseX = event.getX();
		double mouseY = event.getY();
		
		// Step 3: Do something in response to this event
		// (add a Daisy image centered at mouse location)
		GImage daisy = new GImage("res/daisy.png");
		double daisyX = mouseX - daisy.getWidth() / 2.0;
		double daisyY = mouseY - daisy.getHeight() / 2.0;
		add(daisy, daisyX, daisyY);
	}
}
