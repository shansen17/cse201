import java.util.Scanner;

public class application
{
	static Scanner in = new Scanner(System.in);
	
	public static void run(String[] args)
	{
		int ballNum;
		int mv;
		System.out.println("How many balls you want? ");
		ballNum = in.nextInt();
		ShirleyBoard a = new ShirleyBoard(ballNum);
		boolean player = true;
		while(true)
		{
			if(player == true)
			{
				System.out.println("now please make a 1P move(1-6): ");
				mv = in.nextInt();
				while(mv < 1 || mv > 6)
				{
					System.out.println("invalid move, pleas move again");
					mv = in.nextInt();
				}
				a.makeMove(mv);
			}
			if(player == false)
			{
				System.out.println("now please make a 2P move(8-13): ");
				mv = in.nextInt();
				while(mv < 8 || mv > 13)
				{
					System.out.println("invalid move, pleas move again");
					mv = in.nextInt();
				}
				a.makeMove(mv);
			}
			player = !player;
			
		}
	}
}
