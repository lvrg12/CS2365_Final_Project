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
		return "<html><br>Make a mushroom, flower,<br>or star by lining up evey<br>image.<br><br></html>";
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
		
		if(key[0] == key[1] && key[0] == key[2])
		{
			return 10;
		}
		else
		{
			return 0;
		}
	}
}