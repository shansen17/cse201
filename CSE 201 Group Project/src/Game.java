import java.util.ArrayList;
import java.util.List;

public class Game
{
	private Board board = new Board();
	private Player whoseTurn = Player.ONE;
	
	public Game()
	{
		newGame();
		whoseTurn = Math.random() > 0.5 ? Player.ONE : Player.TWO;
	}
	
	public Game(Player p)
	{
		newGame();
		whoseTurn = p;
	}
	
	public void newGame()
	{
		board.initialize();
	}
	
	//TODO move loop elsewhere
	public void move(int index)
	{
		List<Move> moves = getStoneMoves(index);
		
		for(Move m : moves)
		{
			board.move(m);
			System.out.println(m);
		}
		
		this.whoseTurn = this.whoseTurn.opposite();
	}
	
	// TODO Fix mancalas not getting stones added.
	// TODO Implement captures.
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
			
			stones--;
			moves.add(new Move(index, i));
		}
		
		return moves;
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
	
	@SuppressWarnings("unused")
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
	
	@SuppressWarnings("unused")
	private List<Move> getCaptureMoves(Move lastMove) // TODO FIX
	{
		List<Move> moves = new ArrayList<>();
		
		List<Move> captureMoves = getCaptureMoves(lastMove);
		for(Move m : captureMoves)
		{
			moves.add(m);
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