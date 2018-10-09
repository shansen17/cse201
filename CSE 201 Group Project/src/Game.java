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
		List<Move> moves = getStoneMoves(index);
		
		for(Move m : moves)
		{
			board.move(m);
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
	
	private boolean captured(Move lastMove) // TODO finish and check
	{
		int lastIndex = lastMove.second();
		if(board.stones(lastIndex) != 1 || board.isMancala(lastIndex)
				|| board.player(lastIndex) != this.whoseTurn)
		{
			return false;
		}
		
		return true;
	}
	
	private List<Move> getCaptureMoves(Move lastMove) // TODO FINISH
	{
		
		return null;
	}
	
	// TODO LOGIC IS INCORRECT. FIX ASAP.
	public List<Move> getStoneMoves(int index)
	{
		List<Move> moves = new ArrayList<>();
		int stones = board.stones(index);
		
		for(int i = Board.next(index); stones > 0; i = Board.next(i))
		{
			Bin next = board.getBin(i);
			
			// skip opponent's mancala
			if(next.isMancala() && next.player != whoseTurn)
			{
				i = Board.next(i);
			}
			
			moves.add(new Move(index, i));
			stones--;
		}
		
		Move lastMove = moves.get(moves.size() - 1);
		if(captured(lastMove))
		{
			List<Move> captureMoves = getCaptureMoves(lastMove);
			for(Move m : captureMoves)
			{
				moves.add(m);
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