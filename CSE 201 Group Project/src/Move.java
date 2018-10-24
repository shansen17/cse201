public class Move extends Tuple<Integer, Integer>
{
	public Move(Integer t, Integer s)
	{
		super(t, s);
	}
	
	public String toString()
	{
		return t + ", " + s + "; ";
	}
}
