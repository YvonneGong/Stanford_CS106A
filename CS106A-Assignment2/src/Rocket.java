/* This is the fourth question of Assignment2. The goal is to write a (non-interractive) 
 * ConsoleProgram to display a rocket like figure. Key1: use constant to set the size of 
 * the figure; Key2: need to use nested for loop to draw repeated patterns. 
 */

import acm.program.*;

public class Rocket extends ConsoleProgram {
	private static final int Size=5;
	public void run() {
		//triangle with /\
		triangle(Size);
		//line with + and =
		line(Size);
		//square with | and . and /\
		squareUper(Size);
		//lower half of square
		squareLower(Size);
		//line again
		line(Size);
		//triangle again
		triangle(Size);	
	}
	
	private void triangle(int inputNumber){
		for (int i=0; i<inputNumber; i++){
			for (int j=0; j<inputNumber-i; j++){
				print(" ");
			}
			for (int k=0; k<i+1; k++){
				print("/");
			}
			for (int l=0; l<i+1; l++){
				print("\\");
			}
			for (int m=0; m<inputNumber-i; m++){
				print(" ");
			}
			print("\n");
		}
	}
	
	private void line(int inputNumber){
		print("+");
		for (int i=0; i< inputNumber*2; i++){
			print("=");
		}
		print("+");
		print("\n");
	}
	
	private void squareUper(int inputNumber){
		for (int i=0; i<inputNumber; i++){
			print("|");
			for (int j=inputNumber-i-2; j>=0; j--){
				print(".");
			}
			for (int k=0; k<=i; k++){
				print("/\\");
			}
			for (int l=inputNumber-i-2; l>=0; l--){
				print(".");
			}
			print("|");
			print("\n");
		}
	}
	
	private void squareLower(int inputNumber){
		for (int i=0; i<inputNumber; i++){
			print("|");
			for (int j=0; j<i; j++){
				print(".");
			}
			for (int k=0; k<inputNumber-i; k++){
				print("\\/");
			}
			for (int j=0; j<i; j++){
				print(".");
			}
			print("|");
			print("\n");
		}
	}
}
