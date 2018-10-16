import java.util.ArrayList;
import java.util.List;

/**
 * This is a mancala board represented as a list of {@code Bin} objects. It
 * provides wrappers and convenience methods with features specific to mancala.
 * 
 * @author CSE 201 Team B - Fall 2018
 * @version 0.9
 */
public class Board
{
	public final static int SIZE = 14;
	
	private List<Bin> bins;
	
	/**
	 * Calls {@code this.initialize()}.
	 */
	public Board()
	{
		initialize();
	}
	
	/**
	 * <p>
	 * Populates list with bins containing four stones, except mancalas, which
	 * remain empty. For an existing {@code Board}, this returns it to a fresh
	 * state.
	 * </p>
	 * 
	 * <p>
	 * The bins with the indices 0-6 are owned by {@code Player.ONE} and the
	 * indices 7-13 by {@code Player.TWO}. The bins at indices 6 and 13 are
	 * mancalas.
	 * </p>
	 */
	public void initialize()
	{
		bins = new ArrayList<>(SIZE);
		
		int midpoint = SIZE / 2;
		for(int i = 0; i < SIZE; i++)
		{
			Player p = (i < midpoint) ? Player.ONE : Player.TWO;
			
			// only true if 6 or 13
			boolean isMancala = (i % midpoint == midpoint - 1);
			
			// 0 for mancala, 4 for all else
			int stones = (isMancala) ? 0 : 4;
			
			bins.add(i, new Bin(stones, isMancala, p));
		}
	}
	
	/**
	 * Return the number of stones at a given bin, specified by index number.
	 * 
	 * @param index Index of bin to check
	 * @return number of stones at given index.
	 */
	public int stones(int index)
	{
		checkBounds(index);
		
		return bins.get(index).getStones();
	}
	
	/**
	 * Returns {@code true} if specified bin is a mancala and {@code false}
	 * otherwise.
	 * 
	 * @param index Index of bin to check
	 * @return whether bin is a mancala
	 */
	public boolean isMancala(int index)
	{
		checkBounds(index);
		
		return bins.get(index).isMancala();
	}
	
	/**
	 * Returns the player who owns the specified bin. This is either
	 * {@code Player.ONE} or {@code Player.TWO}.
	 * 
	 * @param index Index of bin to check
	 * @return owner of bin as member of {@code Player} enum.
	 */
	public Player player(int index)
	{
		checkBounds(index);
		
		return bins.get(index).player;
	}
	
	/**
	 * Returns a {@code Bin} from specified index.
	 * 
	 * @param index Index of bin to return
	 * @return {@code Bin} object at a given index
	 */
	public Bin getBin(int index)
	{
		checkBounds(index);
		
		return bins.get(index);
	}
	
	/**
	 * Sets the number of stones a specified bin holds.
	 * 
	 * @param index Index of bin to modify
	 * @param count Number of stones to set bin with
	 */
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
	 * For the mancalas (indices 6 and 13), it returns the index of the other
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
		} else if(index == SIZE / 2)
		{
			return 0;
		}
		
		return SIZE - index; // TODO check logic
	}
	
	/**
	 * <p>
	 * Returns the next bin's index from the one specified. The board is cyclic,
	 * so an index of 13 returns 0.
	 * </p>
	 * <p>
	 * This method return the number equivalent to {@code (index + 1) % 14}.
	 * </p>
	 * 
	 * @param index Index from which the next index is found.
	 * @return Index of next bin
	 */
	public static int next(int index)
	{
		checkBounds(index);
		
		return (index + 1) % SIZE;
	}
	
	/**
	 * Moves a stone from {@code source} to {@code destination}. The number of
	 * stones is decremented for the source and incremented for the destination.
	 * There are no checks for moving from zero or negative bins.
	 * 
	 * @param source      Bin to move a stone from.
	 * @param destination Bin to move a stone to.
	 */
	public void move(int source, int destination)
	{
		checkBounds(source);
		checkBounds(destination);
		
		bins.get(source).decrement();
		bins.get(destination).increment();
	}
	
	/**
	 * Makes a move between bins as described by a {@code Move} object. There
	 * are no checks for moving from zero or negative bins.
	 * 
	 * @param move
	 */
	public void move(Move move)
	{
		checkBounds(move.first());
		checkBounds(move.second());
		
		bins.get(move.first()).decrement();
		bins.get(move.second()).increment();
	}
	
	/**
	 * Used internally to throw an exception when an index lies outside of the
	 * range 0-13 inclusive.
	 * 
	 * @param index Index to check
	 * @throws IndexOutOfBoundsException on invalid index
	 */
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