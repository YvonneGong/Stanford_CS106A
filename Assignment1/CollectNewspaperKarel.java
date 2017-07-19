/*
 * TODO: this is the first question of assignment 1
 * the goal is to program Karel so that it can pick up
 * the beeper; return to the initial position and face east
 */

import stanford.karel.*;

public class CollectNewspaperKarel extends SuperKarel {
	
	/*run the whole project
	 */
	public void run(){
		locatePick();
		returnBack();
	}
		
	
	/* move Karel to the newspaper location and pick up
	 */
	private void locatePick() {
		move();
		move();
		turnRight();
		move();
		turnLeft();
		move();		
		pickBeeper();
	}
	
	/* return to the initial position
	 * 
	 */
	private void returnBack() {
		turnBack();
		move();
		turnRight();
		move();
		turnLeft();
		move();
		move();
		turnBack();
		
	}
	
	/*define turnBack
	 */
	private void turnBack(){
		for (int i=0; i<2; i++){
			turnLeft();
		}
		
	}
	

}
