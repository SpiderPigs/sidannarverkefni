package is.ru.hugb.spiderpigs;

/**
 * Created with IntelliJ IDEA.
 * User: Grimur
 * Date: 23.11.2013
 * Time: 11:45
 * To change this template use File | Settings | File Templates.
 */
public class Board {

    private String[][] ticTacToeBoard;

    private String currentPlayer;

    private int gameSize = 3;

    public Board(){
        ticTacToeBoard = new String[3][3];
        for(int i = 0; i < 3; i++)
            for(int k = 0; k < 3; k++)
                ticTacToeBoard[i][k] = null;

        currentPlayer = "X";

    }

    public Board(String[][] newBoard) {
        ticTacToeBoard = newBoard;
    }

    public String getCurrentPlayer()
    {
        return currentPlayer;
    }

    public void setCurrentPlayer(String currPlayer)
    {
        currentPlayer = currPlayer;
    }

    public String[][] getTicTacToeBoard() {
        return ticTacToeBoard;
    }

    public void newGame()
    {
        
        currentPlayer = "X";

        for(int i = 0; i < gameSize; i++)
        {   
            for(int k = 0; k < gameSize; k++)
            {
                ticTacToeBoard[i][k] = null;
            }
        }

        //countMoves = 0;
    }

    public void setTicTacToeBoard(String[][] ticTacToeBoard) {
        this.ticTacToeBoard = ticTacToeBoard;
    }

    public boolean isEmpty() {
        for(int i = 0; i < 3; i++)
            for(int k = 0; k < 3; k++)
                if(ticTacToeBoard[i][k] != null && !ticTacToeBoard[i][k].isEmpty())
                    return false;


        return true;
    }

    public boolean isFull() {
        for(int i = 0; i < 3; i++)
        {
            for(int a = 0; a < 3; a++)
            {
                if(ticTacToeBoard[i][a] == null || ticTacToeBoard[i][a].isEmpty()) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean someoneWinner() {

        // Vertical
        for(int i = 0; i < 3; i++)
        {
            if( (ticTacToeBoard[i][0] == ticTacToeBoard[i][1]) && (ticTacToeBoard[i][1] == ticTacToeBoard[i][2]) && (ticTacToeBoard[i][0] != null) )
            {
                return true;
            }
        }

        // Horizontal
        for(int i = 0; i < 3; i++)
        {
            if( (ticTacToeBoard[0][i] == ticTacToeBoard[1][i]) && (ticTacToeBoard[1][i] == ticTacToeBoard[2][i]) && (ticTacToeBoard[0][i] != null) )
            {
                return true;
            }
        }

        // Diagonal - Down
        if( (ticTacToeBoard[0][0] == ticTacToeBoard[1][1]) && (ticTacToeBoard[1][1] == ticTacToeBoard[2][2]) && (ticTacToeBoard[0][0] != null) )
            return true;

        // Diagonal - Up
        if( (ticTacToeBoard[0][2] == ticTacToeBoard[1][1]) && (ticTacToeBoard[1][1] == ticTacToeBoard[2][0]) && (ticTacToeBoard[0][2] != null) )
            return true;

        return false;
    }

    public void clearBoard() {
        for(int i = 0; i < 3; i++)
            for(int k = 0; k < 3; k++)
                ticTacToeBoard[i][k] = null;
    }

    public String changePlayer() {
        if(currentPlayer.isEmpty())
        {
            throw new IllegalArgumentException("The player variable can't be empty!");
        }

        if(currentPlayer == "X")
        {
            currentPlayer = "O";
            return currentPlayer;
        }
        else if(currentPlayer == "O")
        {
            currentPlayer = "X";
            return currentPlayer;
        }
        else {
            throw new IllegalArgumentException("Current player must be either X or O");
        }
    }
}
