/** 
 * An application to demonstrate some aspects of GUI
 * programming. Included focus listener, action listener and key listener
 * to validate text in a text field, and respond to events for buttons.
 **/
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class AgeInputWindow extends JFrame {

	public AgeInputWindow(String title)  { 
      
		super(title);
		setLayout(new GridLayout(3,0));

		//  add a button to close the window and an action listener
		JButton closeButton = new JButton("Close window");
		closeButton.addActionListener(new CloseButtonListener(this));

		JTextField nameField = new JTextField(20);
		JTextField ageField = new JTextField(20);

		//  add the validation listener to the ageField
		ageField.addKeyListener(new KeyboardNumberValidation());

		//  add a focus listener to both textfields
		//  note, uses the same listener for both textfields
		TextFieldFocusListener focusListener = new TextFieldFocusListener();
		nameField.addFocusListener(focusListener);
		ageField.addFocusListener(focusListener);

		//  add the components to the frame
		add(new JLabel("Type in your name"));
		add(nameField);
		add(new JLabel("Type in your age"));
		add(ageField);
		add(new JLabel());
		add(closeButton);
	}

	public static void main (String[] args) {
		AgeInputWindow window = new AgeInputWindow("Age Input Window");
		window.pack();
		window.setDefaultCloseOperation(EXIT_ON_CLOSE);
		window.setVisible(true);

	}  /*  End of "main" method  */     

}

