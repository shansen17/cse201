
public class MancalaMain
{
	public static void main(String[] args)
	{
		MancalaMain.run(args);
		//application.run(args);
	}
	
	public static void run(String[] args)
	{
		/*
		Game g = new Game();
		System.out.println("NULL: " + g);
		
		for(int i = 1; i < 14; ++i)
		{
			g = new Game(Player.TWO);
			System.out.print(i + ": ");
			g.move(i);
			System.out.println(g);
		}
		*/
		
		Game g = new Game(Player.ONE);
		HumanInput hi = new HumanInput();
		int input = -1;
		while(true) {
			System.out.println("\n"+g);
			input = hi.getMove(g.getBoard());
			if(input == -1) break;
			g.move(input);
		}
	}
}
