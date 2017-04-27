//Author: Lino Virgen
//Class: CS 2365
//Date: 05/10/17

package defaultPackage;
import java.util.Random;

abstract public class SlotMachine
{
	public int cost;
	public int prize;
	private Random randomGenerator;
	
	public SlotMachine(int cost, int prize)
	{
		this.cost = cost;
		this.prize = prize;
		randomGenerator = new Random();
	}
	
	public abstract int getCost();
	public abstract int getPrize();
	public abstract void pullLever(int setting);
	public abstract void displayInstruction();
	
	public int getRandom(int range)
	{
		return randomGenerator.nextInt(range);
	}
}