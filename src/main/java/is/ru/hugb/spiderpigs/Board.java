package is.ru.hugb.spiderpigs;

/**
 * Board
 *
 * This class has all of the logic behind the TicTacToe game
 *
 * @author SpiderPigs
 * @version 23/11/2013
 */
public class Board {

    private String[][] ticTacToeBoard;
    private String currentPlayer;
    private final int gameSize = 3;

    public Board(){
        ticTacToeBoard = new String[3][3];
        for(int i = 0; i < gameSize; i++) {
            for(int k = 0; k < gameSize; k++) {
                ticTacToeBoard[i][k] = "";
            }
        }
        currentPlayer = "X";
    }

    public Board(String[][] newBoard) {
        ticTacToeBoard = newBoard;
    }

    public String getCurrentPlayer() {
        return currentPlayer;
    }

    public void setCurrentPlayer(String currPlayer) {
        currentPlayer = currPlayer;
    }

    public String[][] getTicTacToeBoard() {
        return ticTacToeBoard;
    }

    public void setTicTacToeBoard(String[][] ticTacToeBoard) {
        this.ticTacToeBoard = ticTacToeBoard;
    }


    public boolean isBoardEmpty() {
        for(int i = 0; i < gameSize; i++) {
            for(int k = 0; k < gameSize; k++) {
                if(ticTacToeBoard[i][k] != null && !ticTacToeBoard[i][k].isEmpty()) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isFull() {
        for(int i = 0; i < 3; i++) {
            for(int a = 0; a < 3; a++) {
                if(ticTacToeBoard[i][a].isEmpty() || ticTacToeBoard[i][a] == null) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean someoneWinner() {

        // Horizontal
        for(int i = 0; i < 3; i++) {
            if(ticTacToeBoard[i][0] != null && !ticTacToeBoard[i][0].isEmpty()) {
                if( ticTacToeBoard[i][0].equals(ticTacToeBoard[i][1]) && ticTacToeBoard[i][0].equals(ticTacToeBoard[i][2]) ) {
                    return true;
                }
            }
        }

        // Vertical
        for(int i = 0; i < 3; i++) {
            if(ticTacToeBoard[0][i] != null && !ticTacToeBoard[0][i].isEmpty()) {
                if( (ticTacToeBoard[0][i].equals(ticTacToeBoard[1][i])) && (ticTacToeBoard[0][i].equals(ticTacToeBoard[2][i])) )
                {
                    return true;
                }
            }
        }

        // Diagonal - Left down to right
        if(ticTacToeBoard[0][0] != null && !ticTacToeBoard[0][0].isEmpty()) {
            if( ticTacToeBoard[0][0].equals(ticTacToeBoard[1][1]) && ticTacToeBoard[0][0].equals(ticTacToeBoard[2][2]) )
                return true;
        }

        // Diagonal - Right up to left
        if(ticTacToeBoard[0][2] != null && !ticTacToeBoard[0][2].isEmpty()) {
            if( ticTacToeBoard[0][2].equals(ticTacToeBoard[1][1]) && ticTacToeBoard[0][2].equals(ticTacToeBoard[2][0]) )
                return true;
        }
        return false;
    }

    public void clearBoard() {
        for(int i = 0; i < 3; i++) {
            for(int k = 0; k < 3; k++) {
                ticTacToeBoard[i][k] = "";
            }
        }
    }

    public void changePlayer() {
        if(currentPlayer.isEmpty()) {
            throw new IllegalArgumentException("The player variable can't be empty!");
        }

        if(currentPlayer.toLowerCase().equals("x")) {
            currentPlayer = "O";
        }
        else if(currentPlayer.toLowerCase().equals("o")) {
            currentPlayer = "X";
        }
        else {
            throw new IllegalArgumentException("Current player must be either X or O");
        }
    }
}
