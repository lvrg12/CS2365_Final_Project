//Author: Lino Virgen
//Class: CS 2365
//Date: 05/10/17

package defaultPackage;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class FormFigureFrame extends JFrame
{
	//frame sections
	private JLabel label1; //Available tokens label
	private JLabel label2; //Instructions label
	static private JLabel label3; //You won label
	static private JTextField field1; //tokens field
	static private JButton button1; //Try again button
	static private JButton button2; //Change machine button
	static private Icon icons[] = new Icon[9];
	private Icon iconTest; //icon test
	private JLabel labelTest;
	
	//variables to retrieve
	static private int available_tokens;
	
	public FormFigureFrame(int tokens)
	{   
		//Initializing sections of frame
		super("Form Figure Machine");
	    //setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
		setLayout(new FlowLayout());
		label1 = new JLabel("Available tokens: ");
		field1 = new JTextField(10);
		String instruction = "<html>Make a mushroom, flower, or star by lining up evey image."
				+ "<br>Press y 3 times to form a figure."
				+ "<br>Press n to go back.</html>";
		label2 = new JLabel(instruction);
		iconTest = new ImageIcon("C:\\Users\\user\\Pictures\\La Bandera.jpg");
		label3 = new JLabel("You won 10 tokens!!!");
		button1 = new JButton("Try Again");
		button2 = new JButton("Change Machine");
		labelTest = new JLabel(iconTest);
	
		
		//configuring sections of frame
		label1.setHorizontalTextPosition(SwingConstants.CENTER);
		label1.setFont(new Font("Courier", Font.BOLD,40));
		
		field1.setFont(new Font("Courier", Font.BOLD,40));
		
		label2.setHorizontalTextPosition(SwingConstants.CENTER);
		label2.setFont(new Font("Courier", Font.ITALIC,40));
		
		label3.setHorizontalTextPosition(SwingConstants.CENTER);
		label3.setFont(new Font("Courier", Font.BOLD,40));
		
		button1.setHorizontalTextPosition(SwingConstants.LEFT);
		button1.setFont(new Font("Courier", Font.PLAIN,40));
		
		button2.setHorizontalTextPosition(SwingConstants.RIGHT);
		button2.setFont(new Font("Courier", Font.PLAIN,40));
	
		
		//adding sections to frame
		add(label1);
		add(field1);
		add(label2);
		add(labelTest);
		//add(new JLabel(new ImageIcon("C:\\Users\\user\\Pictures\\La Bandera.jpg")));
		add(label3);
		add(button1);
		add(button2);
		
		//addButtonAction();
		
	}
	/*
	static void addButtonAction()
	{
		//adding listener to button
		
		button1.addActionListener(new ActionListener()
	    {
			public void actionPerformed(ActionEvent e)
			{
				figure_button_pressed = true;
				classical_button_pressed = false;
				System.out.println("Game wanted: figure");
			}
		});
		
		button2.addActionListener(new ActionListener()
	    {
			public void actionPerformed(ActionEvent e)
			{
				figure_button_pressed = false;
				classical_button_pressed = true;
				System.out.println("Game wanted: classical");
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
			return "none";
		}
	}
	*/
}