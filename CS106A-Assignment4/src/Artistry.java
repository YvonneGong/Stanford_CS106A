/* This is part1 of assignment4. The goal is to draw graphical figure with three different
 * shapes and colors. The name should be signed at the bottom. 
 */

import acm.graphics.*; //Stanford graphical objects
import acm.program.*;
import java.awt.*; //Java graphical objects

public class Artistry extends GraphicsProgram {
	public void run() {
		//create compound
		
		GCompound BigFace = new GCompound();
		
		//set canvas size to 1000*1000 pixel 
		setCanvasSize(500,500);
		//create a 40*80 oval as a face and put it on the center of canvas
		int C_width = getWidth();
		int C_height = getHeight();
		GOval face = new GOval((C_width-200)/2, (C_height-400)/2, 200, 400);
		face.setFilled(false);
		BigFace.add(face);
		
		
		//add eyebrow, width = 80, height = 30 
		GRect eyebrow_1 = new GRect(C_width/2.0-50, C_height/2.0-75, 40, 15);
		eyebrow_1.setFilled(true);
		eyebrow_1.setFillColor(Color.DARK_GRAY);
		BigFace.add(eyebrow_1);
		
		GRect eyebrow_2 = new GRect(C_width/2.0+10, C_height/2.0-75, 40, 15);
		eyebrow_2.setFilled(true);
		eyebrow_2.setFillColor(Color.DARK_GRAY);
		BigFace.add(eyebrow_2);
		
		//add eye, width = 10, height = 10
		GOval eye_1 = new GOval(C_width/2.0-10, C_height/2.0-50, 5, 5);
		eye_1.setFilled(true);
		eye_1.setFillColor(Color.BLACK);
		BigFace.add(eye_1);
		
		GOval eye_2 = new GOval(C_width/2.0+10, C_height/2.0-50, 5, 5);
		eye_2.setFilled(true);
		eye_2.setFillColor(Color.BLACK);
		BigFace.add(eye_2);
		
		//add mouth 
		GLine mouth = new GLine(C_width/2.0-25, 350, C_width/2.0+25, 350);
		mouth.setColor(Color.RED);
		BigFace.add(mouth);
		
		add(BigFace);
		
		//sign
		GLabel sign = new GLabel("Artistry by Yanwen");
		double descent = sign.getDescent();
		add(sign,390, 500-descent);

		
		
		
		
		
		
		
		
		
		
		
	}
}
