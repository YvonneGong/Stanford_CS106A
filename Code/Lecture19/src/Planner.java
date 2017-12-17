/*
 * A program that prompts for a list of tasks, and them reprompts the user
 * to enter them in the order they want to tackle them.  At the end, prints
 * out the ordering they have entered.
 * 
 * EXAMPLE OUTPUT:
 *
 * ** STEP 1 **
 * Enter task: Walk Daisy
 * Enter task: do laundry
 * Enter task: sleep
 * Enter task: 
 * ** STEP 2 **
 * Great!  Enter the order to complete your tasks.
 * Tasks remaining: [Walk Daisy, do laundry, sleep]
 * Next task to complete: do laundry
 * Tasks remaining: [Walk Daisy, sleep]
 * Next task to complete: Walk Daisy
 * Tasks remaining: [sleep]
 * Next task to complete: go to gym
 * That's not on your list - stay focused!
 * Tasks remaining: [sleep]
 * Next task to complete: sleep
 * ** STEP 3 **
 * Congrats!  Your day is all planned out:
 * [do laundry, Walk Daisy, sleep]
 */

import java.util.*;
import acm.program.*;

public class Planner extends ConsoleProgram {
	
	public void run() {
		// Step 1: Prompt for tasks
		ArrayList<String> enteredTasks = readTasks();
		
		// Step 2: reprompt for order of tasks
		ArrayList<String> orderedTasks = new ArrayList<>();
		println("Great!  Enter the order to complete your tasks.");
		while (!enteredTasks.isEmpty()) {
			println("Tasks remaining: " + enteredTasks);
			String task = readLine("Next task to complete: ");
			
			if (enteredTasks.contains(task)) {
				enteredTasks.remove(task);
				orderedTasks.add(task);
			} else {
				println("That's not on your list - stay focused!");
			}
		}
		
		// Step 3: print out new task ordering
		println(orderedTasks);
	}
	
	/* Returns the list of tasks the user wants to complete,
	 * prompting until the user enters the empty string.
	 */
	private ArrayList<String> readTasks() {
		ArrayList<String> tasks = new ArrayList<>();
		
		String task = readLine("Enter task: ");
		while (task.length() > 0) {
			tasks.add(task);
			task = readLine("Enter task: ");
		}
		
		return tasks;
	}
}
