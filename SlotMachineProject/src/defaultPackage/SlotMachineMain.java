//Author: Lino Virgen
//Class: CS 2365
//Date: 05/10/17

package defaultPackage;
import javax.swing.*;

public class SlotMachineMain
{
	public static void main(String[] args)
	{
		String waiter = ""; //needed for while loops
		String size = "small"; //depends on the resolution of the local machine
		
		//sets frame widths and heights depending on the resolution of the machine
		int bigFrameWidth, bigFrameHeight, smallFrameWidth, smallFrameHeight;
		int goFrameWidth, goFrameHeight;
		if(size.equals("small"))
		{
			smallFrameWidth = 275;
			smallFrameHeight = 300;
			bigFrameWidth = 275;
			bigFrameHeight = 730;
			goFrameWidth = 350;
			goFrameHeight = 175;
		}
		else
		{
			smallFrameWidth = 855;
			smallFrameHeight = 600;
			bigFrameWidth = 750;
			bigFrameHeight = 1600;
			goFrameWidth = 2000;
			goFrameHeight = 550;
		}
		
		//opening log in frame
		LoginFrame login = new LoginFrame(size);
		login.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		login.setSize(smallFrameWidth,smallFrameHeight);
		login.setLocationRelativeTo(null);
		login.setVisible(true);
		
		//waiting for appropriate username input
		String username = login.getUsername();
		while(username.equals(""))
		{
			username = login.getUsername() + "";
		}
		
		//creating new Player instance
		Player player = new Player(username,20);
		
		//opening home frame
		login.setVisible(false);
		HomeFrame home = new HomeFrame(player.getUsername(),player.getTokens(),size);
		home.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		home.setSize(smallFrameWidth,smallFrameHeight);
		home.setLocationRelativeTo(null);
		home.setVisible(true);
		
		//waiting for user to choose a game
		String wanted_game = home.getWantedGame();
		while(true)
		{
			wanted_game = home.getWantedGame() + "";
			
			//FormFigure machine chosen
			if(wanted_game.equals("FormFigure"))
			{
				//opening form figure frame
				home.setVisible(false);
				FormFigureFrame form_figure = new FormFigureFrame(player.getTokens(),size);
				form_figure.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				form_figure.setSize(bigFrameWidth,bigFrameHeight);
				form_figure.setLocationRelativeTo(null);
				form_figure.setVisible(true);
				
				//waiting to change game
				boolean changed_game = form_figure.getChangedGame();
				while(!changed_game)
				{					
					//waiting for new game to start or change game
					boolean new_game = form_figure.getNewGame();
					while(!new_game && !changed_game)
					{
						waiter+=""; //keep looping
						new_game = form_figure.getNewGame();
						changed_game = form_figure.getChangedGame();
					}
					
					//checking if player has enough tokens
					if(player.getTokens()<form_figure.getCost())
					{
						break;
					}
					
					//starting new game
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
				
				//closing form figure frame and opening home frame
				form_figure.setVisible(false);
				form_figure.dispose();
				home.resetWantedGame();
				home.setAvailableTokens(player.getTokens());
				home.setVisible(true);
			}
			
			//Classical machine chosen
			if(wanted_game.equals("Classical"))
			{
				//opening classical frame
				home.setVisible(false);
				ClassicalFrame classical = new ClassicalFrame(player.getTokens(),size);
				classical.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				classical.setSize(bigFrameWidth,bigFrameHeight);
				classical.setLocationRelativeTo(null);
				classical.setVisible(true);
				
				//waiting to change game
				boolean changed_game = classical.getChangedGame();
				while(!changed_game)
				{
					boolean new_game = classical.getNewGame();
					
					//waiting for new game to start or change game
					while(!new_game && !changed_game)
					{
						waiter+=""; //keep looping
						new_game = classical.getNewGame();
						changed_game = classical.getChangedGame();
					}
					
					//checking if player has enough tokens
					if(player.getTokens()<classical.getCost())
					{
						break;
					}
					
					//starting new game
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
				
				//closing clasical frame and opening home frame
				classical.setVisible(false);
				classical.dispose();
				home.resetWantedGame();
				home.setAvailableTokens(player.getTokens());
				home.setVisible(true);
			}
			
			//checking if player has 0 tokens
			if(player.getTokens() == 0)
			{
				//opening game over frame
				GameOverFrame game_over = new GameOverFrame(size);
				game_over.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				game_over.setSize(goFrameWidth,goFrameHeight);
				game_over.setLocationRelativeTo(null);
				game_over.setVisible(true);
				break;
			}
		}
	}
}
