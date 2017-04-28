//Author: Lino Virgen
//Class: CS 2365
//Date: 05/10/17

package defaultPackage;
import java.util.Scanner;
import javax.swing.*;
import java.awt.*;

public class SlotMachineMain
{
	public static void main(String[] args)
	{
		String waiter = "";
		LoginFrame login = new LoginFrame();
		login.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		login.setSize(855,600);
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
		HomeFrame home = new HomeFrame(player.getUsername(),player.getTokens());
		home.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		home.setSize(855,600);
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
				
				FormFigureFrame form_figure = new FormFigureFrame(player.getTokens());
				form_figure.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				form_figure.setSize(750,1400);
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
				
				ClassicalFrame classical = new ClassicalFrame(player.getTokens());
				classical.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				classical.setSize(750,1600);
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
