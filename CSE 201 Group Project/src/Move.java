public class Move
{
	private final int first;
	private final int second;
	
	public Move(int first, int second)
	{
		this.first = first;
		this.second = second;
	}
	
	public int first()
	{
		return first;
	}
	
	public int second()
	{
		return second;
	}
	
	public String toString()
	{
		return first + ", " + second + "; ";
	}
}
