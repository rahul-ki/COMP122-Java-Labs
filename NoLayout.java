/**  
 * An example to illustrate some GUI elements.
 * LAB 11
 **/

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants.*;
import java.awt.Point;
import java.awt.Dimension;

public class NoLayout extends JFrame  {

   private JLabel label1, label2;
   private JTextField textField1;
   private JPasswordField textField2;
   private JButton button;

   public NoLayout()  {
      //  turn off the default layout manager to have 2 labels.
      setLayout(null);
      
      //  create the components
      label1 = new JLabel("Username: ");
      textField1 = new JTextField(20);
      textField1.setToolTipText("Username");
	  label2 = new JLabel("Password : ");
	  textField2 = new JPasswordField(20);
	  textField2.setToolTipText("Password");
      button = new JButton("Log in");
      button.setEnabled(true);
      
      //  add the components to the frame
      add(label1);
	  add(label2);
      add(textField1);
	  add(textField2);
      add(button);
	  
      //  position the components and size them
      label1.setBounds(10, 20, 300, 50);
	  label2.setBounds(10, 50, 300, 50);
      textField1.setBounds(110, 30, 200, 30);
	  textField2.setBounds(110, 60, 200, 30);
      button.setBounds(110, 90, 100, 30);
   }

   public static void main(String[] args)  {
      NoLayout frame = new NoLayout();
      frame.setTitle("A login window");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setLocation(new Point (200,170));
	  frame.setSize(new Dimension (500,200));
      frame.setVisible(true);
   }

}
