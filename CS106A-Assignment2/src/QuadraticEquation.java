/*This is the first question of assignment 2.
 * The goal is to write an interactive Console program named QuadraticEquation which returns
 * the real root of a quadratic equation with the input of three coefficient a,b,, where a
 * is non-zero and other than that, a,b,c can be any integer. The equation is ax^2 + bx + c = 0. 
 * Depending on the values of a,b and c, there will be three types of result: 1). discriminant>0, 
 * two roots; 2). discriminant=0, one root; 3). discriminant<0, no real root. 
 */

import acm.program.*;

public class QuadraticEquation extends ConsoleProgram {
	public void run() {
		println("YG's CS 106A Quadratic Solver!");
		int a = readInt("Enter a: ");
		int b = readInt("Enter b: ");
		int c = readInt("Enter c: ");
		double discriminant = b*b-4*a*c;
		if (discriminant > 0){
			double realRoot1 = ((-b+Math.sqrt(discriminant))/(2*a));
			double realRoot2 = ((-b-Math.sqrt(discriminant))/(2*a));
			println("Two roots: "+realRoot1+" and "+realRoot2);
		}else if(discriminant == 0){
			double realRoot = (-b/(2*a));
			println("One root: "+realRoot);
		}else {
			println("No real roots");
		}
				
	}
}
