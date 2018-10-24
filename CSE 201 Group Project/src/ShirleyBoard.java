
public class ShirleyBoard
{
	private int ballAmount;
	private int[] board = new int[14];
	
	public ShirleyBoard(int num)
	{
		this.ballAmount = num;
		this.initialize();
		printBoard();
	}
	
	public int getBallAmount()
	{
		return ballAmount;
	}
	
	public void setBallAmount(int ballAmount)
	{
		this.ballAmount = ballAmount;
		
	}
	
	public void initialize()
	{
		for(int i = 0; i < 14; i++)
		{
			if(i != 0 && i != 7)
			{
				board[i] = this.ballAmount;
			}
		}
	}
	
	public void makeMove(int hole)
	{
		if(hole <= 0 || hole == 7 || hole > 13 || this.board[hole] == 0)
		{
			System.out.println("invalid move");
		}
		
		int hand = this.board[hole];
		this.board[hole] = 0;
		printBoard();
		System.out.println("Balls in hand: " + hand);
		
		if(hole > 0 && hole < 7)
		{
			while(hand != 0)
			{
				if(hole == 13)
				{
					hole = 0;
				}
				this.board[hole + 1] = this.board[hole + 1] + 1;
				hand = hand - 1;
				hole = hole + 1;
			}
		} else if(hole > 7 && hole < 14)
		{
			while(hand != 0)
			{
				if(hole == 13)
				{
					hole = -1;
				}
				if(hole == 6)
				{
					hole = hole + 1;
				} else
				{
					this.board[hole + 1] = this.board[hole + 1] + 1;
					hand = hand - 1;
					hole = hole + 1;
				}
			}
		}
		
		printBoard();
		System.out.println("Balls in hand: " + hand);
	}
	
	public void printBoard()
	{
		System.out.println("The board now is");
		System.out.println("    ");
		for(int i = 13; i > 7; i--)
		{
			System.out.print("    ");
			System.out.printf("%02d", this.board[i]);
		}
		System.out.println("    ");
		System.out.println(this.board[0]
				+ "                                     " + this.board[7]);
		for(int i = 1; i < 7; i++)
		{
			System.out.print("    ");
			System.out.printf("%02d", this.board[i]);
		}
		System.out.println("    ");
		
	}
	
}
