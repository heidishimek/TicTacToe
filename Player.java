/*
 *
 * @Heidi
 */
public class Player {
	// INSTANCE DATA: name, wins, losses
	private String playerName;
	private int loss;
	private int win;

	//CONSTRUCTOR
	public Player(String playerName)
	{
		loss = 0;
		win = 0;
		this.playerName = playerName;
	}

	// METHODS
	// getName(), setName(), getWins(), getLosses(), toString(), etc
	public String getName()
	{
		return playerName;
	}

	public String toString()
	{
		return getName();
	}

	public int getWins()
	{
		return win;
	}

	public int getLosses()
	{
		return loss;
	}

	public void setWins()
	{
		win++;
	}

	public void setLosses()
	{
		loss++;
	}
}
