import java.util.Scanner;

public class HumanInput implements PlayerInput
{
	private Scanner scan = new Scanner(System.in);
	
	public HumanInput()
	{
	}
	
	public int getMove(Board boardState)
	{	
		int nextMove = Integer.parseInt(scan.nextLine());
		
		return nextMove;
	}
}
