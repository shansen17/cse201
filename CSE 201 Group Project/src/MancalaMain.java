
public class MancalaMain
{
	public static void main(String[] args)
	{
		run();
	}
	
	public static void run()
	{
		for(int i = 0; i < 14; ++i)
		{
			Game g = new Game();
			System.out.print(i + ": ");
			g.move(i);
			System.out.println(g.getBoard());
		}
	}
}
