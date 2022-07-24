/**
 * Board class used to print and check the status of the board
 * @author Henry Prosser
 */

public class Board {

    // Instance fields
    public char[][] board;

    // Constructor method
    public Board() {
        board = new char[6][7];
    }

    // Method for displaying the board
    public void printBoard() {
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[i].length; j++){
                if(board[i][j] == 'r'){
                    System.out.print("| r ");
                }
                else if(board[i][j] == 'y'){
                    System.out.print("| y ");
                }
                else{
                    System.out.print("|   ");
                }
            }
            System.out.println("|");
        }
        System.out.println("  1   2   3   4   5   6   7");
    }

    /**
     * Method for placing counters
     * @param player
     *       Player colour
     * @param position
     *       Column position on board
     */
    public boolean placeCounter(char player, int position) {
        boolean placed = false;
        if(checkFullColumn(position)){
            System.out.println("Column full. Please select another column.");
        }
        
        else{
        for(int i=board.length-1; i>=0; i--){
            if(!placed) {
                if(board[i][position-1] != 0){
            }
            else {
                board[i][position-1] = player;
                placed = true;
              }
            }
          }
        }
      return placed;
    }

    /**
     * Method for checking if a column is full
     * @param column
     *       Column on board
     * @return True if column full, False if not
     */
    public boolean checkFullColumn(int column) {
        if(board[0][column-1] != 0){
            return true;
        }
        else{
            return false;
        }
    }

    /**
     * Method for checking if game is a draw
     * @return True if all columns full, False if not
     */
    public boolean checkDraw() {
        int count = 0;
        boolean isDraw = false;
        for(int j=1; j<=board[0].length; j++){
            if(checkFullColumn(j)){
                count = count + 1;
            if(count >= 7){
                isDraw = true;
            }
          }
        }
        return isDraw;
    }

    /**
     * Method for checking if a player has won
     * @param counter
     *       Player counter
     * @return True if a player has won, False if not
     */
    public boolean checkWin(char counter) {
        int count = 0;
        boolean hasWon = false;
        // check horizontal
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[i].length; j++){
                if(board[i][j] == counter){
                    count = count + 1;
                    if(count >= 4){
                        hasWon = true;
                    }
                }
                else{
                    count = 0;
                }
            }
        }
        // check vertical
        count = 0;
        for(int i=0; i<board[0].length; i++){
            for(int j=0; j<board.length; j++){
                if(board[j][i] == counter){
                    count = count + 1;
                    if(count >= 4){
                        hasWon = true;
                    }
                }
                else{
                    count = 0;
                }
              }
            }

        // check diagonal from top left to bottom right (lower triangle)
        count = 0;
        for(int i_start=0; i_start<=board.length - 4; i_start++){
            for(int i=i_start, j=0; i<board.length && j<board[0].length; i++, j++){
                if(board[i][j] == counter){
                    count = count + 1;
                    if(count >= 4){
                        hasWon = true;
                  }
                }
                else{
                    count = 0;
                }
              }
            }

        // check diagonal from top left to bottom right (upper triangle)
        count = 0;
        for(int j_start=1; j_start<=board[0].length - 4; j_start++){
            for(int i=0, j=j_start; i<board.length && j<board[0].length; i++, j++){
                if(board[i][j] == counter){
                    count = count + 1;
                    if(count >= 4){
                        hasWon = true;
                    }
                }
                else{
                    count = 0;
                }
            }
        }

        // check diagonal from bottom left to top right (upper triangle)
        count = 0;
        for(int i_start=5; i_start>board.length - 4; i_start--){
            for(int i=i_start, j=0; i>=0 && j<board[0].length; i--, j++){
                if(board[i][j] == counter){
                    count = count + 1;
                    if(count >= 4){
                        hasWon = true;
                    }
                }
                else{
                    count = 0;
                }
            }
        }

        // check diagonal from bottom left to top right (lower triangle)
        count = 0;
        for(int j_start=1; j_start<=board[0].length - 4; j_start++){
            for(int i=5, j=j_start; i>=0 && j<board[0].length; i--, j++){
                if(board[i][j] == counter){
                    count = count + 1;
                    if(count >= 4){
                        hasWon = true;
                    }
                }
                else{
                    count = 0;
                }
            }
        }
          
      printBoard();
      
    return hasWon;
    }
  }