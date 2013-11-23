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

    public Board(){
        ticTacToeBoard = new String[3][3];
        for(int i = 0; i < 3; i++)
            for(int k = 0; k < 3; k++)
                ticTacToeBoard[i][k] = "0";
    }

    public Board(String[][] newBoard) {
        ticTacToeBoard = newBoard;
    }

    public String[][] getTicTacToeBoard() {
        return ticTacToeBoard;
    }

    public void setTicTacToeBoard(String[][] ticTacToeBoard) {
        this.ticTacToeBoard = ticTacToeBoard;
    }

    public boolean isEmpty() {
        for(int i = 0; i < 3; i++)
        {
            for(int a = 0; a < 3; a++)
            {
                if(ticTacToeBoard[i][a] != null) {
                    return false;
                }
            }
        }
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
            if( (ticTacToeBoard[i][0] == ticTacToeBoard[i][1]) && (ticTacToeBoard[i][1] == ticTacToeBoard[i][2]) && (ticTacToeBoard[i][0] != "0") )
            {
                return true;
            }
        }

        // Horizontal
        for(int i = 0; i < 3; i++)
        {
            if( (ticTacToeBoard[0][i] == ticTacToeBoard[1][i]) && (ticTacToeBoard[1][i] == ticTacToeBoard[2][i]) && (ticTacToeBoard[0][i] != "0") )
            {
                return true;
            }
        }

        // Diagonal - Down
        if( (ticTacToeBoard[0][0] == ticTacToeBoard[1][1]) && (ticTacToeBoard[1][1] == ticTacToeBoard[2][2]) && (ticTacToeBoard[0][0] != "0") )
            return true;

        // Diagonal - Up
        if( (ticTacToeBoard[0][2] == ticTacToeBoard[1][1]) && (ticTacToeBoard[1][1] == ticTacToeBoard[2][0]) && (ticTacToeBoard[0][2] != "0") )
            return true;

        return false;
    }
}
