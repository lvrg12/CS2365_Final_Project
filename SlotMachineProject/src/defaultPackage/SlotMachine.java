//Author: Lino Virgen
//Class: CS 2365
//Date: 05/10/17

package defaultPackage;
import java.util.Random;

abstract public class SlotMachine
{
	private int cost;
	private Random randomGenerator;
	
	public SlotMachine(int cost)
	{
		this.cost = cost;
		randomGenerator = new Random();
	}
	
	public int getCost()
	{
		return cost;
	}
	
	abstract public String getInstruction();
	abstract public int calculate();
	
	public int getRandom(int range)
	{
		return randomGenerator.nextInt(range);
	}
}