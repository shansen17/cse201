public class MachineInput implements PlayerInput
{
	// Moves possible for AI only for bins 7 - 12.
	// It owns 7 - 13, but 13 is a mancala.
	
	private final int[] ALL_MOVES_POSSIBLE =
	{ 7, 8, 9, 10, 11, 12 };
	
	public MachineInput()
	{
	}
	
	public int getMove(Board boardState)
	{
		// find max weight and get corresponding move
		int maxIndex = 0;
		double max = 0.0;
		for(int i = 0; i < ALL_MOVES_POSSIBLE.length; ++i)
		{
			double weight = getWeight(ALL_MOVES_POSSIBLE[i], boardState);
			if(weight > max) {
				maxIndex = i;
				max = weight;
			}
		}
		
		return ALL_MOVES_POSSIBLE[maxIndex];
	}
	
	// TODO Finish method
	private double getWeight(int move, Board boardState)
	{	
		int stones = boardState.stones(move);
		//if landing in mancala is possible (first priority)
		if (bonusPossible(move, stones)) {
			return 2.0;
		}
		//if capturing pieces is possible (second priority)
		else if (capturePossible(move, boardState)) {
			return 1.0;
		}
		//last resort: choose randomly
		else {
			return Math.random();
		}
	}
	 
	private boolean bonusPossible(int move, int stones) {
		//find if stones + current index = mancala index
		if (move + stones == 13) {
			return true;
		}
		return false;
	}

	private boolean capturePossible(int move, Board boardState) {
		//return true when capture of pieces on other side of board is possible
		//find space where final stone would end up
		int target = move + boardState.stones(move);
		//find space on opposite side of target
		int opp = boardState.getOppositeIndex(target);
		if (boardState.stones(target) == 0 && boardState.stones(opp) > 0) {
			return true;
		}
		return false;
	}
}