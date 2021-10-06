/*
 * TicTacToe class
 * @author Heidi
 */
public class TicTacToe
{
	private int game[][];

	//CONSTRUCTOR
	public TicTacToe()
	{
		game = new int[3][3];
		for (int a = 0; a < game.length; a++)
			for (int b = 0; b < game[a].length; b++)
				game[a][b] = 0;
	}

	//METHODS
	public String toString()
	{
		String string = "";
		for (int i = 0; i < 3; i++)
		{
			for (int j = 0; j < 3; j++)
			{
				if (game[i][j] == 1)
					string += "X";
				else if (game[i][j] == 2)
					string += "O";
				else 
					string += " ";	
				if (j != 2)
					string += " |";		
			}
			if (i != 2)
			string += "\n";		
		}
		string += "\n";
		return string;
	}

	//allows the user to input move 
	public void move(int playerName, int row, int column)
	{
		game[row][column] = playerName;
	}

	//Makes sure move is legal (in bounds)
	public boolean moveOk(int row, int column)
	{
		if (row < game.length && row >= 0 && column < game.length && column >= 0)
		{
			if (game[row][column] == 0)
				return true;
		}
		return false;
	}

	//Detects if player wins in a column manner
	public boolean winColumn()
	{
		for (int i = 0; i < 3; i++)
		{
			if ((game[0][i] == game[1][i]) && (game[1][i] == game[2][i]))
				if (game[0][i] == 1 || game[0][i] == 2)
					return true;
		}
		return false;
	}

	//Decides if player wins diagonally
	public boolean winDiagonal()
	{
		if ((game[0][0] == game[1][1]) && (game[1][1] == game[2][2]))
			if (game[0][0] == 1 || game[0][0] == 2)
				return true;
		// return false;
		if ((game[0][2] == game [1][1]) && (game[1][1] == game[2][0]))
				if (game[1][1] == 1 || game[1][1] == 2)
					return true;
		return false;
	}

	//Decides if player wins in a row manner
	private boolean winRow()
	{
		for (int i = 0; i < 3; i++)
		{
			if ((game[i][0] == game [i][1]) && (game[i][0] == game[i][2]))
				if (game[i][0] == 1 || game[i][0] == 2)
					return true;
		}
			return false;
	}

	//Declares if a player wins using above methods
	public boolean win()
	{
		if (winRow())
			return true;
		else if (winDiagonal())
			return true;
		else if (winColumn())
			return true;
		else
			return false;
	}

	//Decides if game is a tie
	public boolean tie()
	{
		if (!win())
		{
			for (int i = 0; i < game.length; i++)
			{
				for (int j = 0; j < game[i].length; j++)
				{
					if (game[i][j] ==  0)
						return false;
				}
			} 
		} 
		return true;
	}
}

