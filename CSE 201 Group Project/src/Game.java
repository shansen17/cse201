import java.util.ArrayList;
import java.util.List;

public class Game
{
	Board board = new Board();
	Player whoseTurn = Player.ONE;
	
	public Game()
	{
		newGame();
	}
	
	public Game(Player p)
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
		
		for(Tuple<Integer, Integer> t : moves)
		{
			board.move(t.first(), t.second());
		}
		
		this.whoseTurn = this.whoseTurn.opposite();
	}
	
	public boolean validMove(int index)
	{
		if(0 > index || index > 13)
		{
			return false;
		}
		if(board.player(index) != whoseTurn)
		{
			return false;
		}
		if(board.stones(index) < 1)
		{
			return false;
		}
		
		return true;
	}
	
	// TODO LOGIC IS INCORRECT. FIX ASAP.
	public List<Tuple<Integer, Integer>> getStoneMoves(int index)
	{
		List<Tuple<Integer, Integer>> moves = new ArrayList<>();
		int stones = board.stones(index);
		
		for(int i = Board.next(index); stones > 0; i = Board.next(i))
		{
			Bin next = board.getBin(i);
			
			// skip opponent's mancala
			if(next.isMancala() && next.player != whoseTurn)
			{
				i = Board.next(i);
			}
			
			moves.add(new Tuple<>(index, i));
			stones--;
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