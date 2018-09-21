import java.util.ArrayList;
import java.util.List;

public class Game
{
	Board board = new Board();
	Participant whoseTurn;
	
	public Game()
	{
		newGame();
	}
	
	public Game(Participant p)
	{
		this();
		whoseTurn = p;
	}
	
	public void newGame()
	{
		board.initialize();
	}
	
	public void move(int index)
	{
		List<Tuple<Integer, Integer>> moves = getStoneMoves(index);
		
		for(Tuple<Integer, Integer> t : moves) {
			board.move(t.first(), t.second());
		}
	}
	
	public boolean validMove(int index)
	{
		if(0 > index || index > 13)
		{
			return false;
		}
		if(board.owner(index) != whoseTurn)
		{
			return false;
		}
		if(board.stones(index) < 1)
		{
			return false;
		}
		
		return true;
	}
	
	public List<Tuple<Integer, Integer>> getStoneMoves(int index) // TODO check logic
	{
		List<Tuple<Integer, Integer>> moves = new ArrayList<>();
		int stones = board.stones(index);
		
		for(int i = board.next(index);stones > 0;i = board.next(i))
		{
			Bin next = board.getBin(i);
			
			// skip opponent's mancala
			if(next.isMancala() && next.participant != whoseTurn)
			{
				continue;
			}
			
			moves.add(new Tuple<>(index, i));
			stones -= 1;
		}
		
		return moves;
	}
}