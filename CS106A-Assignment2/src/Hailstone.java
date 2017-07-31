/* This is the third question of assignment 1. The goal is to write a ConsoleProgram
 * to read in a number from user and then display the Hailstone sequence for that number,
 * followed by the number of steps taken to reach 1. After each hailstone sequence, the 
 * program should ask the user whether they would like to enter another number by "y"
 * or "n". 
 */

import acm.program.*;
import java.util.Scanner;

public class Hailstone extends ConsoleProgram {
	public void run() {
		println ("This YG's program computes Hailstone sequences.");
		//intert an empty line
		println();
		int inputNumber = readInt ("Enter a number: ");
		hailstoneSeq(inputNumber);
		while (readBoolean("Play again? ", "y", "n")){
			println();
			int nextNumber = readInt ("Enter a number: ");
			hailstoneSeq(nextNumber);
		}	
		println("Thanks for using Hailstone!");
	}
	
	
	//this method below is to compute and display the hailstone sequencing.
	private void hailstoneSeq(int inputNumber){
		//create the initial step as 0
		int steps = 0;
		while (inputNumber != 1){
			if (inputNumber%2==1){
				int nextNumber = 3*inputNumber+1;
				println(inputNumber+" is odd, so I make 3n + 1: "+nextNumber);
				inputNumber = nextNumber;
			}else{
				int nextNumber = inputNumber/2;
				println(inputNumber+" is even, so I take half: "+nextNumber);
				inputNumber = nextNumber;
			}
			steps += 1;
		}
		println ("It took "+steps+" steps to reach 1.");		
	}
	
}
