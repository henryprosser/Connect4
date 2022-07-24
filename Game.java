import java.util.ArrayList;

/**
 * Game class used to control the running of the Connect4 game
 * @author Henry Prosser
 */

public class Game {

    // Instance fields
    private boolean win = false;
    private boolean draw = false;

    // Constructor
    public Game() {
        System.out.println("Welcome to Connect 4");
        System.out.println("There are 2 players red and yellow");
        System.out.println("Player 1 is Red, Player 2 is Yellow");
        System.out.println("To play the game type in the number of the column you want to drop your counter in");
        System.out.println("A player wins by connecting 4 counters in a row - vertically, horizontally or diagonally");
        System.out.println("");
        playGame();
    }

    // Method for running the game
    private void playGame() {
        Board board = new Board();
        Player player1 = new HumanPlayer("Red", 'r');
        Player player2 = new BotPlayer("Yellow", 'y');
        ArrayList<Player> players = new ArrayList<>();
        players.add(player1);
        players.add(player2);
        int currentPlayer = 0;
        board.printBoard();   

        while(!win && !draw){
            Player current = players.get(currentPlayer%2);
            try{
                String userInput = current.getUserInput();
                int move = Integer.parseInt(userInput);
                boolean placed = board.placeCounter(current.getPlayerCounter(),move);
                // If counter is not placed, repeat the go
                if(!placed){
                    currentPlayer--;
                }
                boolean hasWon = board.checkWin(current.getPlayerCounter());
                boolean isDraw = board.checkDraw();
                // Checks if current player has won
                if(hasWon){
                    win = true;
                    System.out.println("Player " + current.getPlayerName() + " wins!!!");
                }
                // Checks if the game is a draw
                else if(isDraw){
                    draw = true;
                    System.out.println("It's a draw!");
                }
            currentPlayer++;
            }

          /* Exception handling to catch for wrong inputs & prompts user to try again */
          catch(NumberFormatException | ArrayIndexOutOfBoundsException e){
              System.out.println("Invalid input. Please enter a valid column number");
          }
            
        }
    }
}
