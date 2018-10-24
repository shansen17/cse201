/**
 * A way to represent two players without relying on numerical IDs.
 * 
 * @author CSE 201 Team B - Fall 2018
 * @version 1.0
 */
public enum Player
{
	ONE, TWO;
	
	private Player opposite;
	
	static
	{
		ONE.opposite = Player.TWO;
		TWO.opposite = Player.ONE;
	}
	
	/**
	 * Returns the opposite {@code Player} constant. On {@code Player.ONE}, this
	 * returns {@code Player.TWO} and <em>vice versa</em>.
	 * 
	 * @return opposite player
	 */
	public Player opposite()
	{
		return this.opposite;
	}
}