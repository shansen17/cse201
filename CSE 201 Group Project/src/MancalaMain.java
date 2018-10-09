
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
			System.out.print(i + ": ");
			g.move(i);
			System.out.println(g.getBoard());
		}
	}
}
