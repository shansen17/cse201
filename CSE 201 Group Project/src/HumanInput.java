import java.util.Scanner;

public class HumanInput implements PlayerInput
{
	private Scanner scan;
	
	public int getMove(Board boardState)
	{
		int nextMove;
		scan = new Scanner(System.in);
		
		nextMove = scan.nextInt();
		
		scan.close();
		return nextMove;
	}
}
