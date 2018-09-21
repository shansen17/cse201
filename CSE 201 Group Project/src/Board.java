public class Board
{
	/*
	 * Bin 0 and bin 7 are mancalas. Bins 0 through 6 belong to player 1. Bins 7
	 * through 13 belong to player 2.
	 */
	private Bin[] bins;
	
	public Board()
	{
		initialize();
	}
	
	public void initialize()
	{
		bins = new Bin[14];
		
		for(int i = 0;i < bins.length;i++)
		{
			Participant p = owner(i);
			boolean isMancala = i % 7 == 0; // only indices 0 and 7
			int stones = (isMancala) ? 0 : 4; // 0 for mancala, 4 for everything else
			
			bins[i] = new Bin(stones, isMancala, p);
		}
	}
	
	// Wrapper method for convenience.
	public int stones(int index)
	{
		return bins[index].getStones();
	}
	
	public Bin getBin(int index)
	{
		if(index >= bins.length)
		{
			// TODO throw ex
		}
		
		return bins[index];
	}
	
	public void setBinCount(int index, int count)
	{
		bins[index].setStones(count);
	}
	
	/**
	 * Returns the index of the bin on the opposite side of the one specified. For
	 * the mancalas (indices 0 and 7), it returns the index of the other mancala.
	 * 
	 * @param index Index to find opposite of
	 * @return Index of opposite bin
	 */
	@SuppressWarnings("unused") // TODO remove
	private int getOppositeIndex(int index)
	{
		// The equation breaks for indices 0 and 7, so we make exceptions.
		if(index == 0)
		{
			return 7;
		}
		if(index == 7)
		{
			return 0;
		}
		
		return 14 - index; // TODO
	}
	
	public Participant owner(int index)
	{
		return (index <= 6) ? Participant.one : Participant.two;
	}
	
	public int next(int index)
	{
		return (index + 1) % 14;
	}
	
	public void move(int source, int destination)
	{
		bins[source].decrement();
		bins[destination].increment();
	}
}