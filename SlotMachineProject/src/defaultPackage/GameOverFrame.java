//Author: Lino Virgen
//Class: CS 2365
//Date: 05/10/17

package defaultPackage;
import java.awt.*;
import javax.swing.*;

public class GameOverFrame extends JFrame
{
	//frame sections
	private JLabel label1; //game over label
	
	public GameOverFrame(String size)
	{   		
		//Initializing sections of frame
		super("Game Over");
		setLayout(new FlowLayout());
		label1 = new JLabel("GAME OVER");
		
		//configuring sections of frame
		int font_size = size.equals("small")? 50 : 300;
		
		label1.setHorizontalTextPosition(SwingConstants.CENTER);
		label1.setFont(new Font("Courier", Font.BOLD,font_size));
		
		//adding sections to frame
		add(label1);
	}
}