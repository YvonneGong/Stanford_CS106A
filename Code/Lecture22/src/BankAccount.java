/* File: Employee.java
 * -------------------
 * This file defines a new variable type called BankAccount.
 * A BankAccount has a name and balance.  It has getters
 * for both of them, and has a method to deposit money and
 * withdraw money.
 * 
 * You can create a BankAccount variable by specifying either the
 * account-holder name, or the name and initial balance.
 */
public class BankAccount {
	
	// Step 1: what information is in a BankAccount?
	private String name;
	private double balance;
	
	// Step 3: how do you create a BankAccount?
	
	// Make a BankAccount specifying the name and the balance
	public BankAccount(String accountName, double startBalance) {
		name = accountName;
		balance = startBalance;
	}
	
	// Make a BankAccount specifying the name, with a balance of 0
	public BankAccount(String accountName) {
		name = accountName;
		balance = 0;
	}
	
	// Step 2: what can a BankAccount do?
	
	// Setter: Sets the BankAccount name as long as the new name is not ""
	public void setName(String newName) {
		if (newName.length() > 0) {
			name = newName;
		}
	}
	
	// Getter: Returns the account-holder name
	public String getName() {
		return name;
	}
	
	// Getter: Returns the account balance
	public double getBalance() {
		return balance;
	}
	
	// Deposits money into the account if it's a positive amount.
	public void deposit(double amount) {
		if (amount >= 0) {
			balance += amount;
		}
	}
	
	/* Withdraws money from the account if it's a positive amount <= the balance.
	 * Returns whether or not the withdrawal was successful.
	 */
	public boolean withdraw(double amount) {
		if (amount >= 0 && balance >= amount) {
			balance -= amount;
			return true;
		}
		return false;
	}
	
	// define the toString method to tell Java how to print out a BankAccount
	public String toString() {
		return name + " has $" + balance;
	}
}
