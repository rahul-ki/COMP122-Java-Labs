/** A few more GUI items on display, with one
 * handler.  .  
 *
 * Adpated from David Parsons, Foundational Java.
 *
 * @author Russell Martin, April 2018 
 */
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import javax.swing.JLabel;
import javax.swing.ButtonGroup;
import javax.swing.JButton;

public class CheckBoxExample extends JFrame implements ItemListener {

	//  declare these variables here, so as the item listener
	//  can access them from inside the listener
	JTextField textField;
	JCheckBox cBox1;
	JCheckBox cBox2;
	JCheckBox cBox3;

	public CheckBoxExample(String title)  {
		super(title);

		setLayout(null);

		//  Create a text field
		textField = new JTextField(20);
		textField.setBackground(Color.BLACK);
		textField.setForeground(Color.WHITE);
		textField.setFont(new Font("Courier", 0 , 12));
		textField.setEditable(false);
		textField.setText("Robbie Williams");
		add(textField);
		textField.setBounds(350,20,250,30);

		//  Create a label and some checkboxes to go with it
		JLabel label1 = new JLabel("Which of these things is avoidable?");
		cBox1 = new JCheckBox("Death");
		cBox2 = new JCheckBox("Taxes");
		cBox3 = new JCheckBox("Robbie Williams", true);
		add(label1);
		label1.setBounds(10,10,500,15);
		add(cBox1);
		cBox1.setBounds(10,35,100,15);
		add(cBox2);
		cBox2.setBounds(10,65,100,15);
		add(cBox3);
		cBox3.setBounds(10,95,200,15);

		//  Register the item listener for each checkbox item.  
		//  As I am implementing the item listener in this same
		//  class, I use "this" for the parameter to the method.  
		cBox1.addItemListener(this);
		cBox2.addItemListener(this);
		cBox3.addItemListener(this);

		//  Two radio buttons, so a user can select one of them
		JLabel label2 = new JLabel("Pick one of the following...");
		JRadioButton rButton1 = new JRadioButton("Option 1");
		JRadioButton rButton2 = new JRadioButton("Option 2");
		add(label2);
		label2.setBounds(10,200,200,15);
		add(rButton1);
		rButton1.setBounds(10,225,100,15);
		add(rButton2);
		rButton2.setBounds(10,260,100,15);

		//  Creating a ButtonGroup allows us to group the radio
		//  button together, so that selecting one of them 
		//  will de-xisdelect the other
		ButtonGroup buttons = new ButtonGroup();
		buttons.add(rButton1);
		buttons.add(rButton2);

		JLabel label3 = new JLabel("Here is some other text.");
		add(label3);
		//  If we want to set the background of a JLabel
		//  element, we have to set the "opaque" property to "true".
		label3.setOpaque(true);
		label3.setBackground(Color.GREEN);
		label3.setBounds(100,350,300,15);
		label3.setFont(new Font("Courier", Font.ITALIC | Font.BOLD, 20));

		JButton closeButton = new JButton("Close window");
		closeButton.addActionListener(new CloseButtonListener(this));
		add(closeButton);
		closeButton.setBounds(670,450,100,20);
	}

	//  Here is the item listener for the set of checkboxes
	@Override
	public void itemStateChanged(ItemEvent e)  {
		Object source = e.getItemSelectable();
		String s = "";
		if (source == cBox1)
			s = "Death";
		
		else if (source == cBox2)  
			s = "Taxes";
		
		else if (source == cBox3)  
			s = "Robbie Williams";
		

		//  Now we know which item was selected/de-selected
		if (e.getStateChange() == ItemEvent.SELECTED)  {
			textField.setText(textField.getText() + " " + s);
		}
		else  {
			//  Delete the string form the textfield, and
			//  clean up the textfield to remove extra spaces
			String t = textField.getText();
			t = t.replace(s, ""); //replace string s with "".
			t = t.replaceAll("^[\\s]+", ""); 
			// just "\\s" replaces 1 whitespace. 
			// "\\s+" replaces one or more whitespaces existing together.
			t = t.replaceAll("([\\s])+$", "");  
			// $ - checks if a line end follows.
			t = t.replaceAll("[\\s]{2,}"," "); 
			// {n,m} minimum n occurrences, max m occurrences.
			textField.setText(t);  		  
		}
	}

	public static void main(String[] args)  {
		CheckBoxExample frame = new CheckBoxExample("Some GUI elements");
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		frame.setBounds(0, 0, 800, 500);
		frame.setVisible(true);
	}

}

