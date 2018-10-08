import java.util.ArrayList;
import java.util.List;

public class Game
{
	Board board = new Board();
	Participant whoseTurn = Participant.one;
	
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
		
		for(Tuple<Integer, Integer> t:moves)
		{
			board.move(t.first(), t.second());
		}
	}
	
	public boolean validMove(int index)
	{
		if(0 > index || index > 13)
		{
			return false;
		}
		if(board.participant(index) != whoseTurn)
		{
			return false;
		}
		if(board.stones(index) < 1)
		{
			return false;
		}
		
		return true;
	}
	
	//TODO LOGIC IS INCORRECT. FIX ASAP.
	public List<Tuple<Integer, Integer>> getStoneMoves(int index)
	{
		List<Tuple<Integer, Integer>> moves = new ArrayList<>();
		int stones = board.stones(index);
		
		for(int i = board.next(index); stones > 0; i = board.next(i))
		{
			Bin next = board.getBin(i);
			
			// skip opponent's mancala
			if(!next.isMancala() || next.participant == whoseTurn)
			{
				moves.add(new Tuple<>(index, i));
				stones--;
			}
		}
		
		return moves;
	}
	
	public Board getBoard()
	{
		return this.board;
	}
	
	public String toString()
	{
		
		return "";
	}
}