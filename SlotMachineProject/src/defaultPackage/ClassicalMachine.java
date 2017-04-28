//Author: Lino Virgen
//Class: CS 2365
//Date: 05/10/17

package defaultPackage;

public class ClassicalMachine extends SlotMachine
{
	private int[][] key;

	public ClassicalMachine()
	{
		super(2);
		key = new int[3][3];
	}
	
	public String getInstruction()
	{
		return "<html><br>Make vertical, horizontal,<br>or diagonal lines of the"
				+ "<br>same symbol.<br><br>Horizontal line: 5 tokens"
				+ "<br>Vertical line: 5 tokens"
				+ "<br>Diagonal line: tokens*2<br><br></html>";
	}

	public void setKey0(int i)
	{
		key[0][0] = i;
	}
	
	public void setKey1(int i)
	{
		key[0][1] = i;
	}
	
	public void setKey2(int i)
	{
		key[0][2] = i;
	}
	
	public void setKey3(int i)
	{
		key[1][0] = i;
	}
	
	public void setKey4(int i)
	{
		key[1][1] = i;
	}
	
	public void setKey5(int i)
	{
		key[1][2] = i;
	}

	public void setKey6(int i)
	{
		key[2][0] = i;
	}
	
	public void setKey7(int i)
	{
		key[2][1] = i;
	}
	
	public void setKey8(int i)
	{
		key[2][2] = i;
	}

	public int calculate()
	{
		int prize = 0;
		
		//checking horizontal lines
		if(key[0][0] == key[0][1] && key[0][0] == key[0][2])
			prize+=5;
		if(key[1][0] == key[1][1] && key[1][0] == key[1][2])
			prize+=5;
		if(key[2][0] == key[2][1] && key[2][0] == key[2][2])
			prize+=5;
		
		//checking vertical lines
		if(key[0][0] == key[1][0] && key[0][0] == key[2][0])
			prize+=5;
		if(key[0][1] == key[1][1] && key[0][1] == key[2][1])
			prize+=5;
		if(key[0][2] == key[1][2] && key[0][2] == key[2][2])
			prize+=5;
		
		//checking diagonal lines
		if(key[0][0] == key[1][1] && key[0][0] == key[2][2])
			prize*=2;
		if(key[0][2] == key[1][1] && key[0][2] == key[2][0])
			prize*=2;
		
		return prize;
	}
}