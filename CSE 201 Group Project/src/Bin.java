
public class Bin
{
	int stones;
	final boolean isMancala;
	final Player player;
	
	public Bin(int stones, boolean isMancala, Player player)
	{
		this.stones = stones;
		this.isMancala = isMancala;
		this.player = player;
	}
	
	public int getStones()
	{
		return stones;
	}
	
	public void setStones(int stones)
	{
		this.stones = stones;
	}
	
	public boolean isMancala()
	{
		return isMancala;
	}
	
	public Player getPlayer()
	{
		return player;
	}
	
	public String toString()
	{
		return "(" + stones + ", " + isMancala + ", " + player + ")";
	}
	
	public void increment()
	{
		stones++;
	}
	
	public void decrement()
	{
		stones--;
	}
}