/* File: Brighten.java
 * -------------------
 * This program shows how we can use 2D arrays and GImages
 * to modify an image's pixels to make it brighter.
 * -------------------
 */

import java.awt.*;
import java.awt.event.*;
import acm.graphics.*;
import acm.program.*;
import acm.util.*;

public class Brighten extends GraphicsProgram {
	private GImage image;
	
	public void run() {	
		image = new GImage("res/ocean.jpg");
		setCanvasSize(image.getWidth(), image.getHeight());
		add(image);
	}
	
	// Every time the mouse is clicked, make the image slightly brighter
	public void mouseClicked(MouseEvent e) {
		int[][] pixels = image.getPixelArray();
		
		// Loop over all pixels and increase their RGB values
		for (int r = 0; r < pixels.length; r++) {
		    for (int c = 0; c < pixels[0].length; c++) {
		    		int pixel = pixels[r][c];
		    		
		    		// Increase RGB values by 5
		        int red = GImage.getRed(pixel) + 5;
		        int green = GImage.getGreen(pixel) + 5;
		        int blue = GImage.getBlue(pixel) + 5;
		        int newPixel = GImage.createRGBPixel(red, green, blue);
		        pixels[r][c] = newPixel;
		    }
		}
		
		// Update the image with the new pixels
		image.setPixelArray(pixels);
	}
}
