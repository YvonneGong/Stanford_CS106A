/* File: Pointillism.java
 * -------------------
 * This program mimics the "pointillism" artistic technique
 * by randomly picking pixels from an image and drawing that
 * pixel as a small GOval on the screen.
 * -------------------
 */
import java.awt.*;
import acm.graphics.*;
import acm.program.*;
import acm.util.*;

public class Pointillism extends GraphicsProgram {

	private static final int NUM_POINTS = 15000;
	private static final int CIRCLE_RADIUS = 6;
	private static final String IMG_NAME = "res/beach.jpg";
	
	public void run() {	
		setBackground(Color.BLACK);
		
		GImage img = new GImage(IMG_NAME);
		setCanvasSize(img.getWidth(), img.getHeight());

		int[][] pixels = img.getPixelArray();
		for(int i = 0; i < NUM_POINTS; i++) {
			// Pick a random pixel
			int c = RandomGenerator.getInstance().nextInt(pixels[0].length);
			int r = RandomGenerator.getInstance().nextInt(pixels.length);
			int rgb = pixels[r][c];
			
			// Add a colored circle to represent this pixel
			Color color = new Color(rgb);
			addColoredCircle(r, c, color);
			if(i < 50) pause(50);
		}
	}

	// A method that adds a CIRCLE_RADIUS GOval of the given
	// color at the given location on the canvas.
	private void addColoredCircle(int row, int col, Color c) {
		double size = CIRCLE_RADIUS * 2;
		GOval oval = new GOval(size, size);
		oval.setFilled(true);
		oval.setColor(c);
		add(oval, col - CIRCLE_RADIUS, row - CIRCLE_RADIUS);
	}
}
