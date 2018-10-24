import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
	
	//TODO Fix off-by-one
	public List<Move> move(int index)
	{
		List<Move> moves = getStoneMoves(index);
		List<Move> capMoves = new ArrayList<>();
		
		for(Move m : moves)
		{
			board.move(m.first(), m.second());
		}
		
		if(!moves.isEmpty())
		{
			int lastMoveDest = moves.get(moves.size() - 1).second();
			
			if(capturePossible(lastMoveDest))
			{
				capMoves = getCaptureMoves(lastMoveDest);
			}
		}
		
		if(!capMoves.isEmpty())
		{
			for(Move m : capMoves)
			{
				board.move(m.first(), m.second());
			}
		}
		
		List<Move> allMoves = Stream.concat(moves.stream(), capMoves.stream())
				.collect(Collectors.toList());
		return allMoves;
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
		
		return true;
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
	
	public boolean capturePossible(int lastMoveDest)
	{
		int opp = Board.getOppositeIndex(lastMoveDest);
		if(board.stones(opp) == 0)
		{
			return true;
		}
		
		return false;
	}
	
	public List<Move> getCaptureMoves(int lastMoveDest)
	{
		// TODO finish method
		return new ArrayList<Move>();
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