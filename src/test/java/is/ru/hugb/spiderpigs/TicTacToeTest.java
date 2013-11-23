package is.ru.hugb.spiderpigs;
/**
 * Created with IntelliJ IDEA.
 * User: Grimur
 * Date: 22.11.2013
 * Time: 12:12
 * To change this template use File | Settings | File Templates.
 */

import org.junit.*;

import static junit.framework.Assert.*;

public class TicTacToeTest {


	private Board board;

	@Before
	public void setup() {
		board = new Board();
	}

	@Test
	public void isBoardEmpty() {
        board.setTicTacToeBoard(new String[3][3]);
		assertEquals(true, board.isEmpty());
	}
	@Test
	public void boardIsFull() {
        String[][] gameBoard = new String[3][3];

        for(int i = 0; i < 3; i++) {
            for(int a = 0; a < 3; a++) {
                gameBoard[i][a] = "T";
            }
        }

        board.setTicTacToeBoard(gameBoard);
        assertEquals(true, this.board.isFull());
	}

    @Test
    public void boardWasCleared() {
        String[][] gameBoard = new String[3][3];
        for(int i = 0; i < 3; i++) {
            for(int a = 0; a < 3; a++) {
                gameBoard[i][a] = "T";
            }
        }

        this.board.setTicTacToeBoard(gameBoard);
        this.board.clearBoard();

        assertEquals(true, this.board.isEmpty());
    }

    @Test
    public void tryToChangePlayerToX() {
        String player = "O";
        board.setCurrentPlayer(player);
        assertEquals("X", this.board.changePlayer());
    }

    @Test
    public void tryToChangePlayerToO() {
        String player = "X";
        board.setCurrentPlayer(player);
        assertEquals("O", this.board.changePlayer());
    }

    @Test(expected = IllegalArgumentException.class)
    public void tryToChangePlayerToNull() {
        String player = "";
        board.setCurrentPlayer(player);
        this.board.changePlayer();
    }

    @Test(expected = IllegalArgumentException.class)
    public void tryToChangePlayerToIllegalValue() {
        String player = "K";
        board.setCurrentPlayer(player);
        this.board.changePlayer();
    }

    @Test
    public void testY0HorizontalWin() {
        String[][] wonGame = new String[3][3];
        wonGame[0][0] = "X";
        wonGame[0][1] = "X";
        wonGame[0][2] = "X";
        board.setTicTacToeBoard(wonGame);
        assertEquals(true, this.board.someoneWinner());
    }

    @Test
    public void testY1HorizontalWin() {
        String[][] wonGame = new String[3][3];
        wonGame[1][0] = "X";
        wonGame[1][1] = "X";
        wonGame[1][2] = "X";
        board.setTicTacToeBoard(wonGame);
        assertEquals(true, this.board.someoneWinner());
    }

    @Test
    public void testY2HorizontalWin() {
        String[][] wonGame = new String[3][3];
        wonGame[2][0] = "X";
        wonGame[2][1] = "X";
        wonGame[2][2] = "X";
        board.setTicTacToeBoard(wonGame);
        assertEquals(true, this.board.someoneWinner());
    }

    @Test
    public void testX0Y0toX2Y2DiagonalWin() {
        String[][] wonGame = new String[3][3];
        wonGame[0][0] = "X";
        wonGame[1][1] = "X";
        wonGame[2][2] = "X";
        board.setTicTacToeBoard(wonGame);
        assertEquals(true, this.board.someoneWinner());
    }

    @Test
    public void testX2Y2toX0Y0DiagonalWin() {
        String[][] wonGame = new String[3][3];
        wonGame[2][2] = "X";
        wonGame[1][1] = "X";
        wonGame[0][0] = "X";
        board.setTicTacToeBoard(wonGame);
        assertEquals(true, this.board.someoneWinner());
    }

    @Test
    public void testY0VerticalWin() {
        String[][] wonGame = new String[3][3];
        wonGame[0][0] = "X";
        wonGame[1][0] = "X";
        wonGame[2][0] = "X";
        board.setTicTacToeBoard(wonGame);
        assertEquals(true, this.board.someoneWinner());
    }

    @Test
    public void testY1VerticalWin() {
        String[][] wonGame = new String[3][3];
        wonGame[0][1] = "X";
        wonGame[1][1] = "X";
        wonGame[2][1] = "X";
        board.setTicTacToeBoard(wonGame);
        assertEquals(true, this.board.someoneWinner());
    }

    @Test
    public void testY2VerticalWin() {
        String[][] wonGame = new String[3][3];
        wonGame[0][2] = "X";
        wonGame[1][2] = "X";
        wonGame[2][2] = "X";
        board.setTicTacToeBoard(wonGame);
        assertEquals(true, this.board.someoneWinner());
    }


}