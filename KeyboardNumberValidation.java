/**  
 * A KeyListener to validate text in a textfield.
 *  Will turn the background of the textfield red or
 * green to indicate invalid/valid input, where valid
 * means "can be parsed as an integer" in this case.
 * Turns background to yellow, if nothing is typed.
 **/
 
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JTextField;

public class KeyboardNumberValidation implements KeyListener  {

   @Override
   public void keyTyped(KeyEvent event)  {      
   }

   @Override
   public void keyPressed(KeyEvent event)  {
   }

   @Override
   public void keyReleased(KeyEvent event)  {
	   JTextField field = (JTextField) event.getSource();
	   
		if (field.getText().equals(""))
			//Otherwise, if all text is removed, background is set to red.
			field.setBackground(Color.YELLOW);
		
		else if (isValidAge(field.getText()))
		//If text valid, background = green.			
			field.setBackground(Color.GREEN);
      
		else 
			//In all other cases, background=red.
			field.setBackground(Color.RED);
   }

   private boolean isValidAge(String ageValue)  {
	   //checks if text is an int or not.
      try {
         Integer.parseInt(ageValue);
         return true;
      }
      catch (NumberFormatException e)  {
         return false;
      }
   }
}

