//Author: Lino Virgen
//Class: CS 2365
//Date: 05/10/17

package defaultPackage;

public class FormFigure extends SlotMachine
{
	private int[] key;

	public FormFigure()
	{
		super(1);
		key = new int[3];
	}
	
	public String getInstruction()
	{
		return "<html><br>Make a mushroom, flower,<br>or star by lining up evey<br>image.<br><br></html>";
	}

	public void setKey0(int i)
	{
		key[0] = i;
	}
	
	public void setKey1(int i)
	{
		key[1] = i;
	}
	
	public void setKey2(int i)
	{
		key[2] = i;
	}

	public int calculate()
	{
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
