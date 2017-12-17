/* File: MyGrayscale.java
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

public class MyGrayscale extends GraphicsProgram {

	
	// Calculate the luminosity of a pixel using NTSC formula
	private int computeLuminosity(int r, int g, int b) {
		return GMath.round(0.299 * r + 0.587 * g + 0.114 * b);
	}
}
