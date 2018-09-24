
public class Bin
{
	int stones;
	final boolean isMancala;
	final Participant player;
	
	public Bin(int stones, boolean isMancala, Participant player)
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

	public Participant getPlayer()
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