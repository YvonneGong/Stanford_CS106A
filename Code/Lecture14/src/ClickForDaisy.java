/*
 * File: ClickForDaisy.java
 * -----------------
 * This is a program that adds a picture of Daisy (the dog)
 * to the screen when the user clicks the mouse.
 */

import acm.program.*;
import acm.graphics.*;
import java.awt.*;
import java.awt.event.*; // for Java events

public class ClickForDaisy extends GraphicsProgram {

	// Step 1: define the mouse method for the event you want to act on
	// Must match the prototype EXACTLY!
	public void mouseClicked(MouseEvent event) {

		// Step 2: Do something in response to this event (add Daisy image at 50, 50)
		GImage daisy = new GImage("res/daisy.png", 50, 50);
		add(daisy);
	}
}
