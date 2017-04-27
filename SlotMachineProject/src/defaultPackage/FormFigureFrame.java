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
	private JLabel label3; //You won label
	static private JLabel top; //top image label
	static private JLabel mid; //middle image label
	static private JLabel but; //buttom image label
	static private JTextField field1; //tokens field
	static private JButton button1; //Pull lever/Try again button
	static private JButton button2; //Change machine button
	static private Icon tops[] = new Icon[3]; //top images icons
	static private Icon mids[] = new Icon[3]; //middle images icons
	static private Icon buts[] = new Icon[3]; //buttom images icons
	static private Icon icon1; //loading image icon
	
	//variables to retrieve
	static private FormFigure machine;
	static private int setting;
	
	public FormFigureFrame(int tokens)
	{   
		//Initializing sections of frame
		super("Form Figure Machine");
		machine = new FormFigure();
	    setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
		//setLayout(new FlowLayout());
		label1 = new JLabel("Available tokens: ");
		String instruction = "<html>Make a mushroom, flower, or star by lining up evey image."
				+ "<br>Press y 3 times to form a figure."
				+ "<br>Press n to go back.</html>";
		label2 = new JLabel(instruction);
		label3 = new JLabel("You won 10 tokens!!!");
		field1 = new JTextField(tokens+"",10);
		button1 = new JButton("Pull Lever");
		button2 = new JButton("Change Machine");
		icon1 = new ImageIcon(getClass().getResource("media/wait5.png"));
		tops[0] = new ImageIcon(getClass().getResource("media/mushroom1.png"));
		mids[0] = new ImageIcon(getClass().getResource("media/mushroom2.png"));
		buts[0] = new ImageIcon(getClass().getResource("media/mushroom3.png"));
		tops[1] = new ImageIcon(getClass().getResource("media/flower1.png"));
		mids[1] = new ImageIcon(getClass().getResource("media/flower2.png"));
		buts[1] = new ImageIcon(getClass().getResource("media/flower3.png"));
		tops[2] = new ImageIcon(getClass().getResource("media/star1.png"));
		mids[2] = new ImageIcon(getClass().getResource("media/star2.png"));
		buts[2] = new ImageIcon(getClass().getResource("media/star3.png"));
		
		top = new JLabel(icon1);
		mid = new JLabel(icon1);
		but = new JLabel(icon1);
		
		//configuring sections of frame
		label1.setHorizontalAlignment(SwingConstants.CENTER);
		label1.setFont(new Font("Courier", Font.BOLD,40));
		
		field1.setFont(new Font("Courier", Font.BOLD,40));
		field1.setEditable(false);
		
		label2.setHorizontalAlignment(SwingConstants.CENTER);
		label2.setFont(new Font("Courier", Font.ITALIC,40));
		
		label3.setHorizontalAlignment(SwingConstants.CENTER);
		label3.setFont(new Font("Courier", Font.BOLD,40));
		
		button1.setHorizontalAlignment(SwingConstants.RIGHT);
		button1.setFont(new Font("Courier", Font.PLAIN,40));
		
		button2.setHorizontalAlignment(SwingConstants.CENTER);
		button2.setFont(new Font("Courier", Font.PLAIN,40));
		
		top.setHorizontalAlignment(SwingConstants.CENTER);
		
		mid.setHorizontalAlignment(SwingConstants.CENTER);
		
		but.setHorizontalAlignment(SwingConstants.CENTER);
	
		
		//adding sections to frame
		add(label1);
		add(field1);
		add(label2);
		add(button1);
		add(top);
		add(mid);
		add(but);
		add(label3);
		add(button2);
		
		addButtonAction();
		
	}
	
	static void addButtonAction()
	{
		//adding listener to button
		
		button1.addActionListener(new ActionListener()
	    {
			public void actionPerformed(ActionEvent e)
			{
				if(setting==0)
				{
					top.setIcon(tops[machine.getRandom(3)]);
					setting++;
				}
				else if(setting==1)
				{
					mid.setIcon(mids[machine.getRandom(3)]);
					setting++;
				}
				else if(setting==2)
				{
					but.setIcon(buts[machine.getRandom(3)]);
					setting++;
					button1.setText("Try Again");
				}
				else
				{
					setting = 0;
					top.setIcon(icon1);
					mid.setIcon(icon1);
					but.setIcon(icon1);
					button1.setText("Pull Lever");
				}
			}
		});
		
		/*
		button2.addActionListener(new ActionListener()
	    {
			public void actionPerformed(ActionEvent e)
			{
				figure_button_pressed = false;
				classical_button_pressed = true;
				System.out.println("Game wanted: classical");
			}
		});
		*/
		
	}
	/*
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