/* File: Aquariums.java
 * -------------------
 * This program simulates fish swimming
 * around in multiple aquariums.  It shows
 * the benefits of using a GCanvas subclass
 * for the fish tank, because we can easily
 * add multiple fish tanks to the screen with
 * very little extra code.
 */

import acm.program.*;
import javax.swing.*;
import java.awt.event.*;

public class Aquariums extends Program {
	
	private static final int NUM_FISH = 5;
	private static final int NUM_TANKS = 3;
	
	private FishTank[] tanks;
	
	public void init() {
		// Initialize each of our fishtanks.
		tanks = new FishTank[NUM_TANKS];
		for (int i = 0; i < tanks.length; i++) {
			tanks[i] = new FishTank();
			// Fishtanks are added on the screen left to right
			add(tanks[i]);
		}
	}
	
	public void run() {
		// Initialize and add fish to each tank
		for (FishTank tank : tanks) {
			tank.initialize();
			
			for (int i = 0; i < NUM_FISH; i++) {
				tank.addFish();
			}
		}
		
		// Animate all fish in each tank
		while (true) {
			for (FishTank tank : tanks) {
				tank.moveFish();
			}
			pause(30);
		}
	}
}
