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
		//PlayerInput human = new HumanInput();
		//PlayerInput machine = new MachineInput();
		
		while(!game.gameWon())
		{
			
		}
		
		return true;
	}
}
