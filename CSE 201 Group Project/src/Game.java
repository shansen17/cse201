import java.util.ArrayList;
import java.util.List;

public class Game
{
	Board board = new Board();
	Player whoseTurn = Player.ONE;
	
	public Game()
	{
		board.initialize();
		whoseTurn = Math.random() > 0.5 ? Player.ONE : Player.TWO;
	}
	
	public Game(Player p)
	{
		board.initialize();
		whoseTurn = p;
	}
	
	public void move(int index)
	{
		List<Move> moves = getStoneMoves(index);
		
		for(Move m : moves)
		{
			board.move(m.first(), m.second());
		}
	}
	
	public boolean validMove(int index)
	{
		if(0 > index || index > 13)
		{
			return false;
		}
		if(Board.Player(index) != whoseTurn)
		{
			return false;
		}
		if(board.stones(index) < 1)
		{
			return false;
		}
		
		return true;
	}
	
	public List<Move> getStoneMoves(int index)
	{
		List<Move> moves = new ArrayList<>();
		int stones = board.stones(index);
		
		for(int i = Board.next(index); stones > 0; i = Board.next(i))
		{
			// skip opponent's mancala
			if(!Board.isMancala(i) || Board.Player(i) == whoseTurn)
			{
				moves.add(new Move(index, i));
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