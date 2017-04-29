//Author: Lino Virgen
//Class: CS 2365
//Date: 05/10/17

package defaultPackage;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class ClassicalFrame extends JFrame
{
	//frame sections
	private JLabel label1; //Available tokens label
	private JLabel label2; //Instructions label
	private JLabel line; //line label
	private JLabel line2; //line2 label
	static private JLabel label3; //You won label
	static private JLabel cell0; //cell0 image label
	static private JLabel cell1; //cell1 image label
	static private JLabel cell2; //cell2 image label
	static private JLabel cell3; //cell3 image label
	static private JLabel cell4; //cell4 image label
	static private JLabel cell5; //cell5 image label
	static private JLabel cell6; //cell6 image label
	static private JLabel cell7; //cell7 image label
	static private JLabel cell8; //cell8 image label
	static private JTextField field1; //tokens field
	static private JButton button1; //Pull lever/Try again button
	static private JButton button2; //Change machine button
	static private Icon icons[] = new Icon[5]; //top images icons
	static private Icon icon1; //loading image icon
	
	static private ClassicalMachine machine;
	static private int clicks;
	static private int prize;
	
	//variables to retrieve
	static private boolean changed_game;
	static private boolean new_game;
	static private int available_tokens;
	
	public ClassicalFrame(int tokens,String size)
	{   
		//Initializing sections of frame
		super("Form Figure Machine");
		machine = new ClassicalMachine();
		clicks = 0;
		prize = 0;
		changed_game = false;
		available_tokens = tokens+1;
		
	    //setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
		setLayout(new FlowLayout());
		label1 = new JLabel("Available tokens: ");
		label2 = new JLabel(machine.getInstruction());		
		label3 = new JLabel("You won "+prize+" tokens!!!");
		line = new JLabel("<html><br>-------------------------------</html>");
		line2 = new JLabel("<html>-------------------------------<br></html>");
		field1 = new JTextField(available_tokens-1+"",10);
		button1 = new JButton("Pull Lever");
		button2 = new JButton("Change Machine");
		icon1 = new ImageIcon(getClass().getResource("media/shortwait"+size+".png"));
		icons[0] = new ImageIcon(getClass().getResource("media/seven"+size+".png"));
		icons[1] = new ImageIcon(getClass().getResource("media/watermelon"+size+".png"));
		icons[2] = new ImageIcon(getClass().getResource("media/orange"+size+".png"));
		icons[3] = new ImageIcon(getClass().getResource("media/cherry"+size+".png"));
		icons[4] = new ImageIcon(getClass().getResource("media/grape"+size+".png"));
		
		cell0 = new JLabel(icon1);
		cell1 = new JLabel(icon1);
		cell2 = new JLabel(icon1);
		cell3 = new JLabel(icon1);
		cell4 = new JLabel(icon1);
		cell5 = new JLabel(icon1);
		cell6 = new JLabel(icon1);
		cell7 = new JLabel(icon1);
		cell8 = new JLabel(icon1);
		
		//configuring sections of frame
		int font_size = size.equals("small")? 15 : 40;
		
		label1.setHorizontalAlignment(SwingConstants.CENTER);
		label1.setFont(new Font("Courier", Font.BOLD,font_size));
		
		field1.setFont(new Font("Courier", Font.BOLD,font_size));
		field1.setEditable(false);
		
		label2.setHorizontalTextPosition(SwingConstants.CENTER);
		label2.setHorizontalAlignment(SwingConstants.CENTER);
		label2.setFont(new Font("Courier", Font.ITALIC,font_size));
		
		line.setHorizontalTextPosition(SwingConstants.CENTER);
		line.setHorizontalAlignment(SwingConstants.CENTER);
		line.setFont(new Font("Courier", Font.ITALIC,font_size));
		
		line2.setHorizontalTextPosition(SwingConstants.CENTER);
		line2.setHorizontalAlignment(SwingConstants.CENTER);
		line2.setFont(new Font("Courier", Font.ITALIC,font_size));
		
		label3.setHorizontalAlignment(SwingConstants.CENTER);
		label3.setFont(new Font("Courier", Font.BOLD,font_size));
		label3.setVisible(false);
		
		button1.setHorizontalAlignment(SwingConstants.CENTER);
		button1.setFont(new Font("Courier", Font.PLAIN,font_size));
		
		button2.setHorizontalAlignment(SwingConstants.CENTER);
		button2.setFont(new Font("Courier", Font.PLAIN,font_size));	
		
		//adding sections to frame
		add(label1);
		add(field1);
		add(label2);
		add(button1);
		add(line);
		add(cell0);
		add(cell1);
		add(cell2);
		add(cell3);
		add(cell4);
		add(cell5);
		add(cell6);
		add(cell7);
		add(cell8);
		add(line2);
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
				int key0 = machine.getRandom(5);
				int key1 = machine.getRandom(5);
				int key2 = machine.getRandom(5);
				
				if(clicks==0)
				{
					new_game = true;
					cell0.setIcon(icons[key0]);
					cell3.setIcon(icons[key1]);
					cell6.setIcon(icons[key2]);
					clicks++;
					machine.setKey0(key0);
					machine.setKey3(key1);
					machine.setKey6(key2);
				}
				else if(clicks==1)
				{
					cell1.setIcon(icons[key0]);
					cell4.setIcon(icons[key1]);
					cell7.setIcon(icons[key2]);
					clicks++;
					machine.setKey1(key0);
					machine.setKey4(key1);
					machine.setKey7(key2);
				}
				else if(clicks==2)
				{
					cell2.setIcon(icons[key0]);
					cell5.setIcon(icons[key1]);
					cell8.setIcon(icons[key2]);
					clicks++;
					machine.setKey2(key0);
					machine.setKey5(key1);
					machine.setKey8(key2);
					
					prize = machine.calculate();

					if(prize>0)
					{
						label3.setText("You won "+prize+" tokens!!!");
						label3.setVisible(true);
					}
					
					button1.setText("Try Again");
					new_game = false;
				}
				else
				{
					//start new machine
					clicks = 0;
					cell0.setIcon(icon1);
					cell1.setIcon(icon1);
					cell2.setIcon(icon1);
					cell3.setIcon(icon1);
					cell4.setIcon(icon1);
					cell5.setIcon(icon1);
					cell6.setIcon(icon1);
					cell7.setIcon(icon1);
					cell8.setIcon(icon1);
					button1.setText("Pull Lever");
					label3.setVisible(false);
					prize = 0;
				}
				field1.setText(""+available_tokens);
			}
		});
		
		button2.addActionListener(new ActionListener()
	    {
			public void actionPerformed(ActionEvent e)
			{
				changed_game = true;
			}
		});
	}

	public int getPrize()
	{
		return prize;
	}
	
	public int getCost()
	{
		return machine.getCost();
	}
	
	public boolean getChangedGame()
	{
		return changed_game;
	}
	
	public boolean getNewGame()
	{
		return new_game;
	}
	
	public void setAvailableTokens(int tokens)
	{
		available_tokens = tokens;
	}
	
	public void resetPrize()
	{
		prize = 0;
	}
}