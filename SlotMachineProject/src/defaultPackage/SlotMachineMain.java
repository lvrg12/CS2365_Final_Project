//Author: Lino Virgen
//Class: CS 2365
//Date: 05/10/17

package defaultPackage;
import java.util.Scanner;

public class SlotMachineMain
{

	public static void main(String[] args)
	{
		Scanner kb = new Scanner(System.in);
		System.out.print("Enter username: ");
		String username = kb.next();

		System.out.println("Welcome " + username + "!\n");
		System.out.println("Select a Slot Machine to play:");
		System.out.println("a) Form Figure");
		System.out.println("b) Classical");
		String type = kb.next();

		if(type.equals("a"))
		{
			FormFigure figure = new FormFigure();
			String tmp = "y";

			while(tmp.equals("y"))
			{
				figure.displayInstruction();
				tmp=kb.next();
				figure.pullLever(0);
				tmp=kb.next();
				figure.pullLever(1);
				tmp=kb.next();
				figure.pullLever(2);
				figure.setPrize();
				System.out.println("You won "+figure.getPrize()+" tokens.");
				System.out.print("Do you want to continue? (y/n): ");
				tmp=kb.next();
			}

			System.out.println("You exited the program");

		}
		else if(type.equals("b"))
		{
			System.out.println("You chose to play Classical Slot Machine");
			//Classical classical = new Classical();
			//classical.play();
		}

		kb.close();
		//This comment was done in Atom

	}

}
