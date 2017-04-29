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
	
	
	public LoginFrame(String size)
	{   		
		//Initializing sections of frame
		super("Login");
		setLayout(new FlowLayout());
		label1 = new JLabel("<html>Slot Machine Game<br><br></html>");
		label2 = new JLabel("<html>Enter username:<br></html>");
		field1 = new JTextField(28);
		button1 = new JButton("Log In");
		
		username = "";
		
		//configuring sections of frame
		int big_font_size = size.equals("small")? 24 : 75;
		int small_font_size = size.equals("small")? 15 : 40;
		
		label1.setHorizontalTextPosition(SwingConstants.CENTER);
		label1.setFont(new Font("Courier", Font.BOLD,big_font_size));
		
		label2.setHorizontalTextPosition(SwingConstants.CENTER);
		label2.setFont(new Font("Courier", Font.ITALIC,small_font_size));
		
		field1.setFont(new Font("Courier", Font.PLAIN,small_font_size));
		
		button1.setHorizontalTextPosition(SwingConstants.CENTER);
		button1.setFont(new Font("Courier", Font.PLAIN,small_font_size));
		
		//adding sections to frame
		add(label1);
		add(label2);
		add(field1);
		add(button1);
		
		addButtonAction();
		
	}

	static void addButtonAction()
	{
		//adding listener to button
		
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