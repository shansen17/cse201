public enum Player
{
	ONE, TWO;
	
	private Player opposite;
	
	static
	{
		ONE.opposite = Player.TWO;
		TWO.opposite = Player.ONE;
	}
	
	public Player opposite()
	{
		return this.opposite;
	}
}