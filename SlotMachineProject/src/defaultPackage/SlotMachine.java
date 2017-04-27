//Author: Lino Virgen
//Class: CS 2365
//Date: 05/10/17

package defaultPackage;
import java.util.Random;

public class SlotMachine
{
	private int cost;
	private int prize;
	private Random randomGenerator;
	
	public SlotMachine(int cost, int prize)
	{
		this.cost = cost;
		this.prize = prize;
		randomGenerator = new Random();
	}
	
	public int getCost()
	{
		return cost;
	}
	
	public int getPrize()
	{
		return prize;
	}
	
	public int pullLever(int setting)
	{
		prize = 0;
		int x = getRandom(3);
		if(setting==0)
		{
			System.out.println(top[x]);
			key[0] = x;
			return x;
		}
		else if(setting==1)
		{
			System.out.println(mid[x]);
			key[1] = x;
			return x;
		}
		else if(setting==2)
		{
			System.out.println(bot[x]);
			key[2] = x;
			return x;
		}
		else
		{
			System.out.println("Invalid lever setting.");
			return -1;
		}
	}
	
	public String getInstruction()
	{
		
	}
	
	public int getRandom(int range)
	{
		return randomGenerator.nextInt(range);
	}
}