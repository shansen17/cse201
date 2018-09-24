
public class Bin
{
	int stones;
	final boolean isMancala;
	final Participant participant;
	
	public Bin(int stones, boolean isMancala, Participant player)
	{
		this.stones = stones;
		this.isMancala = isMancala;
		this.participant = player;
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
		return participant;
	}
	
	public String toString()
	{
		return "(" + stones + ", " + isMancala + ", " + participant + ")";
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