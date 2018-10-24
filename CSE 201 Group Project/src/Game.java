import java.util.ArrayList;
import java.util.List;

public class Game
{
	Board board = new Board();
	Participant whoseTurn = Participant.one;
	
	public Game()
	{
		board.initialize();
		whoseTurn = Math.random() > 0.5 ? Participant.one : Participant.two;
	}
	
	public Game(Participant p)
	{
		board.initialize();
		whoseTurn = p;
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
		if(Board.participant(index) != whoseTurn)
		{
			return false;
		}
		if(board.stones(index) < 1)
		{
			return false;
		}
		
		return true;
	}
	
	public List<Tuple<Integer, Integer>> getStoneMoves(int index)
	{
		List<Tuple<Integer, Integer>> moves = new ArrayList<>();
		int stones = board.stones(index);
		
		for(int i = Board.next(index); stones > 0; i = Board.next(i))
		{
			// skip opponent's mancala
			if(!Board.isMancala(i) || Board.participant(i) == whoseTurn)
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