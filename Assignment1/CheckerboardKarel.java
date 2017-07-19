/*
 * TODO: this is the third question of the assignment one
 * the goal is to make a checkerboard pattern of beepers
 * regardless the size of the rectangular world 
 */

import stanford.karel.*;

public class CheckerboardKarel extends SuperKarel {
	
	// make a checkrboard pattern on an empty world
	
	public void run() {
		while (leftIsClear()) {
			fillFrontRow();
			returnBack();
			moveUp();
		}
		fillFrontRow();
	}
	
	/* fill the front row
	 * pre-condition: facing east, at (1,x), front row is empty
	 * end_condition: facing east, at (n,x), the row past is filled
	 */
	private void fillFrontRow() {
		if (rightIsBlocked()){
			fillFirstRow();
		}else{
			if (leftIsBlocked()){
				fillLastRow();
			}else{		
				fillRestRow();
			}
		}
	}
	
	/* fill the first line
	 * pre-condition: at(1,1), facing east
	 * end-condition: at the end or close to the end of row, 
	 * facing east, filled the first row
	 */
	
	private void fillFirstRow() {
		putBeeper();
		while (twoAheadClear()){
			move();
			move();
			putBeeper();
		}
	}
	
	/* fill the last row of Karel
	 * pre-condition: at (n,1), facing east
	 * end-condition: at or near (n,n), facing east, filled the row
	 */
	
	private void fillLastRow(){
		fillRestRow();
	}
	
	/* create a new boolean method called twoAheadIsClear to check whether
	 * two steps ahead is clear
	 * if yes, return true; otherwise, return false
	 */
	
	public boolean twoAheadClear(){
		if (frontIsClear()){
			move();
			if (frontIsClear()){
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
			}else{
			return false;
			}
		}
	
	/* fill the row except for the first and the last one
	 * pre-condition: beginning of one row, facing east
	 * end-condition: at or close to the end of one row, facing east, filled the row
	 */
	private void fillRestRow(){
		if (rightBeeperPresent()){
			if (frontIsClear()){
				move();
				fillFirstRow();		
			}		
		}else{
			fillFirstRow();
		}	
	}
	
	
	/* create a new boolean method called rightBeeperPresent to check whether
	 * right side has beeper; if so, return true
	 */
	
	public boolean rightBeeperPresent(){
		turnRight();
		move();
		if (beepersPresent()){
			turnAround();
			move();
			turnRight();
			return true;
		}else{
			turnAround();
			move();
			turnRight();
			return false;
		}
	}
	
	/*return back to (1,x)
	 * pre-condition: at (n,x), facing east
	 * end-condition: at (1,x), facing east 
	 */
	
	private void returnBack() {
		turnAround();
		while (frontIsClear()) {
			move();
		}
		turnAround();
	}
	
	/* move up one row
	 * pre-condition: at (1,x), facing east
	 * end-condition: at (1,x+1), facing east
	 */
	
	private void moveUp(){
		turnLeft();
		move();
		turnRight();
	}	


}
