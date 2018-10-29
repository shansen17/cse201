import java.util.List;

public class MancalaMain
{
	public static void main(String[] args)
	{
		MancalaMain.run(args);
		// application.run(args);
	}
	
	public static void run(String[] args)
	{
		boolean gameQuit = false;
		
		while(!gameQuit)
		{
			gameQuit = playGame();
		}
	}
	
	public static boolean playGame()
	{
		GameState game = new GameState();
		PlayerInput human = new HumanInput();
		PlayerInput machine = new MachineInput();
		
		while(!game.gameWon())
		{
			if(game.whoseTurn == Player.ONE)
				System.out.println(game);
			
			int nextMove;
			PlayerInput input;
			if(game.whoseTurn == Player.ONE)
			{
				input = human;
			} else
			{
				input = machine;
			}
			
			nextMove = input.getMove(game.getBoard());
			
			if(!game.validMove(nextMove))
			{
				continue;
			}
			
			List<Move> moveSet = game.move(nextMove);
		}
		
		System.out.println(game.whoseTurn + " won!");
		
		return true;
	}
}
