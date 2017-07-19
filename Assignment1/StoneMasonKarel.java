/*
 * this is the second problem of assignment 1
 * the goal is to repair the damaged store - represent by beeper
 */

import stanford.karel.*;

public class StoneMasonKarel extends SuperKarel {
	
	// add all the missing stone
	public void run(){
		while (frontIsClear()){
			fillUp();
			returnBack();
			moveForward();	
		}
		fillUp();
		returnBack();
	}
	
	/* pre-condition: face east
	 * end-condition: face north; filled all the stones down
	 */
	private void fillUp(){
		turnLeft();
		fillMissing();
	}
	
	/* fill all the missing stones on the moving way
	 * pre-condition: facing north
	 * end-condition: facing south, all the stone below filled;
	 * wall in front
	 */
	private void fillMissing(){
		while (frontIsClear()){
			if (beepersPresent() ) {
				move();
			}else {
				putBeeper();
				move();
			}
		}
		if (beepersPresent()){
			turnAround();
		}else{
			putBeeper();
			turnAround();
		}
	}
	
	/* after moving up and filling one group of stones,
	 * return back
	 * pre-condition: top of the stone, facing south
	 * end-condition: returned to the bottom face east
	 */
	private void returnBack() {
		while (frontIsClear()) {
			move();
		}
		turnLeft();		
	}
	
	/* move to the next group of stones
	 * pre-condition: at the bottom, facing east
	 * end-condition: moved 4 steps to the east; facing east
	 */
	
	private void moveForward() {
		for (int i=0; i<4; ++i){
			move();
		}
		
	}

}
