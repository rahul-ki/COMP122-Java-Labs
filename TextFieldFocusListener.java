/**  
 * Define a FocusListener to change the background 
 * color of a JTextField when the textfield gains
 * or loses the focus.  
 **/
import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JTextField;

public class TextFieldFocusListener implements FocusListener  {

   @Override
   public void focusGained(FocusEvent event)  {
      JTextField field = (JTextField) event.getSource();
      field.setBackground(Color.YELLOW);
   }

   @Override
   public void focusLost(FocusEvent event)  {
      JTextField field = (JTextField) event.getSource();
      field.setBackground(Color.WHITE);
   }
}
