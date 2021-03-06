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
	private JLabel line; //line label
	private JLabel line2; //line2 label
	static private JLabel label3; //You won label
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
	
	static private FormFigureMachine machine;
	static private int clicks;
	static private int prize;
	
	//variables to retrieve
	static private boolean changed_game;
	static private boolean new_game;
	static private int available_tokens;
	
	public FormFigureFrame(int tokens, String size)
	{   
		//Initializing sections of frame
		super("Form Figure Machine");
		machine = new FormFigureMachine();
		clicks = 0;
		prize = 0;
		changed_game = false;
		available_tokens = tokens+1;
		
		setLayout(new FlowLayout());
		label1 = new JLabel("Available tokens: ");
		label2 = new JLabel(machine.getInstruction());		
		label3 = new JLabel("You won 10 tokens!!!");
		line = new JLabel("<html><br>-------------------------------</html>");
		line2 = new JLabel("<html>-------------------------------<br></html>");
		field1 = new JTextField(available_tokens-1+"",10);
		button1 = new JButton("Pull Lever");
		button2 = new JButton("Change Machine");
		icon1 = new ImageIcon(getClass().getResource("media/longwait"+size+".png"));
		tops[0] = new ImageIcon(getClass().getResource("media/mushroom1"+size+".png"));
		mids[0] = new ImageIcon(getClass().getResource("media/mushroom2"+size+".png"));
		buts[0] = new ImageIcon(getClass().getResource("media/mushroom3"+size+".png"));
		tops[1] = new ImageIcon(getClass().getResource("media/flower1"+size+".png"));
		mids[1] = new ImageIcon(getClass().getResource("media/flower2"+size+".png"));
		buts[1] = new ImageIcon(getClass().getResource("media/flower3"+size+".png"));
		tops[2] = new ImageIcon(getClass().getResource("media/star1"+size+".png"));
		mids[2] = new ImageIcon(getClass().getResource("media/star2"+size+".png"));
		buts[2] = new ImageIcon(getClass().getResource("media/star3"+size+".png"));
		
		top = new JLabel(icon1);
		mid = new JLabel(icon1);
		but = new JLabel(icon1);
		
		//configuring sections of frame
		int font_size = size.equals("small")? 15 : 40;
		
		label1.setHorizontalAlignment(SwingConstants.CENTER);
		label1.setFont(new Font("Courier", Font.BOLD,font_size));
		
		field1.setFont(new Font("Courier", Font.BOLD,font_size));
		field1.setEditable(false);
		
		label2.setHorizontalTextPosition(SwingConstants.CENTER);
		label2.setHorizontalAlignment(SwingConstants.CENTER);
		label2.setFont(new Font("Courier", Font.ITALIC,font_size));
		
		label3.setHorizontalAlignment(SwingConstants.CENTER);
		label3.setFont(new Font("Courier", Font.BOLD,font_size));
		label3.setVisible(false);
		
		line.setHorizontalTextPosition(SwingConstants.CENTER);
		line.setHorizontalAlignment(SwingConstants.CENTER);
		line.setFont(new Font("Courier", Font.ITALIC,font_size));
		
		line2.setHorizontalTextPosition(SwingConstants.CENTER);
		line2.setHorizontalAlignment(SwingConstants.CENTER);
		line2.setFont(new Font("Courier", Font.ITALIC,font_size));
		
		button1.setHorizontalAlignment(SwingConstants.CENTER);
		button1.setFont(new Font("Courier", Font.PLAIN,font_size));
		
		button2.setHorizontalAlignment(SwingConstants.CENTER);
		button2.setFont(new Font("Courier", Font.PLAIN,font_size));
		
		top.setHorizontalAlignment(SwingConstants.CENTER);
		
		mid.setHorizontalAlignment(SwingConstants.CENTER);
		
		but.setHorizontalAlignment(SwingConstants.CENTER);
	
		
		//adding sections to frame
		add(label1);
		add(field1);
		add(label2);
		add(button1);
		add(line);
		add(top);
		add(mid);
		add(but);
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
				int key = machine.getRandom(3);
				if(clicks==0)
				{
					new_game = true;
					top.setIcon(tops[key]);
					clicks++;
					machine.setKey0(key);
				}
				else if(clicks==1)
				{
					mid.setIcon(mids[key]);
					clicks++;
					machine.setKey1(key);
				}
				else if(clicks==2)
				{
					but.setIcon(buts[key]);
					clicks++;
					machine.setKey2(key);
					
					prize = machine.calculate();

					if(prize>0)
					{
						label3.setVisible(true);
					}
					
					button1.setText("Try Again");
					new_game = false;
				}
				else
				{
					//start new machine
					clicks = 0;
					top.setIcon(icon1);
					mid.setIcon(icon1);
					but.setIcon(icon1);
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