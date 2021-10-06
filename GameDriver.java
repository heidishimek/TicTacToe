import java.util.*;

/* GameDriver - Client program that allows a user to play the Game TictacToe.
 * Main is the only method found here. Other static helper methods can 
 * be used to organize the statements in main.
 * @author : Heidi
 * 
 */
public class GameDriver 
{
	public static void main(String[] args)
	{
		TicTacToe board = new TicTacToe();
		int row;
		int column;
		Player player1, player2, thePlayer;
		Scanner scan = new Scanner(System.in);

		System.out.println("=======================");
		System.out.println("LET'S PLAY TIC TAC TOE!");
		System.out.println("=======================");
		System.out.println(board);

		
		System.out.println("> Enter the name of Player1:");
		String name = scan.nextLine();
		player1 = new Player(name);
		System.out.println("Welcome Player 1: "+player1.getName());
		System.out.println("> Enter the name of Player2:");
		String name2 = scan.nextLine();
		player2 = new Player(name2);
		System.out.println("Welcome Player 2: "+player2.getName());

		//Decides who goes first, randomly
		Random random = new Random();
		int x = random.nextInt(2) + 1;
		if (x == 2)
		{
			thePlayer = player1;
			player1 = player2;
			player2 = thePlayer;
		}
		else if (x ==1)
		{
			thePlayer = player2;
			player2 = player1;
			player1 = thePlayer;
		}
		System.out.println(player1.getName() + " goes first.");

		//Boolean to play
		boolean toPlay = true;
		while (toPlay)
		{
		//Unless someone wins, keeps asking players for moves, switches off
		// players and tells player when move is invalid
		x = 1;
		while (board.win() == false && board.tie() == false)
		{
			System.out.println(board);
			if (x == 1)
			{
				System.out.println(player1 + " Enter the row (0 - 2) and column (0 - 2) of your move: ");
				row = scan.nextInt(); column = scan.nextInt();
			}
			else
			{
				System.out.println(player2 + " Enter the row (0 - 2) and column (0 - 2) of your move: ");
				row = scan.nextInt(); column = scan.nextInt();
			}

			while(!board.moveOk(row, column))
			{
				System.out.println("Invalid. Enter the row (0 - 2) and column (0 - 2) of your move: ");
				row = scan.nextInt(); column = scan.nextInt();
			}

		board.move(x, row, column);

		if (x == 1)
			x = 2;
		else
			x = 1;

		}

		System.out.println(board);
		// tells player when someone has won or if the game is a tie
		if (board.tie() == false)
			System.out.print("Game is a tie.");
		else
		{
			if (x == 1)
			{
				System.out.println(player2.getName() + " wins the game!");
				player2.setWins();
				player1.setLosses();
			}
			else
			{
				System.out.println(player1.getName() + " wins the game!");
				player1.setWins();
				player2.setLosses();
			}
			//Ask to play again
      System.out.println("Do you want to play again? Enter y or n.");
      String again = scan.nextLine();
      if (again.equals("y"))
      {
        toPlay = true;
      }
     else
     {
        toPlay = false; 
        System.out.println(player1 + " Wins: "+ player1.getWins());
		System.out.println(player1 + " Losses: "+ player1.getLosses());
		System.out.println(player2 + " Wins: "+ player2.getWins());
		System.out.println(player2+ " Losses: "+ player2.getLosses());
	}


     
  	}
  }
}
}


