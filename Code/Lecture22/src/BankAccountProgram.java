/* File: BankAccountProgram.java
 * --------------------------
 * This file is an example program using the new variable
 * type we defined, BankAccount.
 */
import acm.program.*;

public class BankAccountProgram extends ConsoleProgram {
	public void run() {
		BankAccount nickAccount = new BankAccount("Nick", 50);
		nickAccount.deposit(50);
		println("Nick's balance is now $" + nickAccount.getBalance());

		BankAccount rishiAccount = new BankAccount("Rishi");
		rishiAccount.deposit(50);
		boolean success = rishiAccount.withdraw(10);
		if (success) {
			println("Rishi withdrew $10.");
		}
		println(rishiAccount);
	}
}
