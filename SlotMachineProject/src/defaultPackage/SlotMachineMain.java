//Author: Lino Virgen
//Class: CS 2365
//Date: 05/10/17

package defaultPackage;
import javax.swing.*;
import java.awt.*;

public class SlotMachineMain
{
	public static void main(String[] args)
	{
		String waiter = "";
		String size = "small";
		
		int bigFrameWidth, bigFrameHeight, smallFrameWidth, smallFrameHeight;
		if(size.equals("small"))
		{
			smallFrameWidth = 275;
			smallFrameHeight = 300;
			bigFrameWidth = 275;
			bigFrameHeight = 730;
		}
		else
		{
			smallFrameWidth = 855;
			smallFrameHeight = 600;
			bigFrameWidth = 750;
			bigFrameHeight = 1600;
		}
		
		LoginFrame login = new LoginFrame(size);
		login.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		login.setSize(smallFrameWidth,smallFrameHeight);
		login.setLocationRelativeTo(null);
		login.setVisible(true);
		
		String username = login.getUsername();
		
		//waiting for appropriate username input
		while(username.equals(""))
		{
			username = login.getUsername() + "";
		}
		
		Player player = new Player(username,20);
		
		login.setVisible(false);
		HomeFrame home = new HomeFrame(player.getUsername(),player.getTokens(),size);
		home.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		home.setSize(smallFrameWidth,smallFrameHeight);
		home.setLocationRelativeTo(null);
		home.setVisible(true);
		
		String wanted_game = home.getWantedGame();
		
		//waiting for user to choose a game
		while(true)
		{
			wanted_game = home.getWantedGame() + "";
			
			//FormFigure machine chosen
			if(wanted_game.equals("FormFigure"))
			{
				home.setVisible(false);
				
				FormFigureFrame form_figure = new FormFigureFrame(player.getTokens(),size);
				form_figure.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				form_figure.setSize(bigFrameWidth,bigFrameHeight);
				form_figure.setLocationRelativeTo(null);
				form_figure.setVisible(true);
				
				boolean changed_game = form_figure.getChangedGame();
				
				//waiting to change game
				while(!changed_game)
				{
					boolean new_game = form_figure.getNewGame();
					
					//wait for new game to start or change game
					while(!new_game && !changed_game)
					{
						waiter+=""; //keep looping
						new_game = form_figure.getNewGame();
						changed_game = form_figure.getChangedGame();
					}
					
					if(new_game)
					{
						player.subtractTokens(form_figure.getCost());
						form_figure.setAvailableTokens(player.getTokens());
						
						//waiting for game to finish
						while(new_game)
						{
							waiter+=""; //keep looping
							new_game = form_figure.getNewGame();
						}
						player.addTokens(form_figure.getPrize());
						form_figure.resetPrize();
					}
					
					waiter+=""; //keep looping
					changed_game = form_figure.getChangedGame();
				}
				
				form_figure.setVisible(false);
				form_figure.dispose();
				home.resetWantedGame();
				home.setAvailableTokens(player.getTokens());
				home.setVisible(true);
			}
			
			//Classical machine chosen
			if(wanted_game.equals("Classical"))
			{
				home.setVisible(false);
				
				ClassicalFrame classical = new ClassicalFrame(player.getTokens(),size);
				classical.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				classical.setSize(bigFrameWidth,bigFrameHeight);
				classical.setLocationRelativeTo(null);
				classical.setVisible(true);
				
				
				boolean changed_game = classical.getChangedGame();
				
				//waiting to change game
				while(!changed_game)
				{
					boolean new_game = classical.getNewGame();
					
					//wait for new game to start or change game
					while(!new_game && !changed_game)
					{
						waiter+=""; //keep looping
						new_game = classical.getNewGame();
						changed_game = classical.getChangedGame();
					}
					
					if(new_game)
					{
						player.subtractTokens(classical.getCost());
						classical.setAvailableTokens(player.getTokens());
						
						//waiting for game to finish
						while(new_game)
						{
							waiter+=""; //keep looping
							new_game = classical.getNewGame();
						}
						player.addTokens(classical.getPrize());
						classical.resetPrize();
					}
					
					waiter+=""; //keep looping
					changed_game = classical.getChangedGame();
				}
				
				classical.setVisible(false);
				classical.dispose();
				home.resetWantedGame();
				home.setAvailableTokens(player.getTokens());
				home.setVisible(true);
			}
		}
	}
}
