/* File: Aquarium.java
 * -------------------
 * This program simulates fish swimming
 * around in an aquarium.  It uses a custom
 * GCanvas subclass instead of the default
 * GraphicsProgram GCanvas, so we
 * can decompose our code across multiple files.
 * 
 * This canvas handles adding fish to the aquarium
 * and animating them within the tank.
 */

import acm.program.*;
import javax.swing.*;
import java.awt.event.*;

public class Aquarium extends Program {
	
	private static final int NUM_FISH = 5;
	private FishTank tank;
	
	public void init() {
		tank = new FishTank();
		add(tank);
	}
	
	public void run() {
		tank.initialize();
		for (int i = 0; i < NUM_FISH; i++) {
			tank.addFish();
		}

		while (true) {
			tank.moveFish();
			pause(30);
		}
	}
}
