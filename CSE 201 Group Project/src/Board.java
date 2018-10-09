import java.util.ArrayList;
import java.util.List;

public class Board
{
	/*
	 * Bin 6 and bin 13 are mancalas. Bins 0 through 6 belong to player one.
	 * Bins 7 through 13 belong to player two.
	 */
	public final static int SIZE = 14;
	
	private List<Bin> bins;
	
	public Board()
	{
		initialize();
	}
	
	public void initialize()
	{
		bins = new ArrayList<>(SIZE);
		
		int midpoint = SIZE / 2;
		for(int i = 0; i < SIZE; i++)
		{
			Player p = (i < midpoint) ? Player.ONE : Player.TWO;
			boolean isMancala = (i % midpoint == midpoint - 1); // only indices
																// 6 and 13
			int stones = (isMancala) ? 0 : 4; // 0 for mancala, 4 for everything
												// else
			
			bins.add(i, new Bin(stones, isMancala, p));
		}
	}
	
	public int stones(int index)
	{
		checkBounds(index);
		
		return bins.get(index).getStones();
	}
	
	public boolean isMancala(int index)
	{
		checkBounds(index);
		
		return bins.get(index).isMancala();
	}
	
	public Player player(int index)
	{
		checkBounds(index);
		
		return bins.get(index).player;
	}
	
	public Bin getBin(int index)
	{
		checkBounds(index);
		
		return bins.get(index);
	}
	
	public void setBinCount(int index, int count)
	{
		checkBounds(index);
		
		if(0 > count || count > (SIZE - 2) * 4)
		{
			// TODO throw ex
		}
		
		bins.get(index).setStones(count);
	}
	
	/**
	 * Returns the index of the bin on the opposite side of the one specified.
	 * For the mancalas (indices 0 and 7), it returns the index of the other
	 * mancala.
	 * 
	 * @param index Index to find opposite of
	 * @return Index of opposite bin
	 */
	public static int getOppositeIndex(int index)
	{
		checkBounds(index);
		
		// The equation breaks for indices 0 and 7, so we make exceptions.
		if(index == 0)
		{
			return SIZE / 2;
		}else if(index == SIZE / 2)
		{
			return 0;
		}
		
		return SIZE - index; // TODO check logic
	}
	
	public static int next(int index)
	{
		return (index + 1) % SIZE;
	}
	
	public void move(int source, int destination)
	{
		checkBounds(source);
		checkBounds(destination);
		
		bins.get(source).decrement();
		bins.get(destination).increment();
	}
	
	public void move(Move move)
	{
		checkBounds(move.first());
		checkBounds(move.second());
		
		bins.get(move.first()).decrement();
		bins.get(move.second()).increment();
	}
	
	private static void checkBounds(int index) throws IndexOutOfBoundsException
	{
		if(0 > index || index >= SIZE)
		{
			throw new IndexOutOfBoundsException();
		}
	}
	
	public String toString()
	{
		String s = "";
		
		for(Bin b : bins)
		{
			s += /* "owner: " + */ b.player + ", ";
			s += /* "stones: " + */ b.getStones() + ",";
			s += /* "isMancala: " + */ b.isMancala() ? "+" : "-";
			s += "; ";
		}
		
		return s;
	}
}