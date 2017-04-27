import javax.swing.*;
import java.awt.*;

public class ActionReader implements ActionListener
	{
		public ActionReader()
		{
			//nothing
		}
		
		public void actionPerformed(ActionEvent event)
		{
			String string = "";
			if(event.getSource() == username)
			{
				string = String.format("Your username: "
						+ event.getActionCommand());
			}
			
			JOptionPane.showMessageDialog(null, string);
		}
	}