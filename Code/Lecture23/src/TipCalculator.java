/* File: TipCalculator.java
 * ------------------------
 * This program demonstrates using interactors
 * to let a user calculate a tip for their bill.
 */
import javax.swing.*;
import acm.program.*;
import java.awt.event.*;

public class TipCalculator extends ConsoleProgram {

	private JTextField textField;
	
	public void init() {
		JLabel subtotalLabel = new JLabel("Subtotal: ");
		add(subtotalLabel, NORTH);

		// Text field
		textField = new JTextField(10);
		textField.addActionListener(this);
		textField.setActionCommand("15%");
		add(textField, NORTH);
		
		// Buttons
		JButton button15 = new JButton("15%");
		add(button15, NORTH);
		JButton button20 = new JButton("20%");
		add(button20, NORTH);
		addActionListeners();
	}
	
	public void actionPerformed(ActionEvent event) {
		clearConsole();
		double total = Double.parseDouble(textField.getText());
		
		// Calculate the tip depending on which button was clicked
		double tip = 0;
		if (event.getActionCommand().equals("15%")) {
			tip = total * 0.15;
		} else if (event.getActionCommand().equals("20%")){
			tip = total * 0.2;
		}
		
		println("Total: $" + total);
		println("Tip: $" + tip);
		println("New Total: $" + (total + tip));
	}
}
