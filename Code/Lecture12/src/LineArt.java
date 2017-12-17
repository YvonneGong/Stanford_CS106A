/*
 * File: LineArt.java
 * -----------------
 * A program that draws many lines to simulate the
 * illusion of a curved shape (similar to a football).
 */

import acm.program.*;

import java.awt.event.*;

import acm.graphics.*;

public class LineArt extends GraphicsProgram {
	public void run() {
		GRect outerSquare = new GRect(10, 30, 200, 200);
		add(outerSquare);

		// top-left lines
		for (int i = 0; i < 20; i++) {
			GLine line = new GLine(210 - i*10, 30, 10, 30 + i*10);
			add(line);
		}

		// bottom-right lines
		for (int i = 0; i < 20; i++) {
			GLine line = new GLine(210, 30 + i*10, 210 - i*10, 230);
			add(line);
		}
	}
}
