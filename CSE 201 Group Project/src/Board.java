public class Board
{
	/*
	 * Bin 6 and bin 13 are mancalas. Bins 0 through 6 belong to player 1. Bins 7
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
		
		int midpoint = bins.length / 2;
		for(int i = 0; i < bins.length; i++)
		{
			Participant p = (i < midpoint) ? Participant.one : Participant.two;
			boolean isMancala = i % midpoint == midpoint - 1; // only indices 6 and 13
			int stones = (isMancala) ? 0 : 4; // 0 for mancala, 4 for everything else
			
			bins[i] = new Bin(stones, isMancala, p);
		}
	}
	
	public int stones(int index)
	{
		checkBounds(index);
		
		return bins[index].getStones();
	}
	
	public boolean isMancala(int index)
	{
		checkBounds(index);
		
		return bins[index].isMancala();
	}
	
	public Participant participant(int index)
	{
		checkBounds(index);
		
		return bins[index].participant;
	}
	
	public Bin getBin(int index)
	{
		checkBounds(index);
		
		return bins[index];
	}
	
	public void setBinCount(int index, int count)
	{
		checkBounds(index);
		
		if(0 > count || count > 48)
		{
			// TODO throw ex
		}
		
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
		checkBounds(index);
		
		// The equation breaks for indices 0 and 7, so we make exceptions.
		if(index == 0)
		{
			return 7;
		}else if(index == 7)
		{
			return 0;
		}
		
		return bins.length - index; // TODO check logic
	}
	
	public int next(int index)
	{
		return (index + 1) % bins.length;
	}
	
	public void move(int source, int destination)
	{
		checkBounds(source);
		checkBounds(destination);
		
		bins[source].decrement();
		bins[destination].increment();
	}
	
	private void checkBounds(int index) throws ArrayIndexOutOfBoundsException
	{
		if(0 > index || index >= bins.length)
		{
			throw new ArrayIndexOutOfBoundsException();
		}
	}
}