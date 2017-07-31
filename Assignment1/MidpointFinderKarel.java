/*
 * TODO: This is the fourth question of assignment 1. The goal is 
 * to make Karel put beeper on the middle of 1st avenue. If the 
 * width of the world is odd, Karel must drop the beeper right at
 * the middle; if the width is even, he can drop the beeper at one 
 * of the two middle locations. Karel has infinite number of
 * beepers, and can drop and pick up beepers at other locations. 
 */

import stanford.karel.*;

public class MidpointFinderKarel extends SuperKarel {
	
	public void run() {
		//put the first beeper
		putBeeper();
		//put the potential second beeper if the width>1
		while (frontIsClear()){
			move();
		}
		if (noBeepersPresent()){
			putBeeper();
			turnAround();
		}

		//check east and west to narrow down the range
		//NOTE: it is very important to jump out from the inner if loop. so that noBeeperFront 
		//can be checked everytime
		while (noBeeperFront()) {
			if (facingWest()){
				checkWest();	
			}else{
				checkEast();
			}
			
		}
		//pick up the last beeper if there is two beepers adjacent
		//to each other 
		if (beeperFront()){
			move();
			pickBeeper();
			turnAround();
			move();
		}
	}
	
	
	/*check whether one space ahead has beeper or not
	 * if there is a beeper ahead, return true; if front is 
	 * blocked or no beeper present, return false
	 */
	private boolean noBeeperFront(){
		if (frontIsBlocked()){
			return false;
		}else{
			move();
			if (beepersPresent()){
				turnAround();
				move();
				turnAround();
				return false;
			}else{
				turnAround();
				move();
				turnAround();
				return true;
			}
		}
	}
	
	
	/*check the east part, and move the beeper one step closer 
	 * to the middle
	 * pre-condition: facing east, at the west side of the middle;
	 * beeper present at current location
	 * end-condition: move eastern beeper one step closer to 
	 * middle; facing west
	 * NOTE: define the eastClear condition is important, so that, it can jump out from the loop
	 * to check the upper while condition 
	 */
	private void checkEast(){
		while (eastClear()){
			move();
				if (beepersPresent()){
					pickBeeper();
					turnAround();
					move();
					putBeeper();
				}	
			}
		}
		
	
	
	/* check the west part, and move the beeper one step closer 
	 * to the middle
	 * pre-condition: facing west, at the east side of the middle;
	 * beeper present at current location
	 * end-condition: move the western beeper one step closer to 
	 * the middle; facing east
	 */
	
	private void checkWest(){
		while(westClear()){
				move();
				if (beepersPresent()){
					pickBeeper();
					turnAround();
					move();
					putBeeper();
				}
			}
		}

	
	private boolean beeperFront(){
		if (frontIsBlocked()){
			return false;
		}else{
			move();
			if (beepersPresent()){
				turnAround();
				move();
				turnAround();
				return true;
			}else{
				turnAround();
				move();
				turnAround();
				return false;
			}
		}
		
	}
	
	/* this is to check whether is facing west + whether front is clear; 
	 * if both criteria meets, return true
	 * NOTE: for boolean function, every possible condition needs to return a true or false
	 */
	
	private boolean westClear(){
		if (facingWest()){
			if (frontIsClear()){
				return true;
			}else{
				return false;
			}
		}else{
			return false;
		}
	}
	
	private boolean eastClear(){
		if (facingEast()){
			if (frontIsClear()){
				return true;
			}else{
				return false;
			}
		}else{
			return false;
		}
	}
	

	
}
