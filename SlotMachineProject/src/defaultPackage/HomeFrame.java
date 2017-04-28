//Author: Lino Virgen
//Class: CS 2365
//Date: 05/10/17

package defaultPackage;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class HomeFrame extends JFrame
{
	//frame sections
	private JLabel label1; //Welcome label
	private JLabel label2; //Tokens label
	private JLabel label3; //Direction label
	private JLabel label4; //Cost for FormFigure label
	private JLabel label5; //Cost for Classical label
	static private JButton button1; //FormFigure button
	static private JButton button2; //Classical button
	
	//variables to retrieve
	static private boolean figure_button_pressed;
	static private boolean classical_button_pressed;
	
	public HomeFrame(String username, int tokens)
	{   
		//Initializing sections of frame
		super("Home");
		setLayout(new FlowLayout());
		label1 = new JLabel("<html>Welcome <i>"+username+"</i>!<br></html>");
		label2 = new JLabel("<html><br>You have "+tokens+" tokens<br><br></html>");
		label3 = new JLabel("<html>Choose a machine to play:</html>");
		button1 = new JButton("Form Figure");
		label4 = new JLabel("<html>1 token per play</html>");
		button2 = new JButton("Classical");
		label5 = new JLabel("<html>2 tokens per play</html>");
		
		figure_button_pressed = false;
		classical_button_pressed = false;
		
		//configuring sections of frame
		label1.setHorizontalTextPosition(SwingConstants.CENTER);
		label1.setFont(new Font("Courier", Font.BOLD,60));
		
		label2.setHorizontalTextPosition(SwingConstants.CENTER);
		label2.setFont(new Font("Courier", Font.PLAIN,40));
		
		label3.setHorizontalTextPosition(SwingConstants.LEFT);
		label3.setFont(new Font("Courier", Font.ITALIC,40));
		
		button1.setHorizontalTextPosition(SwingConstants.LEFT);
		button1.setFont(new Font("Courier", Font.PLAIN,40));
		
		label4.setHorizontalTextPosition(SwingConstants.LEFT);
		label4.setFont(new Font("Courier", Font.ITALIC,40));
		
		button2.setHorizontalTextPosition(SwingConstants.LEFT);
		button2.setFont(new Font("Courier", Font.PLAIN,40));
		
		label5.setHorizontalTextPosition(SwingConstants.LEFT);
		label5.setFont(new Font("Courier", Font.ITALIC,40));
		
		//adding sections to frame
		add(label1);
		add(label2);
		add(label3);
		add(button1);
		add(label4);
		add(button2);
		add(label5);
		
		addButtonAction();
		
	}
	
	static void addButtonAction()
	{
		//adding listener to button
		
		button1.addActionListener(new ActionListener()
	    {
			public void actionPerformed(ActionEvent e)
			{
				figure_button_pressed = true;
				classical_button_pressed = false;
			}
		});
		
		button2.addActionListener(new ActionListener()
	    {
			public void actionPerformed(ActionEvent e)
			{
				figure_button_pressed = false;
				classical_button_pressed = true;
			}
		});
	}
	
	public String getWantedGame()
	{
		if(figure_button_pressed==true)
		{
			return "FormFigure";
		}
		else if(classical_button_pressed==true)
		{
			return "Classical";
		}
		else
		{
			return "None";
		}
	}
}