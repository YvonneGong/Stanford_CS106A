/* File: EmployeeProgram.java
 * --------------------------
 * This file is an example program using the new variable
 * type we defined, Employee.
 */
import acm.program.*;

public class EmployeeProgram extends ConsoleProgram {
	public void run() {
		Employee nick = new Employee("Nick", "Karel Programmer", 20);
		Employee bob = new Employee("Bob");
		println("Bob has salary $" + bob.getSalary());
		
		boolean promotion = nick.promote();
		while (promotion) {
			println(nick);
			promotion = nick.promote();
		}
		
		if (promotion) {
			println("Nick got a promotion!");
			println("Nick's title is now " + nick.getTitle());
			println("Nick's salary is now $" + nick.getSalary());
		} else {
			println("Nick can't be promoted anymore.");
		}
	}
}
