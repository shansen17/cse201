
public class MancalaMain
{
	public static void main(String[] args)
	{
		MancalaMain.run(args);
		application.run(args);
	}
	
	public static void run(String[] args)
	{
		Game g = new Game();
		System.out.println("NULL: " + g.getBoard());
		
		for(int i = 1; i < 14; ++i)
		{
			g = new Game(Participant.two);
			System.out.print(i + ": ");
			g.move(i);
			System.out.println(g.getBoard());
		}
	}
}
