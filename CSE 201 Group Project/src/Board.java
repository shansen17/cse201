import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Board
{
	/*
	 * Bin 6 and bin 13 are mancalas. Bins 0 through 6 belong to player one.
	 * Bins 7 through 13 belong to player two.
	 */
	public final static int SIZE = 14;
	private final static int INITIAL_STONE_COUNT = 4;
	
	private int[] bins;
	
	public Board()
	{
		initialize();
	}
	
	public void initialize()
	{
		bins = new int[SIZE];
		
		for(int i = 0; i < SIZE; i++)
		{
			bins[i] = isMancala(i) ? 0 : INITIAL_STONE_COUNT;
		}
	}
	
	public void move(Move move)
	{
		bins[move.first()]--;
		bins[move.second()]++;
	}

	public int stones(int index)
	{
		return bins[index];
	}
	
	public void setStones(int index, int count)
	{
		bins[index] = count;
	}
	
	public static int getOppositeIndex(int index)
	{
		// The equation breaks for indices 6 and 13, so we make exceptions.
		if(index == SIZE / 2 - 1)
		{
			return SIZE - 1;
		}
		else if(index == SIZE - 1)
		{
			return SIZE / 2 - 1;
		}
		
		return SIZE - index - 2;
	}

	public static boolean isMancala(int index)
	{
		return index % (SIZE / 2) == SIZE / 2 - 1; // only indices 6, 13
	}

	public static int next(int index)
	{
		return (index + 1) % SIZE;
	}

	public static Player player(int index)
	{
		return (index < SIZE / 2) ? Player.ONE : Player.TWO;
	}

	public String toString()
	{
		String s = "";
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(os);
		
		/*
		 * for(Bin b : bins) { s += b.Player + ","; s += b.getStones() +
		 * ","; s += b.isMancala() ? "O" : "_"; s += "; "; } s += "\n";
		 */
		
		ps.println("The board now is");
		ps.println("    ");
		for(int i = 13; i > 7; i--)
		{
			ps.print("    ");
			ps.printf("%02d", bins[(i - 1) % 14]);
		}
		ps.println("    ");
		ps.println(bins[13]
				+ "                                     "
				+ bins[6]);
		for(int i = 1; i < 7; i++)
		{
			ps.print("    ");
			ps.printf("%02d", bins[(i - 1) % 14]);
		}
		ps.println("    ");
		
		s += os.toString() + "\n";
		
		return s;
	}
	
}