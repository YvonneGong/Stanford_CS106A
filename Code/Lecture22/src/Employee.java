/* File: Employee.java
 * -------------------
 * This file defines a new variable type called Employee.
 * An Employee has a name, title, and salary.  It has getters
 * for all of them, and has a method to promote the employee,
 * which doubles its salary and adds "Senior" to the title,
 * if its salary is under $1000.
 * 
 * You can create an Employee variable by specifying either the
 * employee name, or the name, title and salary.
 */
public class Employee {
	
	// Step 1: what information is in an Employee?
	private String name;
	private String title;
	private double salary;
	
	// Step 3: how do you create an Employee?
	public Employee(String employeeName, String employeeTitle, double startSalary) {
		name = employeeName;
		title = employeeTitle;
		salary = startSalary;
	}
	
	public Employee(String employeeName) {
		name = employeeName;
		title = "Employee";
		salary = 100;
	}
	
	// Step 2: what can an employee do?
	public String getName() {
		return name;
	}
	
	public String getTitle() {
		return title;
	}
	
	public double getSalary() {
		return salary;
	}
	
	public boolean promote() {
		if (salary < 1000) {
			title = "Senior " + title;
			salary *= 2;
			return true;
		}
		return false;
	}
	
	public String toString() {
		// Nick (Karel Programmer) makes $20
		return name + " (" + title + ") makes $" + salary;
	}
}
