/**  A simple action listener that will close a window.
 *  This will likely be used for a JButton element.
 *
 * Adapted from David Parsons, Foundational Java.
 *
 * @author Russell Martin, April 2018
**/
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

public class CloseButtonListener implements ActionListener  {
   private JFrame target;
   
   public CloseButtonListener(JFrame target)  {
      this.target = target;
   }

   @Override
   public void actionPerformed(ActionEvent event)  {
      target.dispose();
   }
}
