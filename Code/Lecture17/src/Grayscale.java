/* File: Grayscale.java
 * -------------------
 * This program shows how we can use 2D arrays and GImages
 * to modify an image's pixels to make it grayscale.
 * -------------------
 */

import java.awt.*;
import java.awt.event.*;
import acm.graphics.*;
import acm.program.*;
import acm.util.*;

public class Grayscale extends GraphicsProgram {
	public void run() {	
		GImage image = new GImage("res/daisy.jpg");
		setCanvasSize(image.getWidth(), image.getHeight());
		add(image);

		int[][] pixels = image.getPixelArray();

		// Loop over all pixels and convert them to grayscale
		for (int r = 0; r < pixels.length; r++) {
			for (int c = 0; c < pixels[0].length; c++) {
				int pixel = pixels[r][c];

				int red = GImage.getRed(pixel);
				int green = GImage.getGreen(pixel);
				int blue = GImage.getBlue(pixel);
				
				int luminosity = computeLuminosity(red, green, blue);
				int newPixel = GImage.createRGBPixel(luminosity, luminosity, luminosity);
				pixels[r][c] = newPixel;
			}
		}

		// Update the image with the new pixels
		image.setPixelArray(pixels);
	}
	
	// Calculate the luminosity of a pixel using NTSC formula
	private int computeLuminosity(int r, int g, int b) {
		return GMath.round(0.299 * r + 0.587 * g + 0.114 * b);
	}
}
