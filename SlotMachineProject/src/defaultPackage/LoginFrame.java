//Author: Lino Virgen
//Class: CS 2365
//Date: 05/10/17

package defaultPackage;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class LoginFrame extends JFrame
{
	//frame sections
	private JLabel label1; //title label
	private JLabel label2; //direction label
	static private JTextField field1; //username field
	static private JButton button1; //submit button
	
	//variables to retrieve
	static private String username;
	
	
	public LoginFrame()
	{   		
		//Initializing sections of frame
		super("Login");
		setLayout(new FlowLayout());
		label1 = new JLabel("<html>Slot Machine Game<br><br></html>");
		label2 = new JLabel("<html>Enter username:<br></html>");
		field1 = new JTextField(30);
		button1 = new JButton("Log In");
		
		username = "";
		
		//configuring sections of frame
		label1.setHorizontalTextPosition(SwingConstants.CENTER);
		label1.setFont(new Font("Courier", Font.BOLD,75));
		
		label2.setHorizontalTextPosition(SwingConstants.CENTER);
		label2.setFont(new Font("Courier", Font.ITALIC,40));
		
		field1.setFont(new Font("Courier", Font.PLAIN,40));
		
		button1.setHorizontalTextPosition(SwingConstants.CENTER);
		button1.setFont(new Font("Courier", Font.PLAIN,40));
		
		//adding sections to frame
		add(label1);
		add(label2);
		add(field1);
		add(button1);
		
		addButtonAction();
		
	}

	static void addButtonAction()
	{
		// add the listener to the jbutton to handle the "pressed" event
		button1.addActionListener(new ActionListener()
	    {
	      public void actionPerformed(ActionEvent e)
	      {
	    	  username = field1.getText();
	      }
	    });
	  }
	
	public String getUsername()
	{
		return username;
	}
}