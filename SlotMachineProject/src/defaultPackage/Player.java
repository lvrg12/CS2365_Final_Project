package defaultPackage;

public class Player
{
	private String username;
	private int tokens;
	
	//new player
	public Player(String username)
	{
		this.username = username;
		this.tokens = 20;
	}
	
	//returning player
	public Player(String username, int tokens)
	{
		this.username = username;
		this.tokens = tokens;
	}
	
	public String getUsername()
	{
		return username;
	}
	
	public int getTokens()
	{
		return tokens;
	}
	
	public void addTokens(int x)
	{
		tokens = tokens + x;
	}
	
	public void subtractTokens(int x)
	{
		tokens = tokens - x;
		//should return error if tokens<0
	}
}
