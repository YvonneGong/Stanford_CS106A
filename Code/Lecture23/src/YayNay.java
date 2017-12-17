/* File: YayNay.java
 * ------------------------
 * This program is a simple interactors program
 * showing how to respond when a user clicks a button.
 */
import javax.swing.*;
import acm.program.*;
import java.awt.event.*;

public class YayNay extends ConsoleProgram {
	
	public void init() {
		JButton button15 = new JButton("Yay");
		add(button15, SOUTH);
		JButton button20 = new JButton("Nay");
		add(button20, SOUTH);
		addActionListeners();
	}
	
	public void actionPerformed(ActionEvent event) {
		println(event.getActionCommand());
	}
}
