import java.util.ArrayList;
import java.util.List;

public class GameState
{
	Board board = new Board();
	Player whoseTurn = Player.ONE;
	
	public GameState()
	{
		board.initialize();
		whoseTurn = Math.random() > 0.5 ? Player.ONE : Player.TWO;
	}
	
	public GameState(Player p)
	{
		board.initialize();
		whoseTurn = p;
	}
	
	public void move(List<Move> moveSet)
	{
		for(Move m : moveSet)
		{
			board.move(m);
		}
	}
	
	public List<Move> getStoneMoves(int index)
	{
		List<Move> moves = new ArrayList<>();
		int stones = board.stones(index);
		
		for(int i = Board.next(index); stones > 0; i = Board.next(i))
		{
			// skip opponent's mancala
			if(!Board.isMancala(i) || Board.player(i) == whoseTurn)
			{
				moves.add(new Move(index, i));
				stones--;
			}
		}
		
		return moves;
	}
	
	public List<Move> getCaptureMoves(int lastMoveDest)
	{
		List<Move> capMoves = new ArrayList<>();
		int ownMancala = (whoseTurn == Player.ONE) ? 6 : 13;
		int opp = Board.getOppositeIndex(lastMoveDest);
		int oppStones = board.stones(opp);
		
		capMoves.add(new Move(lastMoveDest, ownMancala));
		while(oppStones > 0)
		{
			capMoves.add(new Move(opp, ownMancala));
			oppStones--;
		}
		
		return capMoves;
	}
	
	public boolean validMove(int index)
	{
		if(0 > index || index > 13)
		{
			return false;
		}
		if(Board.player(index) != whoseTurn)
		{
			return false;
		}
		if(board.stones(index) < 1)
		{
			return false;
		}
		if(index == 6 || index == 13)
		{
			return false;
		}
		
		return true;
	}
	
	public boolean gameWon()
	{
		boolean empty1 = true;
		boolean empty2 = true;
		
		for (int i = 0; i < 6; i++)
		{
			if (board.stones(i) != 0)
			{
				empty1 = false;
				break;
			}
		}
		
		for (int i = 7; i < 12; i++)
		{
			if (board.stones(i) != 0)
			{
				empty2 = false;
				break;
			}
		}
		
		return empty1 || empty2;
	}
	
	public boolean capturePossible(int lastMoveDest)
	{
		int opp = Board.getOppositeIndex(lastMoveDest);
		
		// do not capture from mancalas
		if(lastMoveDest % 7 == 6)
		{
			return false;
		}
		// do not capture when not empty bin
		if(board.stones(lastMoveDest) != 1)
		{
			return false;
		}
		// no capturing from own bin
		if(Board.player(opp) == whoseTurn)
		{
			return false;
		}
		
		// only capture with stones in opposite bin
		return board.stones(opp) != 0;
	}
	
	public Board getBoard()
	{
		return this.board;
	}
	
	public String toString()
	{
		return board.toString();
	}
}