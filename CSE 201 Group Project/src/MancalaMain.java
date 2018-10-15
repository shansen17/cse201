
public class MancalaMain
{
	public static void main(String[] args)
	{
		run();
	}
	
	public static void run()
	{
		for(int i = 0; i < Board.SIZE; ++i)
		{
			Game g = new Game();
			g.move(i);
			System.out.print(i + ": ");
			System.out.print(g.getBoard());
			System.out.println("\n");
		}
	}
}
